package com.vatril.funktrainer.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.vatril.funktrainer.R
import kotlinx.android.synthetic.main.training_view.view.*


class TrainingView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    constructor(context: Context, isRandom:Boolean) : this(context, null)

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.training_view, this, true)

    }

    private fun next(){
        training_display.text = "HHH"
    }
}