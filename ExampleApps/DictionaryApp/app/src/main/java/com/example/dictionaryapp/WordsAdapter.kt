package com.example.dictionaryapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.annotations.TestOnly

class WordsAdapter(private val mContext: Context,private val wordsList:List<Words>):RecyclerView.Adapter<WordsAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(design:View):RecyclerView.ViewHolder(design){
        var card_words:CardView
        var textViewEnglish:TextView
        var textViewTurkish:TextView

        init {
            card_words=design.findViewById(R.id.card_words)
            textViewEnglish=design.findViewById(R.id.textViewEnglish)
            textViewTurkish=design.findViewById(R.id.textViewTurkish)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.card_design,parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val word = wordsList.get(position)
        holder.textViewEnglish.text=word.english
        holder.textViewTurkish.text=word.turkish

        holder.card_words.setOnClickListener{
            val intent = Intent(mContext,DetailActivity::class.java)
            intent.putExtra("object",word)
            mContext.startActivities(arrayOf(intent))
        }
    }

    override fun getItemCount(): Int {
        return wordsList.size
    }
}