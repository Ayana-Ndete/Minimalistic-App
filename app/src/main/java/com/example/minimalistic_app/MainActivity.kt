package com.example.minimalistic_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.triStateToggleable
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minimalistic_app.ui.theme.MInimalistic_appTheme

   class MainActivity: ComponentActivity() {

      override fun onCreate(savedInstanceState : Bundle?){
         super.onCreate(savedInstanceState)

         setContent{
            MInimalistic_appTheme {
               ScrollStopHome()
            }
         }
      }
}
@Composable
fun ScrollStopHome() {

   var selectedApp by remember {
      mutableStateOf("No app selected")
   }

   var timeLimit by remember {
      mutableStateOf("30 Minutes")

   }
   var todayUsage by remember {
      mutableStateOf("0 min")
   }

   Surface(
      modifier = Modifier.fillMaxSize()

   ){
      Column(
          Modifier.fillMaxSize().padding(24.dp),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
      ) {
         Text(
            text = " Minimalistic",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
         )
         Text(
            text = "Reduce Doomscrolling",
            fontSize = 16.sp
         )

         Spacer(modifier = Modifier.height(36.dp))

         Text(
            text = "Selected App",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
         )
         Text(
            text = selectedApp,
            fontSize = 20.sp
         )
         Spacer(modifier = Modifier.height(24.dp))

         Text(
               text = "Daily Limit",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
         )
         Text(
            text = timeLimit,
            fontSize = 20.sp
         )

         Spacer(modifier = Modifier.height(24.dp))

         Text(
            text = "Today's Usage",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold

         )
         Text(
            text = "$todayUsage / $timeLimit",
            fontSize = 20.sp
         )
         Spacer(modifier = Modifier.height(12.dp))

         LinearProgressIndicator(
            progress = 0.0f,
            modifier = Modifier.fillMaxWidth()
         )
         Spacer(modifier = Modifier.height(36.dp))

         Button(
            onClick = {
               selectedApp = "Instagram"

            },
            modifier = Modifier.fillMaxWidth()
         ) {
            Text("Selected App")
         }
         Spacer(modifier = Modifier.height(12.dp))

         Button(
            onClick = {
               timeLimit = "15 min"
            },
            modifier = Modifier.fillMaxWidth()
         ){
            Text(" Set Daily Limit")
         }
         Spacer(modifier = Modifier.height(16.dp))
         Button(
            onClick = {

            },
            modifier = Modifier.fillMaxWidth()
         )  {
            Text(" Start Protection")
         }
      }
   }
}