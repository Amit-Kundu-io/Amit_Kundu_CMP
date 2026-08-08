# CMP Web Deployment — Render

## 1. Build Locally

### Windows

```bash
.\gradlew.bat :webApp:wasmJsBrowserDistribution
```

### Linux/macOS

```bash
./gradlew :webApp:wasmJsBrowserDistribution
```

Production files are generated at:

```text
webApp/build/dist/wasmJs/productionExecutable/
```

---

## 2. Push Production Build

Because `build/` is usually ignored by Git:

```bash
git add -f webApp/build/dist/wasmJs/productionExecutable
```

Then:

```bash
git commit -m "Update web build"
git push origin main
```

Verify GitHub contains:

```text
webApp/build/dist/wasmJs/productionExecutable/
├── index.html
├── *.js
├── *.wasm
└── resources/
```

---

## 3. Render Static Site

**Build Command:**

```bash
echo "Using prebuilt CMP Web"
```

**Publish Directory:**

```text
webApp/build/dist/wasmJs/productionExecutable
```

⚠️ Do **not** add `/index.html` to the Publish Directory.

---

## 4. Future Deployments

Every time you change the CMP code:

```bash
.\gradlew.bat :webApp:wasmJsBrowserDistribution
git add -f webApp/build/dist/wasmJs/productionExecutable
git commit -m "Update web build"
git push origin main
```

Render automatically deploys the updated website.

## Flow

```text
CMP Code
   ↓
Local Build
   ↓
productionExecutable
   ↓
Git Push
   ↓
GitHub
   ↓
Render Static Site
   ↓
Website
```
