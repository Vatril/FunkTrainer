package com.vatril.funktrainer.adapter

import android.content.Context
import android.os.Build
import android.speech.tts.TextToSpeech
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vatril.funktrainer.R
import com.vatril.funktrainer.RadioChar
import kotlinx.android.synthetic.main.radio_char_list_element.view.*
import java.util.*


class RadioListAdapter(private val context: Context) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(group: ViewGroup, number: Int) = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.radio_char_list_element, group, false)
    )

    override fun getItemCount() = RadioChar.values().size

    override fun onBindViewHolder(holder: ViewHolder, number: Int) {
        holder.setContent(RadioChar.values()[number].character, RadioChar.values()[number].text)
    }
}

class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun setContent(character: Char, text: String) {

        var error = false

        val textToSpeech = TextToSpeech(view.context, TextToSpeech.OnInitListener {
            if (it == TextToSpeech.ERROR) {
                error = true
            }
        })

        view.rl_character.text = character.toString()
        view.rl_name.text = text.capitalize()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.play_character.setOnClickListener {
                if(!error){
                    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
                }
            }
        }
    }
}