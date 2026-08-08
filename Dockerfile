# syntax=docker/dockerfile:1.7

FROM eclipse-temurin:21-jdk AS builder

RUN apt-get update && \
    apt-get install -y \
        curl \
        git \
        libatomic1 && \
    curl -fsSL https://deb.nodesource.com/setup_22.x | bash - && \
    apt-get install -y nodejs && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew :webApp:jsBrowserDistribution --no-daemon

FROM nginx:alpine

COPY nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=builder \
    /app/webApp/build/dist/js/productionExecutable/ \
    /usr/share/nginx/html/

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
