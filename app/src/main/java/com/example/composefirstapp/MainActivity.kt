package com.example.composefirstapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefirstapp.ui.theme.ComposeFirstAppTheme


private val messages: List<MyMessage> = listOf(
    MyMessage("Hola soy Pole", "Estamos ready"),
    MyMessage("Hola soy Pole2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Hola soy Pole3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur"),
    MyMessage("Hola soy Pole4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Hola soy Pole5", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "),
    MyMessage("Hola soy Pole6", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.") ,
    MyMessage("Hola soy Pole7", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "),
    MyMessage("Hola soy Pole8", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit "),
    MyMessage("Hola soy Pole9", "Estamos ready"),
    MyMessage("Hola soy Pole10", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis "),
    MyMessage("Hola soy Pole11", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFirstAppTheme() {
                MyMessages(messages)
            }
        }
    }
}
data class MyMessage(val title: String, val body: String)
@Composable
fun MyMessages(messages: List<MyMessage>){
    LazyColumn{
        items(messages){
            message -> MyComponent(message = message)
        }
    }
}
@Composable
fun MyComponent(message: MyMessage){
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(12.dp)
    ){
        MyImage()
        MyTexts(message)
    }
}
@Composable
fun MyImage(){
    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Mi imagen de prueba",
        modifier = Modifier
            .padding(end = 8.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .size(64.dp))
}
@Composable
fun MyTexts(message: MyMessage){
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier.clickable {
        expanded = !expanded
    }
    ) {
        Spacer(Modifier.height(8.dp))
        MyText(message.title, MaterialTheme.colors.primary, MaterialTheme.typography.subtitle1)
        Spacer(Modifier.height(8.dp))
        MyText(message.body, MaterialTheme.colors.onBackground, MaterialTheme.typography.subtitle2,
        if(expanded) Int.MAX_VALUE else 1)
    }
}
@Composable
fun MyText(text: String, color: Color, style: androidx.compose.ui.text.TextStyle, lines: Int = Int.MAX_VALUE){
    Text(text, color= color, style= style, maxLines= lines)
}
@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent(){
    ComposeFirstAppTheme {
        MyMessages(messages = messages)
    }

}