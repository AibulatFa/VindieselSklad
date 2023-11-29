package com.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.vindieselsklad.R
import com.navigation.Screen


@Composable
fun StartScreen(navController: NavHostController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Первый ряд иконок
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    IconWithLabel(
                        onClick = { navController.navigate(Screen.raspilitel.route) },
                        iconResId = R.drawable.forsunka,
                        label = "Распылитель"
                    )

                    IconWithLabel(
                        onClick = { navController.navigate(Screen.klapan.route) },
                        iconResId = R.drawable.klapan,
                        label = "Клапан"
                    )

                    IconWithLabel(
                        onClick = { navController.navigate(Screen.electromag.route) },
                        iconResId = R.drawable.vilka4,
                        label = "Электрамгнит"
                    )
                }
            }

            // Второй ряд иконок
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                IconWithLabel(
                    onClick = { navController.navigate(Screen.teflonka.route) },
                    iconResId = R.drawable.teflonka,
                    label = "Тэфлонка"
                )

                IconWithLabel(
                    onClick = { navController.navigate(Screen.sharklapana.route) },
                    iconResId = R.drawable.sfera3,
                    label = "Шар"
                )

                IconWithLabel(
                    onClick = { navController.navigate(Screen.gidrokompensator.route) },
                    iconResId = R.drawable.cilind,
                    label = "Гидрокомпенсатор"
                )
            }
        }
    }
}

@Composable
fun IconWithLabel(
    onClick: () -> Unit,
    iconResId: Int,
    label: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier.size(100.dp)
        ) {
            Icon(
                painter = painterResource(iconResId),
                contentDescription = label
            )
        }

        Text(
            text = label,
            style = MaterialTheme.typography.body1
        )
    }
}
