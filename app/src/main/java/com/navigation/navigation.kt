package com.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.screens.StartScreen
import com.screens.electromag.ElectromagScreen
import com.screens.gaika.GaikaScreen
import com.screens.gidrokompensator.GidrokompensatorScreen
import com.screens.klapan.klapanScreen
import com.screens.medshaiba.MedshaibaScreen
import com.screens.raspilitel.RBoschScreen
import com.screens.raspilitel.RDensoScreen
import com.screens.raspilitel.RLiweiScreen
import com.screens.raspilitel.RaspilitelScreen
import com.screens.raspilitel.RdelphiScreen
import com.screens.raspilitel.RgreenpowerScreen

import com.screens.sharklapana.SharklapanaScreen
import com.screens.teflonka.TeflonkaScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.start.route) {
        composable(Screen.start.route) {
            StartScreen(navController = navController)
        }
        composable(Screen.start.route) { StartScreen(navController = navController) }
        composable(Screen.raspilitel.route) { RaspilitelScreen(navController = navController) }
        composable(Screen.klapan.route) { klapanScreen(navController = navController) }
        composable(Screen.electromag.route) { ElectromagScreen(navController = navController) }
        composable(Screen.teflonka.route) { TeflonkaScreen(navController = navController) }
        composable(Screen.sharklapana.route) { SharklapanaScreen(navController = navController) }
        composable(Screen.gidrokompensator.route) { GidrokompensatorScreen(navController = navController) }
        composable(Screen.gaika.route) { GaikaScreen(navController = navController) }
        composable(Screen.medshaiba.route) { MedshaibaScreen(navController = navController) }
        composable(Screen.Rbosch.route) { RBoschScreen(navController = navController) }
        composable(Screen.Rdenso.route) { RDensoScreen(navController = navController) }
        composable(Screen.Rliwei.route) { RLiweiScreen(navController = navController) }
        composable(Screen.Rdelphi.route) { RdelphiScreen(navController = navController) }
        composable(Screen.Rgreenpower.route) { RgreenpowerScreen(navController = navController) }
    }
}