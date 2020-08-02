

@file:JvmName("BindAdapter")

package com.example.databind
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.databinding.*
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("background")
fun setBackground(v : View,res : Int){
    v.setBackgroundResource(R.color.colorAccent)
}

@BindingAdapter("dataName")
fun setDataName(edt : EditText, txt : String){
    edt.setText(txt)
}

@InverseBindingAdapter(attribute = "dataName")
fun getDataName(edt : EditText) : String{
    return edt.text.toString()
}
@BindingAdapter("dataNameAttrChanged")
fun setListener(edit : EditText, listener: InverseBindingListener?) {
    Log.e("dataNameAttrChanged","txt = ${edit.text.toString()}")
    var txt = ""
    edit.addTextChangedListener(object : TextWatcher{
        override fun afterTextChanged(p0: Editable?) {
            Log.e("dataNameAttrChanged","afterTextChanged")
            if (txt != p0.toString()){
                listener?.onChange()
                txt = p0.toString()
                if (txt.length > 0)
                edit.setSelection(txt.length - 1)
            }
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    })
}

@BindingAdapter("android:paddingLeft",requireAll = false)
fun setPaddingLeft(view: View, oldPadding: Int, newPadding: Int) {
    if (oldPadding != newPadding) {
        view.setPadding(16,
                view.getPaddingTop(),
                view.getPaddingRight(),
                view.getPaddingBottom())
    }
}

@BindingAdapter(value = ["imageUrl", "error"], requireAll = false)
fun loadImage(view: ImageView, url: String, error: Drawable) {
    Picasso.get().load(url).error(error).into(view)
}

@BindingConversion
fun convertStringToData(name : String) = Data()

@JvmField val COUNT = 1