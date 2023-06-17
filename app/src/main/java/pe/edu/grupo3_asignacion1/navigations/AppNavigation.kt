package pe.edu.grupo3_asignacion1.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.grupo3_asignacion1.ui.asignacion1.uis.*
import pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels.*

@Composable
fun AppNavigation(
    followViewModel: FollowViewModel,
    tabViewModel: TabViewModel,
    perfilViewModel: PerfilViewModel,
    imagesViewModel: ImagesViewModel,
){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val indexId = navBackStackEntry?.arguments?.getInt("index_id")
    val userId = navBackStackEntry?.arguments?.getInt("user_id")

    NavHost(
        navController = navController,
        startDestination = "/profile/"
    ){
        // vista para mostrar el listado de pokemones
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
            perfilViewModel.setUsuario(1)
            followViewModel.setFollowings(1)
            followViewModel.setFollowers(1)
            imagesViewModel.setImages(1)
            PerfilScreen(
                navController,
                1,
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
    }
}