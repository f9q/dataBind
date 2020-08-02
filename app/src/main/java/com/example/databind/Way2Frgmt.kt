package com.example.databind

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.databind.databinding.Way2Binding

class Way2Frgmt : Fragment(){
    val a = A("hello")
    val data = Data()
    lateinit var binding : Way2Binding
    val nameWatcher = object : TextWatcher{
        override fun afterTextChanged(p0: Editable?) {
            val txt = p0.toString()
            data.name = txt
            binding.invalidateAll()
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    fun initBinding(){
        binding.data = data
        binding.a = a
//        binding.normalEdt.addTextChangedListener(nameWatcher)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Way2Binding.inflate(layoutInflater,container,false)
        initBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}