package com.example.lab_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.*
import androidx.fragment.app.Fragment
import org.jetbrains.annotations.Nullable

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.details_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arguments = super.getArguments()

        if(arguments != null){
            val name = arguments.getString("name")
            val description = arguments.getString("description")

            view.findViewById<TextView>(R.id.Book_name).text = name.toString()
            view.findViewById<TextView>(R.id.description).text = description.toString()

        }
    }

    companion object {
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }
}