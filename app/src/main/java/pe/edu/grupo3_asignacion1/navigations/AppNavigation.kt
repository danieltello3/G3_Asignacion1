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
import pe.edu.grupo3_asignacion1.ui.asignacion1.uis.*
import pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels.*
import pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.uis.ProfileEditScreen
import pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.viewmodels.ProfileEditViewModel
import pe.edu.grupo3_asignacion1.ui.asignacion1.uis.viewmodels.PerfilViewModel

@Composable
fun AppNavigation(
    followViewModel: FollowViewModel,
    tabViewModel: TabViewModel,
    perfilViewModel: PerfilViewModel,
    imagesViewModel: ImagesViewModel,
    profileEditViewModel: ProfileEditViewModel,
){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val indexId = navBackStackEntry?.arguments?.getInt("index_id")
    val userId = navBackStackEntry?.arguments?.getInt("user_id")
    val context = LocalContext.current
    val activity = context as Activity

    NavHost(
        navController = navController,
        startDestination = "/profile/"
    ){
        // profile
        composable(
            route = "/profile/?user_id={user_id}",
            arguments = listOf(
                navArgument("user_id") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){
            var id = userId
            perfilViewModel.setUsuario(id!!)
            followViewModel.setFollowings(id!!)
            followViewModel.setFollowers(id!!)
            imagesViewModel.setImages(id!!)
            println(id!!.toString())

            PerfilScreen(
                navController,
                id,
                perfilViewModel,
                followViewModel,
                imagesViewModel,
            )
        }

        composable(
            route = "/profile/",
        ){
            perfilViewModel.setUsuarioLocal(context)
            followViewModel.setFollowings(perfilViewModel.id.value!!)
            followViewModel.setFollowers(perfilViewModel.id.value!!)
            imagesViewModel.uploadImages(activity)
            PerfilScreen(
                navController,
                perfilViewModel.id.value!!,
                perfilViewModel,
                followViewModel,
                imagesViewModel,
            )
        }

        // vista follows
        composable(
            route = "/profile/follows/user_id={user_id}/index_id={index_id}",
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
            tabViewModel.updateIndex(indexId!!)
            FollowScreen(
                followViewModel,
                tabViewModel,
                perfilViewModel,
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