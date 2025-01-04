package com.example.counter_mvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() {

    private val _repository = CounterRepository()
    private val _count = mutableIntStateOf(_repository.getCounter().count)

    val getCount: MutableState<Int> = _count

    fun onIncrement() {
        _repository.increment()
       _count.intValue = _repository.getCounter().count
    }

    fun onDecrement() {
        _repository.decrement()
        _count.intValue = _repository.getCounter().count
    }

    fun onRest() {
        _repository.reset()
        _count.intValue = _repository.getCounter().count
    }
}