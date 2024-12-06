package com.example.examenandroid_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.examenandroid_1.R
import com.google.android.material.textfield.TextInputLayout

private const val NAME = "name"
private const val LAST_NAME = "last name"

class WelcomeFragment : Fragment() {
    private var name: String? = null
    private var lastName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME)
            lastName = it.getString(LAST_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val txtWelcome = view.findViewById<TextView>(R.id.txtWelcome)
        txtWelcome.text = "Welcome, $name $lastName!"

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String, lastName: String) =
            WelcomeFragment().apply {
                arguments = Bundle().apply {
                    putString(NAME, name)
                    putString(LAST_NAME, lastName)
                }
            }
    }
}