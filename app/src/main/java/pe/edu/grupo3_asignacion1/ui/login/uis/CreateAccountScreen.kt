package pe.edu.grupo3_asignacion1.ui.login.uis

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.grupo3_asignacion1.R
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.CreateAccountViewModel
import pe.edu.grupo3_asignacion1.ui.theme.GrayUL
import pe.edu.grupo3_asignacion1.ui.theme.OrangeUL


@Preview
@Composable
public fun CreateAccountScreenPreview(){
    CreateAccountScreen(
        CreateAccountViewModel(),
        goToResetPasswordScreen = {},
        goToLoginScreen = {})
}

@Composable
public fun CreateAccountScreen(viewModel: CreateAccountViewModel,
                               goToResetPasswordScreen: () -> Unit,
                               goToLoginScreen: () -> Unit
){
    val context = LocalContext.current as Activity

    // variables para el viewmodel
    val usuario : String by viewModel.usuario.observeAsState(initial = "")
    val correo: String by viewModel.correo.observeAsState(initial = "")
    val contrasenia : String by viewModel.contrasenia.observeAsState(initial = "")
    val repeatcontrasenia: String by viewModel.repeatcontrasenia.observeAsState(initial = "")
    val mensaje : String by viewModel.mensaje.observeAsState(initial = "")

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

            //Cambiar de color del mensaje
            if(mensaje.contains("Error")){
                Text(
                    text = mensaje.split(":")[1],
                    textAlign = TextAlign.Center,
                    color = Color.Red
                )
            }else{
                Text(
                    text = mensaje,
                    textAlign = TextAlign.Center,
                    color = Color.Green
                )
            }

            //TextField de Usuario
            TextField(
                value = usuario,
                onValueChange = {
                    viewModel.updateUsuario(it)
                },
                Modifier
                    .fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                ),
                label = { Text("Usuario") },
                placeholder = { Text(text = "") }
            )

            //TextField del Correo
            TextField(
                value = correo,
                onValueChange = {
                    viewModel.updateCorreo(it)
                },
                Modifier
                    .fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                ),
                label = { Text("Correo") },
                placeholder = { Text(text = "") }
            )

            //TextField de Contraseña
            TextField(
                value = contrasenia,
                onValueChange = {
                     viewModel.updateContrasenia(it)
                },
                Modifier
                    .fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = { Text("Contraseña") },
                placeholder = { Text(text = "") }
            )

            //TextField de Repetir Contraseña
            TextField(
                value = repeatcontrasenia,
                onValueChange = {
                     viewModel.updateRepeatContrasenia(it)
                },
                Modifier
                    .fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = { Text("Repetir contraseña") },
                placeholder = { Text(text = "") }
            )

            // Botón CREAR CUENTA
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                onClick = {
                    //Lógica para crear nueva cuenta
                    viewModel.createNewAccount(context)
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
                    .padding(top = 5.dp),
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
                    goToResetPasswordScreen()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = GrayUL)
            ) {
                Text("Recuperar contraseña".uppercase())
            }
        }
    }


}