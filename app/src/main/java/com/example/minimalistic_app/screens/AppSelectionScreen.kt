package com.example.minimalistic_app.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minimalistic_app.model.AppInfo

@Composable
fun AppSelectionScreen(
    apps: List<AppInfo>,
    onAppSelected: (AppInfo) -> Unit
)
{
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)

    ){
        Text(
            text = "Select an App",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer( modifier = Modifier.height(16.dp))

        LazyColumn {
            items(apps) {  app ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp).clickable{
                        onAppSelected(app)
                    }
                )
                {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text  = app.name,
                            fontSize = 18.sp
                        )
                        Text(
                            text = app.packageName,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}