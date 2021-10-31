package com.example.recipeapproomoptional

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.recipeapproomoptional.DBRoom.Book
import com.example.recipeapproomoptional.DBRoom.BookDao
import com.example.recipeapproomoptional.DBRoom.BookDatabase

class ManViewModel(application: Application):AndroidViewModel(application) {
    private val books:LiveData<List<Book>>
    var dbRoom:BookDao
    val app=application
    init {
        dbRoom=BookDatabase.getInstance(app).bookDao()
        books=dbRoom.getAll()
    }
    fun getBooks():LiveData<List<Book>>{
        return books
    }
    fun addBook(author:String,ingredients:String,instructions:String,title:String){

        if (title.isNotEmpty()&&author.isNotEmpty()&&ingredients.isNotEmpty()&&instructions.isNotEmpty())
        {
            dbRoom.addBook(Book(0,author,ingredients,instructions,title))
            Toast.makeText(app, "book is added ", Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(app, "please complete the fields", Toast.LENGTH_SHORT).show()
        }
    }

}