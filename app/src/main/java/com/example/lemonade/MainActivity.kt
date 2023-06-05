package com.example.lemonade

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.colorspace.Illuminant.A
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}


@Composable
fun LemonadeApp() {

    var Step by remember { mutableStateOf(1) } //изначально находимся на первом шаге (лимонное дерево)
    var count by remember { mutableStateOf(0) } //с нулевым счетчиком



    when (Step) {
        1 -> {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(text = "Tap the lemon tree to select a lemon", fontSize = 18.sp)
                Spacer(modifier = Modifier.size(16.dp))
                Image(painter = painterResource(R.drawable.lemon_tree), contentDescription = "Lemon Tree",
                    modifier = Modifier
                        .border(
                            BorderStroke(2.dp, Color(105, 205, 216)),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clickable(onClick = {
                            Step = 2 //при клике переходим на шаг 2 (лимон)
                            count = (2..4).random() //счетчик вместо нуля становится равен от 1 до 4
                        })
                )
            }//Конец содержания колонки
        }//Конец состояния 1
        2 -> {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(text = "Keep tapping the lemon to squeeze it", fontSize = 18.sp)
                Spacer(modifier = Modifier.size(16.dp))
                Image(painter = painterResource(R.drawable.lemon_squeeze), contentDescription = "Lemon squeeze",
                    modifier = Modifier
                        .border(
                            BorderStroke(2.dp, Color(105, 205, 216)),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clickable(onClick = {
                            count--
                            when (count) {
                                0 -> {Step = 3}
                            }
                        })
                )
            }
        } //Конец состояния 2
        3 -> {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(text = "Tap the lemonade to drink it", fontSize = 18.sp)
                Spacer(modifier = Modifier.size(16.dp))
                Image(painter = painterResource(R.drawable.lemon_drink), contentDescription = "Lemon drink",
                    modifier = Modifier
                        .border(
                            BorderStroke(2.dp, Color(105, 205, 216)),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clickable(onClick = { Step = 4 })
                )
            }
        }//Конец состояния 3

        4 -> {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(text = "Tap the empty glass to start again", fontSize = 18.sp)
                Spacer(modifier = Modifier.size(16.dp))
                Image(painter = painterResource(R.drawable.lemon_restart), contentDescription = "Lemon restart",
                    modifier = Modifier
                        .border(
                            BorderStroke(2.dp, Color(105, 205, 216)),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clickable(onClick = { Step = 1 }))
        }
      }
    }//Конец описания ВСЕХ состояний



} //Конец app fun

//

