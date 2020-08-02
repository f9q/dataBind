package com.example.databind;

import android.widget.EditText;
import android.widget.ImageView;

import androidx.databinding.InverseBindingAdapter;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter({"bindingImgSrc"})
    public static void setImage(ImageView view, int icon){
        view.setImageResource(icon);
    }


}
