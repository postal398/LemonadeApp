package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lemonade.data.Data
import com.example.lemonade.ui.LemonadeViewModel
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

    val viewModel: LemonadeViewModel = viewModel() //экземпляр класса ViewModel именно внутри Composable функции.

    val updateStep: (Int) -> Unit = { newStep -> viewModel.updateStep(newStep) } //лямбда для передачи обновления шага вьюмодель
    val updateCount: (Int) -> Unit = { newCount -> viewModel.updateCount(newCount) } //лямбда для передачи обновления счетчика


    when (viewModel.step.value) { //получаем шаг из вьюМодели

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
            if (viewModel.count.value == 0) {decrementStep = 3} //когда счетчик заданный сверху (Int от 1 до 4) скликается до 0, степ будет = 3
            val secondState = Data("Keep tapping the lemon to squeeze it",
                painterResource(R.drawable.lemon_squeeze),
                "Lemon squeeze",
                decrementStep, classCount = viewModel.count.value, updateStep = updateStep,
                updateCount = updateCount
                )
            secondState.UI_generalizing()
        } //Конец состояния 2

        3 -> {

            val thirdState = Data(
                "Tap the lemonade to drink it",
                painterResource(R.drawable.lemon_drink),
                "Lemon drink",
                4, viewModel.count.value, updateStep = updateStep, updateCount = updateCount
            )
            thirdState.UI_generalizing()
        }//Конец состояния 3

        4 -> {

            val fourthState = Data("Tap the empty glass to start again",
                painterResource(R.drawable.lemon_restart),
                "Lemon restart",
                1, viewModel.count.value, updateStep = updateStep, updateCount = updateCount
                )
            fourthState.UI_generalizing()
      }//Конец состояния 4
    }//Конец описания ВСЕХ состояний



} //Конец app fun

