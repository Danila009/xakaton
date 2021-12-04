
package com.example.testvoronkov

import com.example.testvoronkov.R
import android.app.Dialog
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testvoronkov.ui.theme.*

import kotlinx.coroutines.NonCancellable.start
import kotlin.math.log

class Belakov : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            val darkVakue = isSystemInDarkTheme()

            val currentStyle = remember { mutableStateOf(JetHabbitStyle.TextPrimary)}
            val isDarkMode = remember { mutableStateOf(darkVakue)}

            MainThem(
                style = currentStyle.value,
                darkThem = isDarkMode.value
            ) {

                val check = remember {
                    mutableStateOf(false)
                }
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(check.value)
                }

            }
        }
    }
}



@Composable
fun Greeting(check:Boolean) {
    val context = LocalContext.current
    val dialogRem = remember { mutableStateOf(false) }

    val dialogCheck = remember { mutableStateOf(1)}

    val login = remember { mutableStateOf("")}
    val login1 = remember { mutableStateOf("")}
    val password = remember { mutableStateOf("")}
    val password1 = remember { mutableStateOf("")}
    val password2 = remember { mutableStateOf("")}
    var passwordVisibility by remember { mutableStateOf(false) }
    var passwordVisibility1 by remember { mutableStateOf(false) }
    var passwordVisibility2 by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.ic_baseline_remove_red_eye_24)
    else
        painterResource(id = R.drawable.hidden)

    val icon1 = if (passwordVisibility1)
        painterResource(id = R.drawable.ic_baseline_remove_red_eye_24)
    else
        painterResource(id = R.drawable.hidden)

    val icon2 = if (passwordVisibility2)
        painterResource(id = R.drawable.ic_baseline_remove_red_eye_24)
    else
        painterResource(id = R.drawable.hidden)

    if (dialogRem.value&&dialogCheck.value == 1){
        Dialog(bol = dialogRem,title = "",text = {

            Column {
                Text(text = "Вход",modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                    textAlign = TextAlign.Center,style = MaterialTheme.typography.h6,color = JetHabbitTheme.colors.primaryText)

                OutlinedTextField(value = login1.value,onValueChange = {
                    login1.value = it
                },leadingIcon = {
                    Icon(painter = painterResource(R.drawable.login),
                        contentDescription = null,
                        Modifier.size(25.dp),)
                },label = {
                    Text(text = "Логин",color = JetHabbitTheme.colors.primaryText)
                }, colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = gol_1,
                    unfocusedBorderColor = gol_2,
                    textColor = JetHabbitTheme.colors.primaryText
                )
                )

                OutlinedTextField(value = password2.value,onValueChange = {
                    password2.value = it
                },leadingIcon = {
                    Icon(painter = painterResource(R.drawable.password),
                        contentDescription = null,
                        Modifier.size(25.dp),)
                },label = {
                    Text(text = "Пароль",color = JetHabbitTheme.colors.primaryText)
                }, trailingIcon = {
                    IconButton(onClick = { passwordVisibility2 = !passwordVisibility2}) {
                        Icon(painter = icon2, contentDescription = null, Modifier.size(25.dp))
                    }
                },visualTransformation =if(passwordVisibility2) VisualTransformation.None
                else PasswordVisualTransformation(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = gol_1,
                        unfocusedBorderColor = gol_2,
                        textColor = JetHabbitTheme.colors.primaryText
                    )
                )

            }


        }){
            Toast.makeText(context, "Вход", Toast.LENGTH_SHORT).show()
        }
    }else if (dialogRem.value&&dialogCheck.value == 2){
        Dialog(bol = dialogRem,title = "Регистрация", text = {
            Column {
                Text(text = "Регистрация",modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                    textAlign = TextAlign.Center,style = MaterialTheme.typography.h6,color = JetHabbitTheme.colors.primaryText)

                OutlinedTextField(value = login.value,onValueChange = {
                    login.value = it
                },leadingIcon = {
                    Icon(painter = painterResource(R.drawable.login),
                        contentDescription = null,
                        Modifier.size(25.dp),)
                },label = {
                    Text(text = "Логин",color = JetHabbitTheme.colors.primaryText)
                }, colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = gol_1,
                    unfocusedBorderColor = gol_2,
                    textColor = JetHabbitTheme.colors.primaryText
                )
                )

                OutlinedTextField(value = password1.value,onValueChange = {
                    password1.value = it
                },leadingIcon = {
                    Icon(painter = painterResource(R.drawable.password),
                        contentDescription = null,
                        Modifier.size(25.dp),)
                },label = {
                    Text(text = "Пароль",color = JetHabbitTheme.colors.primaryText)
                }, trailingIcon = {
                    IconButton(onClick = { passwordVisibility1 = !passwordVisibility1}) {
                        Icon(painter = icon1, contentDescription = null, Modifier.size(25.dp))
                    }
                },visualTransformation =if(passwordVisibility1) VisualTransformation.None
                else PasswordVisualTransformation(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = gol_1,
                        unfocusedBorderColor = gol_2,
                        textColor = JetHabbitTheme.colors.primaryText
                    )
                )

                OutlinedTextField(value = password.value,onValueChange = {
                    password.value = it
                },leadingIcon = {
                    Icon(painter = painterResource(R.drawable.password),
                        contentDescription = null,
                        Modifier.size(25.dp),)
                },label = {
                    Text(text = "Повторите пароль",color = JetHabbitTheme.colors.primaryText)
                }, trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility}) {
                        Icon(painter = icon, contentDescription = null, Modifier.size(25.dp))
                    }
                },visualTransformation =if(passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = gol_1,
                        unfocusedBorderColor = gol_2,
                        textColor = JetHabbitTheme.colors.primaryText
                    )
                )
            }
        }){
            Toast.makeText(context, "Регистрация", Toast.LENGTH_SHORT).show()
        }
    }


    Scaffold(bottomBar = {
        if (check){
            Column(
                Modifier
                    .background(Color.Gray)
                    .fillMaxWidth()
                    .height(20.dp)) {

            }
            Text(text = "Нет подключения",color = JetHabbitTheme.colors.primaryText,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),textAlign = TextAlign.Center)
        }
    }) {

        Box(modifier = Modifier
            .fillMaxSize()
            .background(JetHabbitTheme.colors.gradient)
        ){
            Column(Modifier.fillMaxWidth()) {
                Text(text = "TEST TEXT",modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(top = 100.dp),
                    fontWeight = FontWeight.W100,fontSize = 40.sp,textDecoration = TextDecoration.Underline,
                    fontStyle = FontStyle.Italic,
                    style = TextStyle(color = gol,fontSize = 20.sp))
            }


            Column(
                Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = CenterHorizontally) {
                Spacer(modifier = Modifier.size(200.dp))
                ButtonF(modifier = Modifier
                    .padding(vertical = 10.dp)
                    .width(270.dp).height(80.dp),
                    text = "Вход",) {
                    dialogRem.value = true
                    dialogCheck.value = 1
                }
            }
        }
    }
}

@Composable
fun Dialog(bol: MutableState<Boolean>,title: String,text: @Composable (() -> Unit)? = null,onClick: () -> Unit) {

    if (bol.value){
        AlertDialog(onDismissRequest = {bol.value = false},buttons = {
            Row {
                ButtonF(modifier = Modifier.padding(start = 25.dp,end = 25.dp,bottom = 10.dp), text = "Отмена") {
                    bol.value = false
                }
                ButtonF(modifier = Modifier.padding(start = 25.dp,end = 25.dp,bottom = 10.dp), text = "Продолжить",onClick = onClick)
            }
        },text = text, shape = RoundedCornerShape(20.dp), backgroundColor = JetHabbitTheme.colors.primaryBackground)
    }
}

@Composable
fun ButtonF(modifier:Modifier,text:String,onClick:()->Unit) {
    Button(onClick = onClick,modifier = modifier,colors = ButtonDefaults.buttonColors(backgroundColor = gol_1),shape = AbsoluteCutCornerShape(5.dp)) {
        Text(text = text,color = JetHabbitTheme.colors.primaryText)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {

    val darkVakue = isSystemInDarkTheme()

    val currentStyle = remember { mutableStateOf(JetHabbitStyle.TextPrimary)}
    val isDarkMode = remember { mutableStateOf(darkVakue)}

    MainThem(
        style = currentStyle.value,
        darkThem = isDarkMode.value
    ) {
        val check = remember {
            mutableStateOf(false)
        }
        Surface(color = MaterialTheme.colors.background) {
            Greeting(check.value)
        }
    }

}
