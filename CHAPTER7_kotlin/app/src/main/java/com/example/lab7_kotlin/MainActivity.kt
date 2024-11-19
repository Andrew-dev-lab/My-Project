package com.example.lab7_kotlin

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    data class Data(
        val photo: Int,
        val name: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transNameArray = arrayOf("bicycle", "motorcycle", "car", "bus", "airplane", "ship")
        val transPhotoIdArray = intArrayOf(
            R.drawable.trans1,
            R.drawable.trans2,
            R.drawable.trans3,
            R.drawable.trans4,
            R.drawable.trans5,
            R.drawable.trans6
        )

        val transData = Array(transNameArray.size) { i ->
            Data(transPhotoIdArray[i], transNameArray[i])
        }

        val transAdapter = MyAdapter(transData, R.layout.trans_list)
        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.adapter = transAdapter

        val cubeNameArray = arrayOf(
            "Goodbye", "Angry", "Faint", "Snicker", "Great", "Hello", "Frightened", "Laughing"
        )
        val cubeePhotoIdArray = intArrayOf(
            R.drawable.cubee1, R.drawable.cubee2, R.drawable.cubee3, R.drawable.cubee4,
            R.drawable.cubee5, R.drawable.cubee6, R.drawable.cubee7, R.drawable.cubee8,
            R.drawable.cubee9, R.drawable.cubee10
        )

        val cubeeData = Array(cubeNameArray.size) { i ->
            Data(cubeePhotoIdArray[i], cubeNameArray[i])
        }

        val cubeeAdapter = MyAdapter(cubeeData, R.layout.cubee_list)
        val gridView: GridView = findViewById(R.id.gridView)
        gridView.adapter = cubeeAdapter
        gridView.numColumns = 3

        val messageArray = arrayOf("Message 1", "Message 2", "Message 3", "Message 4", "Message 5", "Message 6")
        val messageAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, messageArray)

        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = messageAdapter
    }

    inner class MyAdapter(
        private val data: Array<Data>,
        private val layoutRes: Int
    ) : BaseAdapter() {

        override fun getCount(): Int = data.size

        override fun getItem(position: Int): Any = data[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = convertView ?: layoutInflater.inflate(layoutRes, parent, false)
            val name: TextView = view.findViewById(R.id.name)
            name.text = data[position].name

            val imageView: ImageView = view.findViewById(R.id.imageView)
            imageView.setImageResource(data[position].photo)

            return view
        }
    }
}