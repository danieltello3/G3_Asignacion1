package pe.edu.grupo3_asignacion1.navigations

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
    resetPasswordScreenViewModel: ResetPasswordViewModel,
    loginScreenViewModel: LoginViewModel,
    createAccountScreenViewModel: CreateAccountViewModel
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val parameter = navBackStackEntry?.arguments?.getString("parameter")
    val optionalParameter = navBackStackEntry?.arguments?.getString("optionalParameter")

    NavHost(
        navController = navController,
        startDestination = "/" //Splash Screen
    ){
        //Login pagina principal
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
            //Si no hay parametros: route = /login/
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
            }else{ //si hay parámetros: /login/sth else
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

        //Navegación de pantalla Splash (osea, no hay navegación xd)
        composable(
            route = "/",
            arguments = listOf()
        ){ entry ->
            SplashScreen(
                navController
            )
        }

        //Navegación de la pantalla Restablecer Contraseña
        composable(
            route = "/reset_password",
            arguments = listOf()
        ){ entry ->

            ResetPasswordScreen(
                resetPasswordScreenViewModel,
                goToLoginScreen = {
                    val parameter = resetPasswordScreenViewModel.correo.value.toString()
                    navController.navigate("/login/$parameter")
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
            CreateAccountScreen(
                createAccountScreenViewModel,
                goToResetPasswordScreen = {
                    navController.navigate("/reset_password")
                },
                goToLoginScreen = {
                    navController.navigate("/home_screen")
                }
            )

        }
    }
}