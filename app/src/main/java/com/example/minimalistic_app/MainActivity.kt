package com.example.minimalistic_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.minimalistic_app.model.AppInfo
import com.example.minimalistic_app.screens.AppSelectionScreen
import com.example.minimalistic_app.ui.theme.MInimalistic_appTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      setContent {
         MInimalistic_appTheme {
            MinimalisticApp()
         }
      }
   }
}

@Composable
fun MinimalisticApp() {

   var currentScreen by remember { mutableStateOf("home") }
   var selectedApp by remember { mutableStateOf<AppInfo?>(null) }
   var timeLimit by remember { mutableStateOf("30 min") }

   val sampleApps = listOf(
      AppInfo("Instagram", "com.instagram.android"),
      AppInfo("TikTok", "com.zhiliaoapp.musically"),
      AppInfo("YouTube", "com.google.android.youtube"),
      AppInfo("Chrome", "com.android.chrome"),
      AppInfo("Facebook", "com.facebook.katana"),
      AppInfo("WhatsApp", "com.whatsapp")
   )

   if (currentScreen == "home") {
      HomeScreen(
         selectedAppName = selectedApp?.name ?: "No app selected",
         timeLimit = timeLimit,
         onSelectAppClick = {
            currentScreen = "select_app"
         }
      )
   } else {
      AppSelectionScreen(
         apps = sampleApps,
         onAppSelected = { app ->
            selectedApp = app
            currentScreen = "home"
         }
      )
   }
}

@Composable
fun HomeScreen(
   selectedAppName: String,
   timeLimit: String,
   onSelectAppClick: () -> Unit
) {
   androidx.compose.material3.Surface(
      modifier = androidx.compose.ui.Modifier.fillMaxSize()
   ) {
      androidx.compose.foundation.layout.Column(
         modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(24.dp),
         horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
         verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
      ) {
         androidx.compose.material3.Text(
            text = "ScrollStop",
            fontSize = 34.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
         )

         androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.ui.Modifier.height(36.dp))

         androidx.compose.material3.Text(text = "📱 Selected App", fontSize = 18.sp)
         androidx.compose.material3.Text(text = selectedAppName, fontSize = 20.sp)

         androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.ui.Modifier.height(24.dp))

         androidx.compose.material3.Text(text = "⏰ Daily Limit", fontSize = 18.sp)
         androidx.compose.material3.Text(text = timeLimit, fontSize = 20.sp)

         androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.ui.Modifier.height(36.dp))

         androidx.compose.material3.Button(
            onClick = onSelectAppClick,
            modifier = androidx.compose.ui.Modifier.fillMaxWidth()
         ) {
            androidx.compose.material3.Text("Select App")
         }
      }
   }
}