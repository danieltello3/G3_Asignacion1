package pe.edu.grupo3_asignacion1.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.*
import pe.edu.grupo3_asignacion1.navigations.AppNavigation
import pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels.*
import pe.edu.grupo3_asignacion1.ui.theme.*

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tabViewModel = TabViewModel()
        val followViewModel = FollowViewModel()

        setContent {
            Grupo3Asignacion1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation(
                        followViewModel,
                        tabViewModel
                    )
                }
            }
        }
    }
}