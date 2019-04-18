package com.vatril.funktrainer.view

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.vatril.funktrainer.R
import com.vatril.funktrainer.RadioChar
import com.vatril.funktrainer.util.ChallengeGenerator
import kotlinx.android.synthetic.main.training_view.view.*
import android.animation.ArgbEvaluator
import android.support.v4.content.ContextCompat
import android.animation.ValueAnimator.AnimatorUpdateListener


class TrainingView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    constructor(context: Context, isRandom: Boolean) : this(context, null)

    private var challenge = ChallengeGenerator.random()

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.training_view, this, true)

        training_display.text = challenge.prompt
        training_input.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && training_input.text.isNotEmpty()) {
                val error = findError()
                if (error == null) {
                    next()
                } else {
                    training_error.text = context.getString(R.string.character_incorrect, error.character)
                }

                val colorAnim = ValueAnimator.ofObject(
                    ArgbEvaluator(),
                    ContextCompat.getColor(context, when(error){
                        null -> R.color.success
                        else -> R.color.error
                    }),
                    ContextCompat.getColor(context, R.color.background)
                )

                with(colorAnim) {
                    colorAnim.duration = 500

                    addUpdateListener { animator ->
                        training_bg.setBackgroundColor(
                            animator.animatedValue as Int
                        )
                    }

                    start()
                }
            }
            true
        }
    }

    private fun next() {
        challenge = ChallengeGenerator.random()
        training_display.text = challenge.prompt
        training_input.text.clear()
        training_error.text = ""
    }

    private fun findError(): RadioChar? {
        val entered = training_input.text.split(" ").map(String::toLowerCase)
        challenge.solution
            .forEachIndexed { index, c ->
                if (entered.size <= index || c.text != entered[index])
                    return c
            }
        return null
    }
}