package pe.edu.grupo3_asignacion1.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import pe.edu.grupo3_asignacion1.navigations.AppNavigation
import pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.viewmodels.ProfileEditViewModel
import pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels.*
import pe.edu.grupo3_asignacion1.ui.theme.Grupo3_Asignacion1Theme

class AppActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var perfilViewModel = PerfilViewModel()
        val tabViewModel = TabViewModel()
        val followViewModel = FollowViewModel()
        val imageViewModel = ImagesViewModel()
        val profileEditViewModel = ProfileEditViewModel()
        setContent{
            Grupo3_Asignacion1Theme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation(
                        perfilViewModel = perfilViewModel,
                        followViewModel = followViewModel,
                        tabViewModel = tabViewModel,
                        imagesViewModel = imageViewModel,
                        profileEditViewModel = profileEditViewModel
                    )
                }
            }
        }
    }
}