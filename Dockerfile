# ---------- Build Stage ----------
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

COPY . .

RUN chmod +x gradlew
RUN ./gradlew :webApp:wasmJsBrowserDistribution

# ---------- Runtime Stage ----------
FROM nginx:alpine

COPY --from=builder /app/webApp/build/dist/wasmJs/productionExecutable/ /usr/share/nginx/html/

COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]