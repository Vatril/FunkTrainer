package com.vatril.funktrainer.fragment

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
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import android.widget.EditText


class TrainingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.training_view, null)

        view.training_display.text = challenge.prompt
        view.training_input.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && view.training_input.text.isNotEmpty()) {
                val error = findError(view.training_input)
                if (error == null) {
                    next(view)
                } else {
                    view.training_error.text = view.context.getString(R.string.character_incorrect, error.character)
                }

                val colorAnim = ValueAnimator.ofObject(
                    ArgbEvaluator(),
                    ContextCompat.getColor(
                        view.context, when (error) {
                            null -> R.color.success
                            else -> R.color.error
                        }
                    ),
                    ContextCompat.getColor(view.context, R.color.background)
                )

                with(colorAnim) {
                    colorAnim.duration = 500

                    addUpdateListener { animator ->
                        view.training_bg.setBackgroundColor(
                            animator.animatedValue as Int
                        )
                    }

                    start()
                }
            }
            true
        }

        return view
    }

    private var challenge = ChallengeGenerator.random()

    private fun next(view: View) {
        challenge = ChallengeGenerator.random()
        view.training_display.text = challenge.prompt
        view.training_input.text.clear()
        view.training_error.text = ""
    }

    private fun findError(training_input: EditText): RadioChar? {
        val entered = training_input.text.split(" ").map(String::toLowerCase)
        challenge.solution
            .forEachIndexed { index, c ->
                if (entered.size <= index || c.text != entered[index])
                    return c
            }
        return null
    }
}