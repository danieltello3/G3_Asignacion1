package pe.edu.grupo3_asignacion1.activities

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pe.edu.grupo3_asignacion1.navigations.LoginNavigation
import pe.edu.grupo3_asignacion1.ui.login.uis.SplashScreen
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.LoginViewModel
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.*

class MainActivity: ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // login navigation
        val loginViewModel = LoginViewModel()
        val resetPasswordViewModel = ResetPasswordViewModel()
        val createAccountViewModel = CreateAccountViewModel()

        // screen navigation
        setContent {
            val navController = rememberNavController()
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                //color = MaterialTheme.colors.background
            ) {
                SplashScreen(navController)
                LoginNavigation(
                    loginScreenViewModel = loginViewModel,
                    resetPasswordScreenViewModel = resetPasswordViewModel,
                    createAccountScreenViewModel = createAccountViewModel
                )
                //PokemonDetailScreen(viewModel = PokemonDetailViewModel())
                //TouchScreen()
            }

        }
    }

}