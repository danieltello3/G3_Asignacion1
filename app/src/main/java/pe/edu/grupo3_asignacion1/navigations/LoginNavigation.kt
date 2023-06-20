
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
import pe.edu.grupo3_asignacion1.ui.asignacion1.uis.PerfilScreen
import pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels.PerfilViewModel
import pe.edu.grupo3_asignacion1.ui.login.uis.CreateAccountScreen
import pe.edu.grupo3_asignacion1.ui.login.uis.LoginScreen
import pe.edu.grupo3_asignacion1.ui.login.uis.SplashScreen
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.CreateAccountViewModel
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.LoginViewModel
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.ResetPasswordViewModel
import pe.edu.grupo3_asignacion1.ui.login.uis.ResetPasswordScreen
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.SplashViewModel


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
    val indexId = navBackStackEntry?.arguments?.getInt("index_id")
    val userId = navBackStackEntry?.arguments?.getInt("user_id")

    NavHost(
        navController = navController,
        startDestination = "/login"
    ){
//        composable(
//            route = "/splash",
//            arguments = listOf(
//            )
//        ){
//            SplashScreen(
//                viewModel = SplashViewModel(),
//                navController
//            )
//        }
        /*
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
                    },
                    navController
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
                    },
                    navController
                )
            }
        }
        */

//        composable(
//            route="/profile",
//            arguments = listOf(
//            )
//        ){
//            PerfilScreen(
//                viewModel = PerfilViewModel(),
//                navController,
//                1
//            )
//        }
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
                },
                navController
            )
        }

        //Navegación de la pantalla Login
        composable(
            route = "/",
            arguments = listOf()
        ){ entry ->
            Log.d("/","ENTRA AQUI")
            SplashScreen(
                viewModel = SplashViewModel(),
                navController
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
                },
                navController

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
                },
                navController
            )

        }
    }
}
