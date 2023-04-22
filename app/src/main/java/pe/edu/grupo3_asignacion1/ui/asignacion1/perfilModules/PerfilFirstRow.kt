package pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun PerfilFirstRow() {
    Column(){
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 9.dp, vertical = 10.dp)
        ) {
            Column(
                Modifier.weight(1.5f).align(Alignment.CenterVertically)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foto_perfil),
                    contentDescription = "foto de perfil",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(6.dp)
                        .align(Alignment.CenterHorizontally)
                        .clip(
                            RoundedCornerShape(50.dp)
                        )

                )



            }
            Column(modifier = Modifier.align(Alignment.CenterVertically).weight(1f)) {
                Text(
                    text = "100", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Publicaciones",
                    maxLines = 1,
                    fontSize = 12.sp,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis,

                    )
            }
            Column(modifier = Modifier.weight(1f).align(Alignment.CenterVertically)) {
                Text(
                    text = "536", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Seguidores", fontSize = 12.sp,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(modifier = Modifier.weight(1f).align(Alignment.CenterVertically)) {
                Text(
                    text = "536", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Seguidos", fontSize = 12.sp,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        Text(
            modifier = Modifier.padding(horizontal=9.dp),
            text = "Armando Mendoza",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            overflow = TextOverflow.Ellipsis
        )



    }

}
