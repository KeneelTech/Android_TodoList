package com.example.android_todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView


class `Todo-Adapter`(private val context: Context, private val todolist: MutableList<`JustTodo`>) : BaseAdapter() {

    override fun getCount(): Int {
       return todolist.size
    }

    override fun getItem(position: Int): Any {
        return todolist[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.todo_item_layout, parent, false)

        val todoItem: `JustTodo` = todolist[position]

        val todoTextView: TextView = view.findViewById(R.id.todoTextView)

        val deleteButton: Button = view.findViewById(R.id.deleteButton)

        todoTextView.text = todoItem.title

        deleteButton.setOnClickListener{
            if (context is MainActivity){
                context.deleteItem(position)
            }
        }
        return view
    }

    fun getList(): MutableList<JustTodo>{
        return todolist
    }
}

