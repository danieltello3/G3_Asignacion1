package pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.grupo3_asignacion1.R
import pe.edu.grupo3_asignacion1.ui.theme.OrangeUL

@Composable
fun PerfilButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(1.dp)
            .padding(horizontal = 10.dp, vertical = 1.dp)
    ) {
        Column(
            Modifier
                .weight(4f)
                .height(40.dp)
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = OrangeUL
                )
            ) {
                Text(
                    "Editar perfil",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    style= TextStyle(letterSpacing = -0.5.sp)
                )
            }
        }
        Column(
            Modifier
                .weight(4f)
                .height(40.dp)
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = OrangeUL
                )
            ) {
                Text(
                    "Compartir perfil",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    style= TextStyle(letterSpacing = -0.5.sp)
                )
            }

        }
        Column(
            Modifier
                .weight(2f)
                //.background(Gray)
                .height(40.dp)
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    //.background(color = Red)
                    .height(40.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = OrangeUL
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_usuario),
                    contentDescription = "icono",
                    colorFilter = ColorFilter.tint(
                        color = if (isSystemInDarkTheme()) Color.White else Color.Black
                    )
                )
            }
        }
    }
}