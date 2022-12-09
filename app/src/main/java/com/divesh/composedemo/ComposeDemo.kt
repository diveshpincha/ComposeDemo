package com.divesh.composedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ComposeDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { helloWorld() }
    }
}

val devs = mutableListOf("Mani","Mahi","Arun","Jaya","MArk","Divesh","mystery")

@Preview
@Composable
fun helloWorld(){
    Row {
        buttonWithBackground()
        Spacer(modifier = Modifier.width(5.dp))
        Column {
            Text(text = "Hello world", color = Color.Blue, modifier = Modifier
                .border(1.dp, Color.Cyan, CircleShape)
                .padding(10.dp))
            Spacer(modifier = Modifier.height(11.dp))


            var isVisible by remember { mutableStateOf(false) }
            Surface(color = Color.Gray, modifier = Modifier
                .background(Color.Gray, CircleShape)
                .border(4.dp, Color.Green, CircleShape)
                .clickable(role = Role.Button) { isVisible = !isVisible }) {
                Text(text = "Android Developers", modifier = Modifier
                    .padding(10.dp)
                )
            }

            AnimatedVisibility(isVisible) {
                LazyColumn {
                    //devs.map { item { Text(text = it) } }
                    devs.forEach {
                        item { buttonWithBackground(text = it) }
                    }
                }

            }
        }
    }
}

@Composable
fun buttonWithBackground(text:String=""){
    Surface(modifier = Modifier.padding(10.dp)) {
        Column {
            Text(text = text,Modifier.padding(8.dp,0.dp,0.dp,0.dp))
            Image(painter = painterResource(id = R.drawable.add_manually_icon), contentDescription ="tick",
                modifier = Modifier
                    .clip(CircleShape)
                    .border(3.dp, Color.Magenta, CircleShape))
        }
    }
}





/*Gradle Setup
* 1. Hello world - Text
* 2. 2nd Text
* 3. Layouts
* 4. Image View (Modifier =  clip , size )
* 5. Spacing & PAdding : Spacer VS inside height/width + modifiers.
* 6. Surface + Modifier Borders
* 7. Lists
* 8. Clicks ( Modifier.Clickable ) & Animation ( long text expand )
* 9. View visibility : Animated
*
* */
