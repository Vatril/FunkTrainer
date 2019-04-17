package com.vatril.funktrainer.view

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.vatril.funktrainer.R
import com.vatril.funktrainer.util.ChallengeGenerator
import kotlinx.android.synthetic.main.training_view.view.*


class TrainingView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    constructor(context: Context, isRandom:Boolean) : this(context, null)

    private var challenge = ChallengeGenerator.random()

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.training_view, this, true)

        training_display.text = challenge.prompt
        training_input.setOnKeyListener { v, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_ENTER){
                if(isCorrect()){
                    next()
                }else{
                    //Todo add error screen
                }
            }
            true
        }
    }

    private fun next(){
        challenge = ChallengeGenerator.random()
        training_display.text = challenge.prompt
        training_input.text.clear()
    }

    private fun isCorrect():Boolean{
        val entered = training_input.text.split(" ").map(String::toLowerCase)
        challenge.solution
            .forEachIndexed { index, c ->
                if(c.text != entered[index])
                    return false
            }
        return true
    }
}