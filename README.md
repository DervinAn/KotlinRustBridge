# 🔐 RustCryptCompose

A blazing-fast Android app that combines the power of **Kotlin + Jetpack Compose UI** with the performance and safety of **Rust-based encryption** via **JNI**.

> A beautiful fusion of modern UI and native performance – built with Rust and Kotlin.

---

## 🚀 Overview

**RustCryptCompose** is a demonstration of how to build secure Android apps using a hybrid approach:
- 🌐 **Jetpack Compose** handles modern declarative UI.
- ⚙️ **Rust** handles the cryptographic logic for AES-CTR encryption.
- 🔗 **JNI** bridges both worlds securely and efficiently.

---

## 🧠 Tech Stack

| Layer         | Technology                        |
|---------------|------------------------------------|
| UI Layer      | [Jetpack Compose](https://developer.android.com/jetpack/compose) |
| Language      | Kotlin + Rust                     |
| Native Bridge | JNI (Java Native Interface)        |
| Crypto Engine | Rust with `aes`, `ctr`, `sha2`, and `base64` crates |
| Build Tools   | `cargo-ndk`, Gradle                |

---

## 📱 How It Works

1. 📦 Kotlin UI (Compose) captures user input (text + encryption key).
2. 🚀 Kotlin calls a native Rust function using JNI: `encryptText(...)`.
3. 🧊 Rust encrypts the input using AES-CTR and SHA256-derived key.
4. 📤 Rust returns a base64-encoded encrypted string back to Kotlin.
5. 🖼️ Jetpack Compose updates the UI with the result.

---

## 🗂️ Project Structure
```text
project-root/
├── app/ # Android app (Kotlin + Compose)
│ ├── MainActivity.kt
│ ├── RustVault.kt # Kotlin JNI interface
│ └── jniLibs/ # Generated .so native libs
├── rustvault/ # Rust native library
│ ├── src/
│ │ ├── functions/ # Encryption logic
│ │ └── jni/ # JNI bridge
│ └── Cargo.toml
```

## 🔧 Building the Project

### Prerequisites
- [Rust](https://rust-lang.org) + `cargo-ndk`
- Android Studio + Android SDK
- `NDK` installed via Android Studio

### Step 1: Install Rust Target + Cargo NDK

```bash
rustup target add aarch64-linux-android armv7-linux-androideabi
cargo install cargo-ndk
```

Step 2: Build the Rust Library

```bash
cd rustvault
cargo ndk -t arm64-v8a -t armeabi-v7a -o ../app/src/main/jniLibs build --release
```

Step 3: Open Android Project in Android Studio
Sync Gradle
Connect a device or emulator (ARM-based)
Run the app!
🧪 Try It Out

Enter any text and encryption key.
Tap Encrypt.
View the base64 encrypted output powered by native Rust.
💡 Why This Matters

✅ This project shows how to:

Use Rust to build high-performance, safe native code.
Integrate Rust with Kotlin using JNI.
Keep UI and business logic cleanly separated.
Prepare for multi-platform code reuse (iOS, backend, etc.).



