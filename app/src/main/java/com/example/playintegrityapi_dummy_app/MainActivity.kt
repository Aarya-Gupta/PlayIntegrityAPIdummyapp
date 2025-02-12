package com.example.playintegrityapi_dummy_app

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playintegrityapi_dummy_app.ui.theme.PlayIntegrityAPIdummyappTheme
import com.google.android.gms.tasks.Task
import com.google.android.play.core.integrity.IntegrityManager
import com.google.android.play.core.integrity.IntegrityManagerFactory
import com.google.android.play.core.integrity.IntegrityTokenRequest
import com.google.android.play.core.integrity.IntegrityTokenResponse

//import com.google.android.play.integrity.IntegrityManager
//import com.google.android.play.integrity.IntegrityManagerFactory
//import com.google.android.play.integrity.IntegrityTokenRequest
//import com.google.android.play.integrity.IntegrityTokenResponse

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlayIntegrityAPIdummyappTheme {
                IntegrityCheckScreen()
            }
        }
    }

    @Composable
    fun IntegrityCheckScreen() {
        var result by remember { mutableStateOf("Press the button to check integrity") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = result, modifier = Modifier.padding(bottom = 16.dp))

            Button(onClick = { requestPlayIntegrityCheck { result = it } }) {
                Text(text = "Check Play Integrity")
            }
        }
    }

    private fun requestPlayIntegrityCheck(onResult: (String) -> Unit) {
        val cloudProjectNumber = 968839675867 // Replace with actual Cloud Project Number
        if (cloudProjectNumber == 123L) {
            onResult("Error: Replace YOUR_CLOUD_PROJECT_NUMBER with a valid number")
            return
        }

        val integrityManager: IntegrityManager = IntegrityManagerFactory.create(this)
        val request = IntegrityTokenRequest.builder()
            .setCloudProjectNumber(cloudProjectNumber)
            .build()

        val response: Task<IntegrityTokenResponse> = integrityManager.requestIntegrityToken(request)

        response.addOnSuccessListener { integrityTokenResponse ->
            val integrityToken = integrityTokenResponse.token()
            onResult("Token Received: $integrityToken")
            Log.d("PlayIntegrity", "Token: $integrityToken")
        }

        response.addOnFailureListener { e ->
            onResult("Integrity check failed: ${e.message}")
            Log.e("PlayIntegrity", "Error: ${e.message}", e)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIntegrityCheckScreen() {
    PlayIntegrityAPIdummyappTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Press the button to check integrity", modifier = Modifier.padding(bottom = 16.dp))
            Button(onClick = {}) {
                Text(text = "Check Play Integrity")
            }
        }
    }
}
