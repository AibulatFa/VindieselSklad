package com.screens.raspilitel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.navigation.Screen


@Composable
fun RaspilitelScreen(navController: NavHostController) {
    Text("Распылитель", modifier = Modifier.fillMaxWidth(1f) ,  fontSize=22.sp, textAlign = TextAlign.Center)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextButton(
                onClick = { navController.navigate(Screen.Rbosch.route) }
            ) {
                Text("Bosch", fontSize = 30.sp)
            }

            TextButton(
                onClick = { navController.navigate(Screen.Rdenso.route) }
            ) {
                Text("Denso", fontSize = 30.sp)
            }

            TextButton(
                onClick = { navController.navigate(Screen.Rliwei.route) }
            ) {
                Text("Liwei", fontSize = 30.sp)
            }
            TextButton(
                onClick = { navController.navigate(Screen.Rdelphi.route) }
            ) {
                Text("Delphi", fontSize = 30.sp)
            }
            TextButton(
                onClick = { navController.navigate(Screen.Rgreenpower.route) }
            ) {
                Text("Green power", fontSize = 30.sp)
            }
        }
    }

}