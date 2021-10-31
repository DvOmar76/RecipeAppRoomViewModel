package com.example.recipeapproomoptional

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_book_details.*

class BookDetails : AppCompatActivity() {
    lateinit var manViewModel: ManViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)
        manViewModel= ManViewModel(application)
        btnSave.setOnClickListener {
            manViewModel.addBook(edAuthor.text.toString(), edIngredients.text.toString(), edInstructions.text.toString(), edTitle.text.toString())
           clear()
        }
    }


    fun goBack(view: android.view.View) {
        startActivity(Intent(applicationContext,MainActivity::class.java))
    }
    fun clear(){
        edAuthor.text.clear()
        edIngredients.text.clear()
        edTitle.text.clear()
        edInstructions.text.clear()
    }
}