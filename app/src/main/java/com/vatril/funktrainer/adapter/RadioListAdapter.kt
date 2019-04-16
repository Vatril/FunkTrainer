package com.vatril.funktrainer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vatril.funktrainer.R
import com.vatril.funktrainer.RadioChar


class RadioListAdapter(private val context: Context): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(group: ViewGroup, number: Int) = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.radio_char_list_element, group, false)
    )

    override fun getItemCount() = RadioChar.values().size

    override fun onBindViewHolder(holder: ViewHolder, number: Int) {
        holder.setContent(RadioChar.values()[number].character, RadioChar.values()[number].text)
    }
}

class ViewHolder(private val view:View): RecyclerView.ViewHolder(view){
    fun setContent(character: Char, text:String){
        view.findViewById<TextView>(R.id.rl_character).text = character.toString()
        view.findViewById<TextView>(R.id.rl_name).text = text.capitalize()
    }
}