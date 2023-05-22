package pe.edu.grupo3_asignacion1.ui.asignacion1.uis

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.*
import pe.edu.grupo3_asignacion1.ui.asignacion1.uis.viewmodels.PerfilViewModel


@Preview
@Composable
public fun PerfilScreenPreview(){
    PerfilScreen(
        PerfilViewModel(),
        rememberNavController()
    )
}
//@Preview(showBackground = true)
@Composable
public fun PerfilScreen(
    viewModel: PerfilViewModel,
    navController: NavHostController
){
    val context = LocalContext.current
    val activity = context as Activity
    val intent = activity.intent
    //val userId = intent.getIntExtra("user_id",0)
    val userId = 2 //comentar luego
    viewModel.setPhotos(userId)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White))
    {
        //Archivo Brillitt
        PerfilFirstRow()
        PerfilNombre()
        PerfilButtons(navController,userId)
        //Archivo Gonzalo
        HighlightsStories()
        //Archivo Daniel
        viewModel.photos?.let { PerfilGrid(it) }
    }


}
