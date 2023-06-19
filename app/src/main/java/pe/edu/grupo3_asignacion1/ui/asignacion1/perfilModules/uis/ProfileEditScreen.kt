package pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.uis

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch
import pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.viewmodels.ProfileEditViewModel
import pe.edu.grupo3_asignacion1.ui.theme.OrangeUL

@Preview
@Composable
public fun ProfileEditScreenPreview(){
    ProfileEditScreen(
        ProfileEditViewModel()
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
public fun ProfileEditScreen(
    viewModel: ProfileEditViewModel
){
    //viewmodel
    val nombre: String by viewModel.name.observeAsState("")
    val url: String by viewModel.url.observeAsState("")
    val usuario: String by viewModel.user.observeAsState("")
    val correo: String by viewModel.mail.observeAsState("")
    val mensaje : String by viewModel.mensaje.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState("")
    val newPassword: String by viewModel.newPassword.observeAsState("")
    val newPasswordConfirm: String by viewModel.newPasswordConfirm.observeAsState("")
    val mensajePassword: String by viewModel.mensajePassword.observeAsState("")

    val passwordVisible = remember {mutableStateOf(false)}
    val newPasswordVisible = remember {mutableStateOf(false)}
    val newPasswordConfirmVisible = remember{ mutableStateOf(false)}

    val context = LocalContext.current
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topEnd = 25.dp, topStart = 25.dp),
        sheetBackgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(horizontal = 35.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 30.dp),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "Cambiar Contraseña",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight(600)
                    )
                }
                TextField(
                    value = password,
                    onValueChange = {
                        viewModel.updatePassword(it)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Contraseña Antigua")
                    },
                    placeholder = {
                        Text(text = "")
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
                    }
                )
                TextField(
                    value = newPassword,
                    onValueChange = {
                        viewModel.updateNewPassword(it)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Contraseña Nueva")
                    },
                    placeholder = {
                        Text(text = "")
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent
                    ),
                    trailingIcon = {
                        if(newPasswordVisible.value){
                            IconButton(onClick = {newPasswordVisible.value = false}){
                                Icon(
                                    imageVector = Icons.Filled.Visibility,
                                    contentDescription = null
                                )
                            }
                        }
                        else {
                            IconButton(onClick = {newPasswordVisible.value = true}){
                                Icon(
                                    imageVector = Icons.Filled.VisibilityOff,
                                    contentDescription = null
                                )
                            }
                        }
                    },
                    visualTransformation = if(newPasswordVisible.value){
                        VisualTransformation.None
                    }else{
                        PasswordVisualTransformation()
                    }
                )
                TextField(
                    value = newPasswordConfirm,
                    onValueChange = {
                        viewModel.updateNewPasswordConfirm(it)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Repetir Contraseña Nueva")
                    },
                    placeholder = {
                        Text(text = "")
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent
                    ),
                    trailingIcon = {
                        if(newPasswordConfirmVisible.value){
                            IconButton(onClick = {newPasswordConfirmVisible.value = false}){
                                Icon(
                                    imageVector = Icons.Filled.Visibility,
                                    contentDescription = null
                                )
                            }
                        }
                        else {
                            IconButton(onClick = {newPasswordConfirmVisible.value = true}){
                                Icon(
                                    imageVector = Icons.Filled.VisibilityOff,
                                    contentDescription = null
                                )
                            }
                        }
                    },
                    visualTransformation = if(newPasswordConfirmVisible.value){
                        VisualTransformation.None
                    }else{
                        PasswordVisualTransformation()
                    },
                )
                if(mensajePassword.contains("Error")){
                    Text(
                        text = mensajePassword.split(":")[1],
                        textAlign = TextAlign.Center,
                        color = Color.Red,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                    )
                }else{
                    Text(
                        text = mensajePassword,
                        textAlign = TextAlign.Center,
                        color = Color.Green,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                    )
                }
                Button(
                    onClick = { viewModel.validarChangePassword(context) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = OrangeUL
                    )
                ) {
                    Text(
                        text = "CAMBIAR CONTRASEÑA"
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 35.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Editar Perfil",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(600)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 30.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Box(){
                    Image(
                        painter = rememberImagePainter(data= url),
                        contentDescription = nombre,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .size(160.dp)
                            .clip(
                                CircleShape
                            )
                    )
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        content = {
                            Icon(
                                Icons.Default.Edit,
                                contentDescription = null
                            ) },
                        backgroundColor = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                            .align(alignment = Alignment.BottomEnd)
                    )
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Column(
                    modifier = Modifier.fillMaxWidth()
                ){
                    TextField(
                        value = nombre,
                        onValueChange = {
                            viewModel.updateName(it)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Nombre")
                        },
                        placeholder = {
                            Text(text = "")
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent
                        )
                    )
                    TextField(
                        value = usuario,
                        onValueChange = {
                            viewModel.updateUser(it)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Usuario")
                        },
                        placeholder = {
                            Text(text = "")
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent
                        )
                    )
                    TextField(
                        value = correo,
                        onValueChange = {
                            viewModel.updateMail(it)
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
                    if(mensaje.contains("Error")){
                        Text(
                            text = mensaje.split(":")[1],
                            textAlign = TextAlign.Center,
                            color = Color.Red,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp)
                        )
                    }else{
                        Text(
                            text = mensaje,
                            textAlign = TextAlign.Center,
                            color = Color.Green,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp)
                        )
                    }

                    Button(
                        onClick = { viewModel.validar(context) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = OrangeUL
                        )
                    ) {
                        Text(
                            text = "ACTUALIZAR DATOS"
                        )
                    }
                    Button(
                        onClick = { scope.launch { bottomSheetState.show() } },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = OrangeUL
                        )
                    ) {
                        Text(
                            text = "CAMBIAR CONTRASEÑA"
                        )
                    }
                }
            }
        }
    }


}