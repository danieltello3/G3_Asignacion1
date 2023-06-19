
package pe.edu.grupo3_asignacion1.ui.login.uis

import android.app.Activity
import android.os.Handler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pe.edu.grupo3_asignacion1.R
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.ResetPasswordViewModel
import pe.edu.grupo3_asignacion1.ui.theme.*

@Preview
@Composable
public fun ResetPaswordScreenPreview(){
    ResetPasswordScreen(
        ResetPasswordViewModel(),
        goToLoginScreen = {},
        goToCreateAccountScreen = {}
    )
}

@Composable
public fun ResetPasswordScreen(
    viewModel: ResetPasswordViewModel,
    goToLoginScreen: () -> Unit,
    goToCreateAccountScreen: () -> Unit
){

    val context = LocalContext.current as Activity
    // Variables para el viewmodel
    val correo : String by viewModel.correo.observeAsState(initial = "")
    val mensaje : String by viewModel.mensaje.observeAsState(initial = "")

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = {
                context.finish()
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
        ){
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Person Icon",
            )
        }
    }

    //Container
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
                painter = painterResource(id = R.drawable.ic_ulgram_launcher_foreground),
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
                fontSize = 20.sp
            )

            //Cambia color al mensaje
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
                    Text(text= "")
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
                    .padding(top = 15.dp
/*, start = 40.dp, end = 40.dp*/
), // start -> izquierda, end -> derecha
                onClick = {
                        viewModel.reset(context)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = OrangeUL)
            ) {
                Text("Recuperar".uppercase())
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                thickness = 2.dp,
            )

            //Ingresar al sistema
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp
/*, start = 40.dp, end = 40.dp*/
), // start -> izquierda, end -> derecha
                onClick = {
                    goToLoginScreen()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = GrayUL)
            ) {
                Text("Ingresar al sistema".uppercase())
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                onClick = {
                    goToCreateAccountScreen()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = GrayUL)
            ) {
                Text("Crear cuenta".uppercase())
            }
        }
    }
}
