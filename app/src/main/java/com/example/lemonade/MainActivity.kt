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
import com.example.lemonade.data.Data
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
    var count by remember { mutableStateOf(0) } //с нулевым счетчиком кликов (для перехода со степ 2 на степ 3)


    val updateStep: (Int) -> Unit = { newStep -> Step = newStep }
    val updateCount: (Int) -> Unit = { newCount -> count = newCount }

    when (Step) {

        1 -> {
          val firstState =  Data("Tap the lemon tree to select a lemon",
                painterResource(R.drawable.lemon_tree),
                "Lemon Tree",
                2, classCount =  (2..4).random() , updateStep = updateStep, //count будет равен числу от 1 до 4
                updateCount = updateCount //при клике step = 2, и переход к тому что ниже
            )
          firstState.UI_generalizing()
        }//Конец состояния 1


        2 -> {
            var decrementStep = 2 //шаг кодируем, потому что он будет меняться от кликов
            if (count == 0) {decrementStep = 3} //когда счетчик заданный сверху (Int от 1 до 4) скликается до 0, степ будет = 3
            val secondState = Data("Keep tapping the lemon to squeeze it",
                painterResource(R.drawable.lemon_squeeze),
                "Lemon squeeze",
                decrementStep, classCount = count, updateStep = updateStep,
                updateCount = updateCount
                )
            secondState.UI_generalizing()
        } //Конец состояния 2


        3 -> {

            val thirdState = Data(
                "Tap the lemonade to drink it",
                painterResource(R.drawable.lemon_drink),
                "Lemon drink",
                4, count, updateStep = updateStep, updateCount = updateCount
            )
            thirdState.UI_generalizing()
        }//Конец состояния 3

        4 -> {

            val fourthState = Data("Tap the empty glass to start again",
                painterResource(R.drawable.lemon_restart),
                "Lemon restart",
                1, count, updateStep = updateStep, updateCount = updateCount
                )
            fourthState.UI_generalizing()
      }//Конец состояния 4
    }//Конец описания ВСЕХ состояний



} //Конец app fun

//

