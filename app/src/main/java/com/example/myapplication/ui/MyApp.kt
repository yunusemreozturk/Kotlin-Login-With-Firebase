package com.example.myapplication.ui


import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.ui.screens.ContentScreen
import com.example.myapplication.ui.screens.HomeScreen
import com.example.myapplication.ui.screens.login.LoginScreen
import com.example.myapplication.ui.components.MyAppBar
import com.google.firebase.Firebase
import com.google.firebase.database.database
import com.google.firebase.database.ktx.database


enum class MyAppScreens(@StringRes val title: Int) {
    Login(title = R.string.login),
    Home(title = R.string.home),
    Content1(title = R.string.content1),
    Content2(title = R.string.content2),
    Content3(title = R.string.content3),
    Content4(title = R.string.content4),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(navController: NavHostController = rememberNavController()) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        MyAppScreens.valueOf(backStackEntry?.destination?.route ?: MyAppScreens.Login.name)


    Scaffold(topBar = {
        MyAppBar(
            currentScreen = currentScreen,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() }
        )
    }) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = MyAppScreens.Login.name
        ) {
            composable(route = MyAppScreens.Login.name) {
                LoginScreen(onPressedSignInButton = {
                    navController.navigate(MyAppScreens.Home.name) {
                        popUpTo(0)
                    }
                })
            }

            composable(route = MyAppScreens.Home.name) {
                HomeScreen(onCardClick = { navController.navigate(MyAppScreens.values()[it + 2].name) })
            }

            composable(route = MyAppScreens.Content1.name) {
                ContentScreen(
                    contentString = MyAppScreens.Content1.name,
                )
            }

            composable(route = MyAppScreens.Content2.name) {
                ContentScreen(
                    contentString = MyAppScreens.Content2.name,
                )
            }

            composable(route = MyAppScreens.Content3.name) {
                ContentScreen(
                    contentString = MyAppScreens.Content3.name,
                )
            }

            composable(route = MyAppScreens.Content4.name) {
                ContentScreen(
                    contentString = MyAppScreens.Content4.name,
                )
            }
        }
    }
}