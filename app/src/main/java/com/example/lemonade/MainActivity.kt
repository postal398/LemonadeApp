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
import androidx.compose.runtime.Composable
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
                var imageSource = R.drawable.lemon_tree

                @Composable
                fun goToLemon() : Unit {
                  imageSource = R.drawable.lemon_squeeze
                }

                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Tap the lemon tree to select a lemon", fontSize = 18.sp)
                    Spacer(modifier = Modifier.size(16.dp))
                    Image(painter = painterResource(imageSource), contentDescription = "Lemon Tree",
                        modifier = Modifier
                            .border(
                                BorderStroke(2.dp, Color(105, 205, 216)),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .clickable(onClick = {println("hey")})
                    )
                }





            }
        }
    }
}

