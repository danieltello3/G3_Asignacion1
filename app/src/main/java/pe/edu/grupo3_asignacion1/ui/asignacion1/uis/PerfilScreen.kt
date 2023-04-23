package pe.edu.grupo3_asignacion1.ui.asignacion1.uis

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.*


@Preview
@Composable
public fun PerfilScreenPreview(){
    PerfilScreen()
}
//@Preview(showBackground = true)
@Composable
public fun PerfilScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White))
    {
        //Archivo Brillitt
        PerfilFirstRow()
        PerfilNombre()
        PerfilButtons()
        //Archivo Gonzalo
        HighlightsStories()
        //Archivo Daniel
        PerfilGrid()
    }


}
