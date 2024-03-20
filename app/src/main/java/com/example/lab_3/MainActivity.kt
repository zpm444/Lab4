package com.example.lab_3

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val list: RecyclerView = findViewById(R.id.listOfBooks)
        val adapter = BooksAdapter(booksCreate(), this::onBookItemClicked)
        list.adapter = adapter

    }

    private fun onBookItemClicked(items: List<String>) {
        val fragment : Fragment =  FirstFragment.newInstance()
        val bundle : Bundle = Bundle()
        bundle.putString("name", items[0])
        bundle.putString("description", items[1])
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_host, fragment, null)
            .commit()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        val orientation = this.resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            findViewById<View>(R.id.fragment_host).visibility = View.GONE
            findViewById<View>(R.id.listOfBooks).layoutParams.width = LayoutParams.MATCH_PARENT
        } else {
            findViewById<View>(R.id.fragment_host).visibility = View.VISIBLE
            findViewById<View>(R.id.listOfBooks).layoutParams.width = LayoutParams.WRAP_CONTENT
        }
    }

}
