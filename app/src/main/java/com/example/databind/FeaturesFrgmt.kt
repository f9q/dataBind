package com.example.databind

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.databind.databinding.FeaturesBinding

class FeaturesFrgmt : Fragment(){

    lateinit var binding : FeaturesBinding

    fun initBinding(){
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FeaturesBinding.inflate(inflater,container,false)
        initBinding()
        return binding.root
    }

}