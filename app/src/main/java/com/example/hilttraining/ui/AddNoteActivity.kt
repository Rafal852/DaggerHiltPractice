package com.example.hilttraining.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hilttraining.R
import com.example.hilttraining.databinding.ActivityAddNoteBinding
import com.example.hilttraining.db.NoteEntity
import com.example.hilttraining.repository.DbRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddNoteActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddNoteBinding

    @Inject
    lateinit var repository: DbRepository

    @Inject
    lateinit var noteEntity: NoteEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSave.setOnClickListener {
                val title = edtTitle.text.toString()
                val desc = edtDesc.text.toString()
                if (title.isNotEmpty() || desc.isNotEmpty()){
                    noteEntity = NoteEntity(0, title, desc)
                    repository.saveNote(noteEntity)
                    finish()
                }else{
                    Toast.makeText(this@AddNoteActivity, "Title and Description cannot be Empty!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}