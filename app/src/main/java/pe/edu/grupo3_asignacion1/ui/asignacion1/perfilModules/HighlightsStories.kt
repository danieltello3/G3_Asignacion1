package pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.grupo3_asignacion1.R

@Preview
@Composable
fun HighlightsStoriesPreview(){
    HighlightsStories()
}

@Composable
fun HighlightsStories(){
    Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)){
        Column() {
            Text("Historias destacadas", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top= 10.dp), color = if(isSystemInDarkTheme()) Color.White else Color.Black)
            Text("Guarda tus historias favoritas en el perfil", modifier = Modifier.padding(top= 10.dp), color = if(isSystemInDarkTheme()) Color.White else Color.Black)
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_control_point_24),
                    modifier = Modifier
                        .size(100.dp)
                        .padding(top = 10.dp),
                    contentDescription = "Logo Ulima",
                    colorFilter = ColorFilter.tint (color = if(isSystemInDarkTheme()) Color.White else Color.Black),
                )
                Text("Nueva", color = if(isSystemInDarkTheme()) Color.White else Color.Black)
            } 
        }
    }
}