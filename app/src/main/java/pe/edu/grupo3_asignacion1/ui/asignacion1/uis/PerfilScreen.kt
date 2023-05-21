package pe.edu.grupo3_asignacion1.ui.asignacion1.uis

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.*


@Preview
@Composable
fun PerfilScreenPreview(){
    PerfilScreen(
        rememberNavController(),
    1
    )
}
//@Preview(showBackground = true)
@Composable
fun PerfilScreen(
    navController: NavController,
    userId: Int
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White))
    {
        //Archivo Brillitt
        PerfilFirstRow(navController = navController, userId = userId)
        PerfilNombre(userId)
        PerfilButtons()
        //Archivo Gonzalo
        HighlightsStories()
        //Archivo Daniel
        PerfilGrid(
            userId
        )
    }


}
