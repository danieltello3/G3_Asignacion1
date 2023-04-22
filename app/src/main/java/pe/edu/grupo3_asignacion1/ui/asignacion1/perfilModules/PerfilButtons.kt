package pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.grupo3_asignacion1.R
import pe.edu.grupo3_asignacion1.ui.theme.*

@Composable
@Preview(showBackground = true)
fun PerfilButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(1.dp)
            //.background(Color.White)
    ) {
        Column(
            Modifier
                .weight(4f)
                .height(40.dp)
        ) {
            Button(
                onClick = { /* Acción al hacer click en el botón */ },
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
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
            }
        }
        Column(
            Modifier
                .weight(4f)
                .height(40.dp)
        ) {
            Button(
                onClick = { /* Acción al hacer click en el botón */ },
                modifier = Modifier
                    //.background(color = Red)
                    .height(40.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = OrangeUL
                )
            ) {
                Text(
                    "Compartir perfil",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black
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
                onClick = { /* Acción al hacer click en el botón */ },
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
