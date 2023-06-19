package pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels.PerfilViewModel

@Composable
fun PerfilNombre(
    userId: Int,
    viewModel: PerfilViewModel
){

    Row(){
        Text(
            modifier = Modifier.padding(bottom = 15.dp,start = 20.dp),
            text = viewModel.nombre.value!!,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            overflow = TextOverflow.Ellipsis,
            //style= TextStyle(letterSpacing = 1.sp)
        )
    }

}