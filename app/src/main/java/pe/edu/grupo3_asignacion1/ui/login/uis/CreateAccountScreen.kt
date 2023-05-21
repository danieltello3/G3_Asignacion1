package pe.edu.grupo3_asignacion1.ui.login.uis

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.grupo3_asignacion1.R
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.CreateAccountViewModel
import pe.edu.grupo3_asignacion1.ui.theme.GrayUL
import pe.edu.grupo3_asignacion1.ui.theme.OrangeUL

@Preview
@Composable
fun CreateAccountPreview(){
    CreateAccountScreen(
        CreateAccountViewModel(),
        goToResetPasswordScreen = {},
        goToHomeScreen = {}
    )
}

@Composable
fun CreateAccountScreen(
    viewModel: CreateAccountViewModel,
    goToResetPasswordScreen: () -> Unit,
    goToHomeScreen: () -> Unit
){
    val context = LocalContext.current as Activity
    // viewmodel
    val correo : String by viewModel.correo.observeAsState(initial = "")
    val mensaje : String by viewModel.mensaje.observeAsState(initial = "")
    // close
    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = {
                Log.d("LOGIN_SCREEN", "XDDDDDDDDDDDDDDDDDDD")
                context.finish()
            },
            modifier = Modifier.align(Alignment.TopEnd).padding(10.dp)
        ){
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Person Icon",
            )
        }
    }
    // container
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterStart,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_ulima),
                contentDescription = "Logo Ulima",
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 10.dp),
                colorFilter = ColorFilter.tint(
                    color = OrangeUL
                )
            )
            Text(
                text = "Restablecer Contraseña",
                textAlign = TextAlign.Center,
            )
            if (mensaje.contains("Error")) {
                Text(
                    text = mensaje.split(":")[1],
                    textAlign = TextAlign.Center,
                    color = Color.Red
                )
            } else {
                Text(
                    text = mensaje,
                    textAlign = TextAlign.Center,
                    color = Color.Green
                )
            }
            // txtCorreo
            TextField(
                value = correo,
                onValueChange = {
                    viewModel.updateCorreo(it)
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Correo")
                },
                placeholder = {
                    Text(text = "")
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )
            // boton reset
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp/*, start = 40.dp, end = 40.dp*/), // start -> izquierda, end -> derecha
                onClick = {

                }
            ) {
                Text("Enviar Correo")
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                thickness = 2.dp,
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp/*, start = 40.dp, end = 40.dp*/), // start -> izquierda, end -> derecha
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(backgroundColor = GrayUL)
            ) {
                Text("Ir a Ingresar".uppercase())
            }
        }
    }


}