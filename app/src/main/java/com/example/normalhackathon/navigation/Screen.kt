package com.example.normalhackathon.navigation

import com.example.normalhackathon.R
import com.example.normalhackathon.utils.Constants

const val ARGUMENT_FIO = "fio"

const val ROOT_GRAPH_ROUTE = "root"
const val LAUNCHER_ROUTE = "launcher"
const val LOGIN_ROUTE = "login"
const val MAIN_ROUTE = "main"
const val OPEN_EVENT_ROUTE = "open_event"

sealed class Screen(val route:String) {
    object Launcher: Screen(route = "launcher_screen")
    object Login: Screen(route = "login_screen")
    object Event:Screen(route = "event_screen")
    object Nomination:Screen(route = "nomination")
    object InformationEvent:Screen(route = "information_event_screen")
    object InformationUser:Screen(route = "information_user_screen")
    object Rating:Screen(route = "rating_screen")
    object Profile:Screen(route = "login_screen?fio={fio}"){
        fun passFIO(
            fio:String
        ): String {
            return "login_screen?fio=$fio"
        }
    }
    object ListParticipant:Screen(route = "lust_participant_screen")
}

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Event : BottomBarScreen(
        route = Screen.Event.route,
        title = "Event",
        icon = R.drawable.ic_baseline_home_24
    )

    object Rating : BottomBarScreen(
        route = Screen.Rating.route,
        title = "Rating",
        icon = R.drawable.ic_baseline_notes_24
    )

    object Profile : BottomBarScreen(
        route = Screen.Profile.passFIO(Constants.userName),
        title = "Profile",
        icon = R.drawable.ic_baseline_account_box_24
    )
}