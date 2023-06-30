package com.example.lemonade.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LemonadeViewModel : ViewModel() {
    private val _step = mutableStateOf(1) //видимость только внутри класса
    val step: State<Int> = _step //для чтения из других классов, но не изменения

    private val _count = mutableStateOf(0) //видимость только внутри класса
    val count: State<Int> = _count //для чтения из других классов, но не изменения

    fun updateStep(newStep: Int) {
        _step.value = newStep //для изменения значений Step'a извне
    }

    fun updateCount(newCount: Int) {
        _count.value = newCount //для изменения значений Count'a извне
    }
}