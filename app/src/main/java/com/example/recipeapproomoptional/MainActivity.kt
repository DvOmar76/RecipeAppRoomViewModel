package com.example.recipeapproomoptional

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.recipeapproomoptional.DBRoom.Book
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
     val manViewModel by lazy { ViewModelProvider(this).get(ManViewModel::class.java) }
     var books=emptyList<Book>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manViewModel.getBooks().observe(this,{
            listbooks->books=listbooks
            var text=""
            for (book in books){
                text+="title: ${book.title}\nauthor: ${book.author}\ningredients: ${book.ingredients}\ninstructions:${book.instructions}\n\n"
            }
            textView.text=text
        })


    }




    fun toSecondPage(view: android.view.View) {
        startActivity(Intent(applicationContext,BookDetails::class.java))
    }

}
