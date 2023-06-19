package pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels.FollowViewModel

@Preview
@Composable
fun FollowerScreenPreview(){
    FollowerScreen(
        FollowViewModel(),
        rememberNavController()
    )
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun FollowerScreen(
    viewModel: FollowViewModel,
    navController: NavController
){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(1),
        content = {
            items(viewModel.followers!!.size) { i ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("/profile/?user_id=${viewModel.followers!![i].usuarioId}")
                    }) {
                    Image(
                        painter = rememberImagePainter(data = viewModel.followers!![i].imageUrl),
                        contentDescription = "XD",
                        modifier = Modifier
                            .size(80.dp)
                            .padding(10.dp)
                            .clip(
                                RoundedCornerShape(50.dp)
                            )
                            .border(
                                3.dp,
                                if (isSystemInDarkTheme()) Color.White else Color.Black,
                                CircleShape
                            )
                    )
                    Column(modifier = Modifier.align(Alignment.CenterVertically)){
                        Text(
                            viewModel.followers!![i].user,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            viewModel.followers!![i].name,
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