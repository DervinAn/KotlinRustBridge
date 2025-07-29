package com.example.biometric_auth

import android.R.id.input
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biometric_auth.ui.theme.BiometricauthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BiometricauthTheme {
                VaultScreen()
            }
        }
    }
}

@Composable
fun VaultScreen() {
    var inputText by remember { mutableStateOf("") }
    var encryptionKey by remember { mutableStateOf("") }
    var encryptedResult by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Rust Encryptor", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Text to Encrypt") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = encryptionKey,
            onValueChange = { encryptionKey = it },
            label = { Text("Encryption Key") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))



        Button(onClick = {
            encryptedResult = RustVault.encryptText(inputText, encryptionKey)
        }) {
            Text("Encrypt")
        }

        Spacer(Modifier.height(8.dp))

        Button(onClick = {
            encryptedResult = RustVault.decryptText(inputText,encryptionKey)
        }) {
            Text("Decrypt")
        }


        Spacer(modifier = Modifier.height(16.dp))

        Text("Encrypted Output:")
        Text(encryptedResult)
    }
}
