package com.example.noteapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val mContext:Context,private val notesList:List<Notes>):RecyclerView.Adapter<NotesAdapter.HolderCardDesign>() {

    inner class HolderCardDesign(design:View) : RecyclerView.ViewHolder(design){
        var note_card:CardView
        var textViewLesson:TextView
        var textViewNoteOne:TextView
        var textViewNoteTwo:TextView

        init{
        note_card = design.findViewById(R.id.note_card)
        textViewLesson = design.findViewById(R.id.textViewLesson)
        textViewNoteOne = design.findViewById(R.id.textViewNoteOne)
        textViewNoteTwo = design.findViewById(R.id.textViewNoteTwo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderCardDesign {
        val design = LayoutInflater.from(mContext).inflate(R.layout.card_design,parent,false)
        return HolderCardDesign(design)
    }

    override fun onBindViewHolder(holder: HolderCardDesign, position: Int) {
        val note = notesList.get(position)
        holder.textViewLesson.text=note.lesson_name
        holder.textViewNoteOne.text=(note.not_one).toString()
        holder.textViewNoteTwo.text=(note.not_two).toString()

        holder.note_card.setOnClickListener{
            val intent = Intent(mContext,DetailActivity::class.java)
            intent.putExtra("object",note)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }
}