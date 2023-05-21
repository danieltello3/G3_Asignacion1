package pe.edu.grupo3_asignacion1.ui.asignacion1.uis

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import pe.edu.grupo3_asignacion1.R
import pe.edu.grupo3_asignacion1.models.Photo
import pe.edu.grupo3_asignacion1.services.ImageService
import pe.edu.grupo3_asignacion1.ui.theme.OrangeUL


@Preview
@Composable
public fun HomePreview(){
    HomeScreen()
}
//@Preview(showBackground = true)
@Composable
public fun HomeScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White))
    {
        PerfilFirstRow()
        PerfilNombre()
        PerfilButtons()
        HighlightsStories()
        PerfilGrid()
    }

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
                onClick = { /* Acción al hacer click en el botón */ },
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

@Composable
fun PerfilFirstRow() {
    Column() {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 9.dp, vertical = 10.dp)
        ) {
            Column(
                Modifier
                    .weight(1.5f)
                    .align(Alignment.CenterVertically)
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
            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f)) {
                Text(
                    text = "100", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Publicaciones",
                    maxLines = 1,
                    fontSize = 17.sp,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis,

                    )
            }
            Column(modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)) {
                Text(
                    text = "536", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Seguidores", fontSize = 17.sp,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)) {
                Text(
                    text = "536", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Seguidos", fontSize = 17.sp,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun PerfilGrid(){
    var tmpList: List<Photo> = ImageService.fetchAll()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        content = {
            items(tmpList){item ->
                Box(modifier = Modifier.size(100.dp,140.dp)){
                    Image(painter = rememberImagePainter(data=item.url),
                        contentDescription = item.id.toString(),
                        contentScale = ContentScale.FillWidth)
                }
            }
        })

}

@Composable
fun PerfilNombre(){

    Row(){
        Text(
            modifier = Modifier.padding(bottom = 15.dp,start = 20.dp),
            text = "Armando Mendoza",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            overflow = TextOverflow.Ellipsis,
            //style= TextStyle(letterSpacing = 1.sp)
        )
    }

}