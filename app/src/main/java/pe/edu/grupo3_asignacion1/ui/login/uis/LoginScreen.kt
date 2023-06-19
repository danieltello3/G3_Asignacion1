/*
package pe.edu.grupo3_asignacion1.ui.login.uis

import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pe.edu.grupo3_asignacion1.R
import pe.edu.grupo3_asignacion1.ui.login.viewmodels.LoginViewModel
import pe.edu.grupo3_asignacion1.ui.theme.*

@Preview
@Composable
public fun LoginScreenPreview(){
    LoginScreen(
        LoginViewModel(),
        goToResetPasswordScreen = {},
        goToCreateAccountScreen = {},
        rememberNavController()
    )
}

@Composable
public fun LoginScreen(
    viewModel: LoginViewModel,
    goToResetPasswordScreen: () -> Unit,
    goToCreateAccountScreen: () -> Unit,
    navController: NavHostController

){
    val context = LocalContext.current
    // viewmodel
    val usuario : String by viewModel.usuario.observeAsState(initial = "")
    val contrasenia : String by viewModel.contrasenia.observeAsState(initial = "")
    val mensaje : String by viewModel.mensaje.observeAsState(initial = "")
    val passwordVisible = remember { mutableStateOf(false) }

    // close
    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = {
                Log.d("LOGIN_SCREEN", "XDDDDDDDDDDDDDDDDDDD")
                val activity = context as Activity
                activity.finish()
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
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_ulgram_launcher_foreground),
                contentDescription = "Logo Ulima",
                modifier = Modifier
                    .size(250.dp),
                    //.padding(bottom = 5.dp),
                colorFilter = ColorFilter.tint(
                    color = OrangeUL
                )
            )
            Text(
                text = "Acceder al sistema",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                style = MaterialTheme.typography.h4
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
            // TextField de Usuario
            TextField(
                value = usuario,
                onValueChange = {
                    viewModel.updateUsuario(it)
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Usuario")
                },
                placeholder = {
                    Text(text= "")
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )
            // txtPassword
            TextField(
                value = contrasenia,
                onValueChange = {
                    viewModel.updateContrasenia(it)
                },
                label = {
                    Text(text = "Contraseña")
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text= "")
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                ),
                trailingIcon = {
                    if(passwordVisible.value){
                        IconButton(onClick = {passwordVisible.value = false}){
                            Icon(
                                imageVector = Icons.Filled.Visibility,
                                contentDescription = null
                            )
                        }
                    }
                    else {
                        IconButton(onClick = {passwordVisible.value = true}){
                            Icon(
                                imageVector = Icons.Filled.VisibilityOff,
                                contentDescription = null
                            )
                        }
                    }
                },
                visualTransformation = if(passwordVisible.value){
                    VisualTransformation.None
                }else{
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            // boton Ingresar
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp*/
/*, start = 40.dp, end = 40.dp*//*
), // start -> izquierda, end -> derecha
                onClick = {
                    viewModel.validar(context,navController)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = OrangeUL)
            ){
                Text("INGRESAR")
            }

            // boton Ingresar con Google
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 1.dp, */
/*start = 40.dp, end = 40.dp*//*
),
                onClick = {

                },
                //colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4CAF50)) ,
                colors = ButtonDefaults.buttonColors(backgroundColor = GreenUL)
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Logo Google",
                    modifier = Modifier
                        .size(22.dp)
                        .padding(end = 10.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Text(
                    "INGRESAR CON GOOGLE",
                    color = Color.White
                )
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
                    .padding(top = 10.dp),
                onClick = {
                    goToCreateAccountScreen()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = GrayUL)
            ){
                Text("CREAR CUENTA")
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 1.dp),
                onClick = {
                    goToResetPasswordScreen()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = GrayUL)
            ){
                Text("RECUPERAR CONTRASEÑA")
            }

            BackHandler {
                Log.d("LoginScreen", "XD")
                val activity = context as Activity
                activity.finish()
            }
        }
    }
}*/
