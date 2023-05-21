package pe.edu.grupo3_asignacion1.ui.asignacion1.uis

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.FollowerScreen
import pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.FollowingScreen
import pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels.FollowViewModel
import pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels.TabViewModel

@Preview
@Composable
fun FollowScreenPreview(){
    FollowScreen(
        FollowViewModel(),
        TabViewModel(),
        rememberNavController()
    )
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FollowScreen(
    viewModel: FollowViewModel,
    tabViewModel: TabViewModel,
    navController: NavController
){
    Scaffold (topBar = {
        TopAppBar(
        navigationIcon = {
            IconButton(onClick = {navController.navigate("/profile/")}){
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        title = { Text(text = viewModel.user.value.toString(), modifier = Modifier.padding(end = 5.dp)) },
    )
    }) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(if (isSystemInDarkTheme()) Color.Black else Color.White))
        {
            var tabIndex by remember(tabViewModel.index!!) { mutableStateOf(tabViewModel.index!!)}
            val tabs = listOf("seguidores", "seguidos")

            Column(modifier = Modifier.fillMaxWidth()) {
                TabRow(selectedTabIndex = tabIndex) {
                    tabs.forEachIndexed { index, title ->
                        Tab(text = { Text(title) },
                            selected = tabIndex == index,
                            onClick = {
                                tabIndex = index
                            }
                        )
                    }
                }
                when (tabIndex) {
                    0 -> FollowerScreen(viewModel = viewModel)
                    1 -> FollowingScreen(viewModel = viewModel)
                }
            }
        }
    }
}