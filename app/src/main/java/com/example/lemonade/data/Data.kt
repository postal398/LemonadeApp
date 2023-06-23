package com.example.lemonade.data

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Data (val textAbove:String, //пишем вручную прямо в Composable функции
            val img:Painter, // пишем вручную прямо в Composable функции
            val descrOfImg:String, // пишем вручную прямо в Composable функции
            val step:Int, //значение которое будет передано в updateStep, позже в переменную Step (которая во VM)
            var classCount:Int,//значение которое будет передано в updateCount, позже в переменную count (которая во VM)
            private val updateStep: (Int) -> Unit, //лямбда для инкапсуляции, в Composable одноимённо
            private val updateCount: (Int) -> Unit //лямбда для инкапсуляции, в Composable одноимённо
                                ) {
@Composable
public fun UI_generalizing(){ //То что будет на экране
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = textAbove, fontSize = 18.sp)
            Spacer(modifier = Modifier.size(16.dp))
            Image(painter = img, contentDescription = descrOfImg,
                modifier = Modifier
                    .border(
                        BorderStroke(2.dp, Color(105, 205, 216)),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .clickable(onClick = { //При клике на картинку
                        if (step == 2) {classCount--} //Если шаг 2, то уменьшаем счётчик, что бы жать типа сок из лимона
                        //И когда он скликается до 0,в самом Composable произойдет переключение шага (костыль конечно)
                        updateStep(step) //Если это не лимон, то передаем при клике на следующей степ
                        updateCount(classCount) //берём classСount и отправляем во VM
                    })
            )
        }//Конец содержания колонки


}}