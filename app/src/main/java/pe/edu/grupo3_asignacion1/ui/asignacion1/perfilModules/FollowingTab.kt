package pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import pe.edu.grupo3_asignacion1.models.User
import pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels.FollowViewModel

@Preview
@Composable
fun FollowingScreenPreview(){
    FollowingScreen(
        FollowViewModel(),
    )
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun FollowingScreen(
    viewModel: FollowViewModel
){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(1),
        content = {
            items(viewModel.followings!!.size) { i ->
                val user: User = viewModel.followings!![i]
                Row {
                    Image(
                        painter = rememberImagePainter(data = user.imagen),
                        contentDescription = "XD",
                        modifier = Modifier
                            .size(80.dp)
                            .padding(10.dp)
                            .clip(
                                RoundedCornerShape(50.dp)
                            )
                            .border(3.dp, if (isSystemInDarkTheme()) Color.White else Color.Black, CircleShape)
                    )
                    Column(modifier = Modifier.align(Alignment.CenterVertically)){
                        Text(
                            user.usuario,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            user.nombre,
                            style = TextStyle(
                                    fontSize = 15.sp,
                            fontWeight = FontWeight.Light
                            )
                        )
                    }
                }
                Divider()
            }
        }
    )
}