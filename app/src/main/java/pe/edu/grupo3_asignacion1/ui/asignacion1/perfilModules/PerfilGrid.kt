package pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import pe.edu.grupo3_asignacion1.models.Photo
import pe.edu.grupo3_asignacion1.models.User
import pe.edu.grupo3_asignacion1.models.demo.PhotoList
import pe.edu.grupo3_asignacion1.services.ImageService
import pe.edu.grupo3_asignacion1.services.UserService
import pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels.ImagesViewModel

@Preview
@Composable
fun PerfilGridPreview(){
    PerfilGrid(
        1,
        ImagesViewModel()
    )
}

@Composable
fun PerfilGrid(
    userId: Int,
    viewModel: ImagesViewModel
){

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        content = {
        items(viewModel.images!!){item ->
            Box(modifier = Modifier.size(100.dp,140.dp)){
                Image(painter = rememberImagePainter(data=item.url),
                    contentDescription = item.id.toString(),
                    contentScale = ContentScale.FillWidth)
            }
        }
    })

}