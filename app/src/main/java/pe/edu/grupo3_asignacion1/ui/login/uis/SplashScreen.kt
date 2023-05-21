package pe.edu.grupo3_asignacion1.ui.login.uis

import android.content.Intent
import android.os.Handler
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pe.edu.grupo3_asignacion1.R
import pe.edu.grupo3_asignacion1.ui.theme.*
import pe.edu.grupo3_asignacion1.activities.AppActivity

@Preview
@Composable
public fun SplashScreenPreview(){
    SplashScreen(
        rememberNavController()
    )
}

@Composable
public fun SplashScreen(navController: NavHostController){
    //val caslonFont = FontFamily(Font(R.font.caslon_classico_sc_regular))

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_ulgram_launcher_foreground),
                contentDescription = "Logo Ulima",
                modifier = Modifier.size(120.dp).padding(bottom = 10.dp),
                colorFilter = ColorFilter.tint(
                    color = OrangeUL
                )
            )
            Text(
                text = "ULGRAM",
                textAlign = TextAlign.Center//, fontFamily = caslonFont
            )
        }
    }

    Handler().postDelayed({
        navController.navigate("/login/")
    }, 1500)
}