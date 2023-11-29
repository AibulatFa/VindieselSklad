package com.navigation


sealed class Screen(val route: String){
    object start: Screen("Start")
    object raspilitel: Screen("Распылитель")
    object klapan: Screen("Клапан")
    object electromag: Screen("Электромагнитный")
    object teflonka: Screen("Тэлефонка")
    object sharklapana: Screen("Шар клапана")
    object gidrokompensator: Screen("Гидро компенсатор")
    object gaika: Screen("Гайка")
    object medshaiba: Screen("Медная шайба")
    object Rbosch: Screen("v")
    object Rdenso: Screen("Denso")
    object Rliwei: Screen("Liwei")
    object Rdelphi: Screen("Delphi")
    object Rgreenpower: Screen("GreenPower")



}