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

class Data (val textAbove:String,
            val img:Painter,
            val descrOfImg:String,
            val step:Int,
            val classCount:Int,
            private val updateStep: (Int) -> Unit,
            private val updateCount: (Int) -> Unit
                                ) {
@Composable
public fun UI_generalizing(){
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
                    .clickable(onClick = {
                        updateStep(step)
                        updateCount(classCount)
                    })
            )
        }//Конец содержания колонки


}}