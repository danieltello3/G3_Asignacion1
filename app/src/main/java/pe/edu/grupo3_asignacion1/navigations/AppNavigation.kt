package pe.edu.grupo3_asignacion1.navigations

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
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
import pe.edu.grupo3_asignacion1.ui.asignacion1.uis.*
import pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels.*

@Composable
fun AppNavigation(
    /*pokemonScreenModel: PokemonViewModel,
    pokemonDetailViewModel: PokemonDetailViewModel,
    seguidoresViewModel: SeguidorViewModel,
    seguidosViewModel: SeguidosViewModel,*/
    perfilViewModel: PerfilViewModel,
    profileEditViewModel: ProfileEditViewModel,
    followViewModel: FollowViewModel,
    tabViewModel: TabViewModel
){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val indexId = navBackStackEntry?.arguments?.getInt("index_id")
    val userId = navBackStackEntry?.arguments?.getInt("user_id")

    NavHost(
        navController = navController,
        startDestination = "/profile/"
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
            //perfilViewModel.updateId(userId!!)
            PerfilScreen(
                viewModel = perfilViewModel,
                navController,
                userId!!
            )
        }
        //
        composable(
            route = "/profile/",
        ){
            //perfilViewModel.updateId(userId!!)
            val context = LocalContext.current
            val activity = context as Activity
            val intent = activity.intent
            val userId = intent.getIntExtra("user_id",0)
            PerfilScreen(
                viewModel = perfilViewModel,
                navController,
                userId
            )
        }

        // vista follows
        composable(
            route = "/profile/follows/{user_id}/{index_id}",
            arguments = listOf(
                navArgument("user_id") {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument("index_id") {
                    type = NavType.IntType
                    defaultValue = 0
                },
            )
        ){
            followViewModel.setFollowers(userId!!)
            followViewModel.setFollowings(userId)
            tabViewModel.updateIndex(indexId!!)
            FollowScreen(
                followViewModel,
                tabViewModel,
                navController
            )
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