package com.example.normalhackathon.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.normalhackathon.R
import com.example.normalhackathon.api.MainViewModel
import com.example.normalhackathon.model.UserAddPost
import com.example.normalhackathon.model.UserPost
import com.example.normalhackathon.ui.theme.biruzoviy
import com.example.normalhackathon.ui.theme.gol_1
import com.example.normalhackathon.ui.theme.gol_2

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel:MainViewModel
) {
    val dialogRem = remember { mutableStateOf(false) }
    val dialogCheck = remember { mutableStateOf(1) }

    val RegistrationFIO = remember { mutableStateOf("") }
    val RegistrationEmail = remember { mutableStateOf("") }
    val AuthEmail = remember { mutableStateOf("") }
    val RegistrationPasswordRetype = remember { mutableStateOf("") }
    val RegistrationPassword = remember { mutableStateOf("") }
    val AuthPassword = remember { mutableStateOf("") }
    var RegistrationPasswordVisible by remember { mutableStateOf(false) }
    var RegistrationPasswordRetypeVisible by remember { mutableStateOf(false) }
    var AuthPasswordVisible by remember { mutableStateOf(false) }

    val RegistrationPasswordIcon = if (RegistrationPasswordVisible)
        painterResource(id = R.drawable.ic_baseline_remove_red_eye_24)
    else
        painterResource(id = R.drawable.hidden)

    val RegistrationPasswordRetypeIcon = if (RegistrationPasswordRetypeVisible)
        painterResource(id = R.drawable.ic_baseline_remove_red_eye_24)
    else
        painterResource(id = R.drawable.hidden)

    val AuthPasswordIcon = if (AuthPasswordVisible)
        painterResource(id = R.drawable.ic_baseline_remove_red_eye_24)
    else
        painterResource(id = R.drawable.hidden)

    if (dialogRem.value&&dialogCheck.value == 1){
        Dialog(bol = dialogRem,text = {

            Column {
                Text(text = "Вход",modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                    textAlign = TextAlign.Center,style = MaterialTheme.typography.h6)

                OutlinedTextField(value = AuthEmail.value,onValueChange = {
                    AuthEmail.value = it
                },leadingIcon = {
                    Icon(painter = painterResource(R.drawable.login),
                        contentDescription = null,
                        Modifier.size(25.dp))
                },label = {
                    Text(text = "Логин")
                }, colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = gol_1,
                    unfocusedBorderColor = gol_2,
                    cursorColor = Color.Black
                )
                )

                OutlinedTextField(value = AuthPassword.value,onValueChange = {
                    AuthPassword.value = it
                },leadingIcon = {
                    Icon(painter = painterResource(R.drawable.password),
                        contentDescription = null,
                        Modifier.size(25.dp))
                },label = {
                    Text(text = "Пароль")
                }, trailingIcon = {
                    IconButton(onClick = { AuthPasswordVisible = !AuthPasswordVisible}) {
                        Icon(painter = AuthPasswordIcon, contentDescription = null, Modifier.size(25.dp))
                    }
                },visualTransformation =if(AuthPasswordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = gol_1,
                        unfocusedBorderColor = gol_2,
                        cursorColor = Color.Black
                    )
                )

            }
        }){

            viewModel.postUser(
                UserPost(
                    email = AuthEmail.value,
                    password = AuthPassword.value
                ),
                navController
            )

        }
    }else if (dialogRem.value&&dialogCheck.value == 2){
        Dialog(bol = dialogRem, text = {
            Column {
                Text(text = "Регистрация",modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                    textAlign = TextAlign.Center,style = MaterialTheme.typography.h6)

                OutlinedTextField(value = RegistrationFIO.value,onValueChange = {
                    RegistrationFIO.value = it
                },leadingIcon = {
                    Icon(painter = painterResource(R.drawable.login),
                        contentDescription = null,
                        Modifier.size(25.dp))
                },label = {
                    Text(text = "ФИО")
                }, colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = gol_1,
                    unfocusedBorderColor = gol_2,
                )
                )

                OutlinedTextField(value = RegistrationEmail.value,onValueChange = {
                    RegistrationEmail.value = it
                },leadingIcon = {
                    Icon(painter = painterResource(R.drawable.login),
                        contentDescription = null,
                        Modifier.size(25.dp))
                },label = {
                    Text(text = "Логин")
                }, colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = gol_1,
                    unfocusedBorderColor = gol_2,
                )
                )

                OutlinedTextField(value = RegistrationPassword.value,onValueChange = {
                    RegistrationPassword.value = it
                },leadingIcon = {
                    Icon(painter = painterResource(R.drawable.password),
                        contentDescription = null,
                        Modifier.size(25.dp))
                },label = {
                    Text(text = "Пароль")
                }, trailingIcon = {
                    IconButton(onClick = { RegistrationPasswordRetypeVisible = !RegistrationPasswordRetypeVisible}) {
                        Icon(
                            painter = RegistrationPasswordRetypeIcon,
                            contentDescription = null,
                            Modifier.size(25.dp),
                        )
                    }
                },visualTransformation =if(RegistrationPasswordRetypeVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = gol_1,
                        unfocusedBorderColor = gol_2,
                    )
                )

                OutlinedTextField(value = RegistrationPasswordRetype.value,onValueChange = {
                    RegistrationPasswordRetype.value = it
                },leadingIcon = {
                    Icon(painter = painterResource(R.drawable.password),
                        contentDescription = null,
                        Modifier.size(25.dp))
                },label = {
                    Text(text = "Повторите пароль")
                }, trailingIcon = {
                    IconButton(onClick = { RegistrationPasswordVisible = !RegistrationPasswordVisible}) {
                        Icon(
                            painter = RegistrationPasswordIcon,
                            contentDescription = null,
                            Modifier.size(25.dp),
                        )
                    }
                },visualTransformation =if(RegistrationPasswordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = gol_1,
                        unfocusedBorderColor = gol_2,
                    )
                )
            }
        }){

            viewModel.postAddUser(
                UserAddPost(
                    fio = RegistrationFIO.value,
                    email = RegistrationEmail.value,
                    password = RegistrationPassword.value
                ),
                navController
            )

        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(biruzoviy)
    ){
        Column(Modifier.fillMaxWidth()) {

            Icon(painter = painterResource(id = R.drawable.logob), contentDescription = null
                ,modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(380.dp))

        }


        Column(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonF(modifier = Modifier
                .padding(top = 350.dp)
                .width(270.dp)
                .height(50.dp),
                text = "Вход",) {
                dialogRem.value = true
                dialogCheck.value = 1
            }


            ButtonF(modifier = Modifier
                .padding(vertical = 10.dp)
                .width(270.dp)
                .height(50.dp),
                text = "Регистрация",) {
                dialogRem.value = true
                dialogCheck.value = 2
            }
        }
    }
}

@Composable
private fun Dialog(
    bol: MutableState<Boolean>,
    text: @Composable (() -> Unit)? = null,
    onClick: () -> Unit
) {

    if (bol.value){
        AlertDialog(
            onDismissRequest = { bol.value = false },
            buttons = {
                Row {
                    ButtonF(
                        modifier = Modifier.padding(start = 25.dp, end = 25.dp, bottom = 10.dp),
                        text = "Отмена"
                    ) {
                        bol.value = false
                    }
                    ButtonF(
                        modifier = Modifier.padding(start = 25.dp, end = 25.dp, bottom = 10.dp),
                        text = "Продолжить",
                        onClick = onClick
                    )
                }
            },
            text = text,
            shape = RoundedCornerShape(20.dp),
            backgroundColor = Color.White
        )
    }
}

@Composable
private fun ButtonF(modifier: Modifier, text:String, onClick:()->Unit) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = gol_1),
        shape = AbsoluteRoundedCornerShape(10.dp)
    ) {
        Text(text = text,color = Color.White)
    }
}