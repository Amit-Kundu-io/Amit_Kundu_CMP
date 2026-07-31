# 🌐 Portfolio Website | Compose Multiplatform (CMP)

A modern, responsive personal portfolio website built with **Kotlin** and **Compose Multiplatform (Wasm)** to showcase my projects, skills, and experience.

## ✨ Features

- 🎨 Modern UI with Compose Multiplatform
- ⚡ WebAssembly (Wasm) support
- 📱 Responsive design
- 🌙 Smooth animations
- 🚀 Optimized for performance

## 🛠 Tech Stack

- Kotlin
- Compose Multiplatform
- WebAssembly (Wasm)
- Material 3

## 📦 Prerequisites

- JDK 21+
- Git
- Gradle (or use the included Gradle Wrapper)

## 🚀 Run Locally

### 1. Clone the repository

```bash
git clone https://github.com/your-username/Portfolio_CMP.git
cd Portfolio_CMP
```

### 2. Run the development server

```bash
./gradlew :webApp:wasmJsBrowserDevelopmentRun
```

## 🏗 Build for Production

```bash
./gradlew :webApp:wasmJsBrowserDistribution
```

The production files will be generated in:

```
webApp/build/dist/wasmJs/productionExecutable
```
