package com.example.android_todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.ComponentActivity

import com.example.android_todolist.ui.theme.AndroidTodoListTheme

class MainActivity : ComponentActivity() {
    private lateinit var todoAdapter: `Todo-Adapter`

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoList = mutableListOf<JustTodo>()
        todoAdapter = `Todo-Adapter`(this, todoList)

        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = todoAdapter

        val addButton: Button = findViewById(R.id.addButton)
        val inputText: EditText = findViewById(R.id.inputText)

        addButton.setOnClickListener{
            val newItem = inputText.text.toString()
            if(newItem.isNotEmpty()){
                val todoItem = JustTodo(newItem)
                todoList.add(todoItem)
                todoAdapter.notifyDataSetChanged()
                inputText.text.clear()
            }
        }
    }
    fun deleteItem(position: Int){
        val todoList: MutableList<JustTodo> = todoAdapter.getList()
        todoList.removeAt(position)
        todoAdapter.notifyDataSetChanged()
    }
}




