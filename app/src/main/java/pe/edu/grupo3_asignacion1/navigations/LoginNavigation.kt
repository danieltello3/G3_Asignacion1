package pe.edu.grupo3_asignacion1.navigations

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.grupo3_asignacion1.ui.login.uis.CreateAccountScreen
import pe.edu.grupo3_asignacion1.ui.login.uis.LoginScreen
import pe.edu.grupo3_asignacion1.ui.login.uis.SplashScreen
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.CreateAccountViewModel
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.LoginViewModel
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.ResetPasswordViewModel
import pe.edu.grupo3_asignacion1.ui.login.uis.ResetPasswordScreen


@Composable
fun LoginNavigation(
    loginScreenViewModel: LoginViewModel,
    resetPasswordScreenViewModel: ResetPasswordViewModel,
    createAccountScreenViewModel: CreateAccountViewModel
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val parameter = navBackStackEntry?.arguments?.getString("parameter")
    val optionalParameter = navBackStackEntry?.arguments?.getString("optionalParameter")

    NavHost(
        navController = navController,
        startDestination = "/login" //Splash Screen
    ){
        composable(
            route = "/login/{parameter}?optionalParameter={optionalParameter}",
            arguments = listOf(
                navArgument("parameter") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("optionalParameter") {
                    type = NavType.StringType
                    defaultValue = "default_value"
                }
            )
        ){ entry ->
            if(parameter == null || parameter == ""){
                LoginScreen(
                    loginScreenViewModel,
                    goToResetPasswordScreen = {
                        navController.navigate("/reset_password")
                    },
                    goToCreateAccountScreen = {
                        navController.navigate("/create_account")
                    }
                )
            }else{
                loginScreenViewModel.updateUsuario(parameter)
                LoginScreen(
                    loginScreenViewModel,
                    goToResetPasswordScreen = {
                        navController.navigate("/reset_password")
                    },
                    goToCreateAccountScreen = {
                        navController.navigate("/create_account")
                    }
                )
            }
        }
        //Navegación de la pantalla Login
        composable(
            route = "/login",
            arguments = listOf()
        ){ entry ->
            Log.d("pe.edu.g3_asignacion", "LoginScreen LoginNavigation")
            LoginScreen(
                loginScreenViewModel,
                goToResetPasswordScreen = {
                    navController.navigate("/reset_password")
                },
                goToCreateAccountScreen = {
                    navController.navigate("/create_account")
                }

            )
        }

        //Navegación de la pantalla Restablecer Contraseña
        composable(
            route = "/reset_password",
            arguments = listOf()
        ){ entry ->
            Log.d("pe.edu.g3_asignacion", "ResetPasswordScreen LoginNavigation")
            ResetPasswordScreen(
                resetPasswordScreenViewModel,
                goToLoginScreen = {
                    navController.navigate("/login")
                },
                goToCreateAccountScreen = {
                    navController.navigate("/create_account")
                }

            )
        }

        //Navegacion de la pantalla Crear Cuenta
        composable(
            route = "/create_account",
            arguments = listOf()
        ){ entry ->
            Log.d("pe.edu.g3_asignacion", "CreateAccount LoginNavigation")
            CreateAccountScreen(
                createAccountScreenViewModel,
                goToResetPasswordScreen = {
                    navController.navigate("/reset_password")
                },
                goToLoginScreen = {
                    navController.navigate("/login")
                }
            )

        }
    }
}