# syntax=docker/dockerfile:1.7

# =============================================================================
# Build Stage
# =============================================================================
FROM node:22-bookworm AS builder

# Install Java 21 and required native libraries for Kotlin/Wasm
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
        openjdk-21-jdk \
        libatomic1 \
        ca-certificates \
        git && \
    rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH="${JAVA_HOME}/bin:${PATH}"

WORKDIR /app

# Copy Gradle files first for better layer caching
COPY gradlew .
COPY gradle gradle
COPY settings.gradle.kts .
COPY build.gradle.kts .
COPY gradle.properties .
COPY gradle/libs.versions.toml gradle/libs.versions.toml

RUN chmod +x gradlew

# Download Gradle dependencies (cached layer)
RUN --mount=type=cache,target=/root/.gradle \
    ./gradlew help --no-daemon

# Copy the remaining source
COPY . .

# Build the production Wasm website
RUN --mount=type=cache,target=/root/.gradle \
    ./gradlew :webApp:wasmJsBrowserDistribution --no-daemon

# =============================================================================
# Runtime Stage
# =============================================================================
FROM nginx:1.28-alpine

# Remove default nginx site
RUN rm -f /etc/nginx/conf.d/default.conf

COPY nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=builder \
    /app/webApp/build/dist/wasmJs/productionExecutable/ \
    /usr/share/nginx/html/

EXPOSE 80

HEALTHCHECK --interval=30s --timeout=5s \
CMD wget --spider -q http://127.0.0.1/ || exit 1

CMD ["nginx", "-g", "daemon off;"]