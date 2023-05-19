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

@Composable
fun AppNavigation(
    /*pokemonScreenModel: PokemonViewModel,
    pokemonDetailViewModel: PokemonDetailViewModel,
    profileViewModel: ProfileViewModel,
    seguidoresViewModel: SeguidorViewModel,
    seguidosViewModel: SeguidosViewModel,*/
){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val pokemonIdParam = navBackStackEntry?.arguments?.getInt("pokemon_id")
    val userId = navBackStackEntry?.arguments?.getInt("user_id")

    NavHost(
        navController = navController,
        startDestination = "/pokemon"
    ){
        // profile
        composable(
            route = "/profile/?user_id={user_id}",
            arguments = listOf(
                navArgument("user_id"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){
            /*Log.d("APP_NAVIGATION", pokemonIdParam.toString())
            profileViewModel.setUsuario(userId!!)
            ProfileScreen(
                viewModel = profileViewModel
            )*/
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
    }
}