package com.example.biometric_auth


object RustVault {
    init {
        System.loadLibrary("rustvault") // must match lib name from Rust
    }

    external fun encryptText(input: String, key: String): String
    external fun decryptText(input: String, key: String): String

}
