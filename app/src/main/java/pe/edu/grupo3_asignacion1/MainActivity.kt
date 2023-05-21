package pe.edu.grupo3_asignacion1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.grupo3_asignacion1.ui.asignacion1.uis.HomeScreen
import pe.edu.grupo3_asignacion1.ui.theme.Grupo3_Asignacion1Theme
import pe.edu.grupo3_asignacion1.ui.login.uis.LoginScreen
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Grupo3_Asignacion1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    LoginScreen(
                        LoginViewModel(),
                        goToResetPasswordScreen = {},
                        goToHomeScreen = {},
                        goToCreateAccountScreen = {}
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Grupo3_Asignacion1Theme {
        Greeting("Android")
    }
}