package ru.job4j.dagger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var store: Store
    private lateinit var mViewForNotes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.store?.injectTo(this)
        mViewForNotes = list_of_notes
        mViewForNotes.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = NotesAdapter(store.all)
        }
    }

    fun add(view: View) {
        store.add(note.text.toString())
        mViewForNotes.adapter?.notifyItemInserted(store.all.size - 1)
    }

    class NoteHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.note_item, parent, false)) {

        fun bind(hour: String) {
            itemView.findViewById<TextView>(R.id.note_rv).text = hour
        }
    }

    class NotesAdapter(private val mNotes: List<String>) : RecyclerView.Adapter<NoteHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder =
            NoteHolder(LayoutInflater.from(parent.context), parent)

        override fun onBindViewHolder(holder: NoteHolder, position: Int) = holder.bind(mNotes[position])

        override fun getItemCount() = mNotes.size
    }
}