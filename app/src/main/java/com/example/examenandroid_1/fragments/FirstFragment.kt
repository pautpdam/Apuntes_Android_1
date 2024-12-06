package com.example.examenandroid_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.examenandroid_1.R
import com.example.examenandroid_1.interfaces.OnClickListener
import com.google.android.material.textfield.TextInputLayout

class FirstFragment : Fragment() {
    private var listener: OnClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val btnClick = view.findViewById<Button>(R.id.btnFragmentClick)
        val inName = view.findViewById<TextInputLayout>(R.id.inNombre)
        val inLastName = view.findViewById<TextInputLayout>(R.id.inApellidos)

        btnClick.setOnClickListener{
            val name = inName.editText?.text.toString()
            val lastName = inLastName.editText?.text.toString()

            if (name.isBlank() || lastName.isBlank()) {
                Toast.makeText(context, "Debes rellenar los 2 campos", Toast.LENGTH_SHORT).show()
            } else {
                listener?.onButtonClick(name, lastName)
            }
        }

        return view
    }

    fun setOnClickListener(listener: OnClickListener) {
        this.listener = listener
    }
}