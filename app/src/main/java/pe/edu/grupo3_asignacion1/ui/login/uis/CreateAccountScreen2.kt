package pe.edu.grupo3_asignacion1.ui.login.uis

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.grupo3_asignacion1.R
import pe.edu.grupo3_asignacion1.ui.theme.GrayUL
import pe.edu.grupo3_asignacion1.ui.theme.OrangeUL


@Preview
@Composable
public fun CreateAccountScreen2Preview(){
    CreateAccountScreen2()
}

@Composable
public fun CreateAccountScreen2(/*viewModel: CreateAccountViewModel,
                   goToResetPasswordScreen: () -> Unit)*/
){
    /*
    val context = LocalContext.current as Activity
    // viewmodel
    val correo : String by viewModel.correo.observeAsState(initial = "")
    val mensaje : String by viewModel.mensaje.observeAsState(initial = "")
    */
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
                    .size(150.dp),
                    /*.padding(bottom = 5.dp),*/
                colorFilter = ColorFilter.tint(
                    color = OrangeUL
                )
            )
            Text(
                text = "Crear Cuenta",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )

            // txtCorreo

            TextField(
                value = "",
                onValueChange = {  },
                Modifier
                    .fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                ),
                //enabled = true,
                //readOnly = false,
                //textStyle = LocalTextStyle.current,
                label = { Text("Usuario") },
                placeholder = { Text(text = "") }
            )

            TextField(
                value = "",
                onValueChange = {  },
                Modifier
                    .fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                ),
                //enabled = true,
                //readOnly = false,
                //textStyle = LocalTextStyle.current,
                label = { Text("Correo") },
                placeholder = { Text(text = "") }
            )

            TextField(
                value = "",
                onValueChange = {  },
                Modifier
                    .fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                ),
                //enabled = true,
                //readOnly = false,
                //textStyle = LocalTextStyle.current,
                label = { Text("Contraseña") },
                placeholder = { Text(text = "") }
            )

            TextField(
                value = "",
                onValueChange = {  },
                Modifier
                    .fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                ),
                //enabled = true,
                //readOnly = false,
                //textStyle = LocalTextStyle.current,
                label = { Text("Repetir contraseña") },
                placeholder = { Text(text = "") }
            )

            // boton reset
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp/*, start = 40.dp, end = 40.dp*/), // start -> izquierda, end -> derecha
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(backgroundColor = OrangeUL)
            ) {
                Text("CREAR")
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 5.dp),
                thickness = 2.dp,
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp/*, start = 40.dp, end = 40.dp*/), // start -> izquierda, end -> derecha
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(backgroundColor = GrayUL)
            ) {
                Text("Ingresar al sistema".uppercase())
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp/*, start = 40.dp, end = 40.dp*/), // start -> izquierda, end -> derecha
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(backgroundColor = GrayUL)
            ) {
                Text("Recuperar contraseña".uppercase())
            }
        }
    }


}