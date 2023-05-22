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
import pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.uis.ProfileEditScreen
import pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.viewmodels.ProfileEditViewModel
import pe.edu.grupo3_asignacion1.ui.asignacion1.uis.PerfilScreen
import pe.edu.grupo3_asignacion1.ui.asignacion1.uis.viewmodels.PerfilViewModel

@Composable
fun AppNavigation(
    /*pokemonScreenModel: PokemonViewModel,
    pokemonDetailViewModel: PokemonDetailViewModel,
    seguidoresViewModel: SeguidorViewModel,
    seguidosViewModel: SeguidosViewModel,*/
    perfilViewModel: PerfilViewModel,
    profileEditViewModel: ProfileEditViewModel
){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    //val pokemonIdParam = navBackStackEntry?.arguments?.getInt("pokemon_id")
    //val userId = navBackStackEntry?.arguments?.getInt("user_id")
    val userId = 1
    NavHost(
        navController = navController,
        startDestination = "/profile/?user_id={user_id}"
    ){
        // profile
        composable(
            route = "/profile/?user_id={user_id}",
            arguments = listOf(
                navArgument("user_id"){
                    type = NavType.IntType
                    defaultValue = 2
                }
            )
        ){
            Log.d("APP_NAVIGATION", userId.toString())
            perfilViewModel.updateId(userId!!)
            PerfilScreen(
                viewModel = perfilViewModel,
                navController
            )
        }
        // seguidos
        composable(
            route = "/seguidos?user_id={user_id}",
            arguments = listOf(
                navArgument("user_id"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){
            /*seguidosViewModel.setUsuarios(userId!!)
            SeguidosScreen(
                viewModel = seguidosViewModel,
                navController
            )*/
        }
        // seguidores
        composable(
            route = "/seguidores?user_id={user_id}",
            arguments = listOf(
                navArgument("user_id"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){
            /*seguidoresViewModel.setUsuarios(userId!!)
            Log.d("XD", "+++++++++++++++++++++++++++++++++++++++")
            SeguidoresScreen(
                viewModel = seguidoresViewModel,
                navController,
            )*/
        }

        // editar perfil
        composable(
            route = "/profile/edit?user_id={user_id}",
            arguments = listOf(
                navArgument("user_id"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){
            profileEditViewModel.getUser(userId!!)
            ProfileEditScreen(viewModel = profileEditViewModel)
        }
    }
}