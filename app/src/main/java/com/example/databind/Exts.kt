package com.example.databind

import android.text.Editable
import android.widget.EditText

object Exts {
    @JvmStatic
    fun Editable.hasCharX(char: Char) : Boolean{
        val txt = toString()
        return txt.contains(char)
    }
    @JvmStatic
    fun String.hasCharX(char: Char) : Boolean{
        return contains(char)
    }
}

fun Editable.hasCharX(char: Char) : Boolean{
    val txt = toString()
    return txt.contains(char)
}
fun String.hasCharX(char: Char) : Boolean{
    return contains(char)
}

fun EditText.hasCharX(char: Char) : Boolean{
    val txt = toString()
    return txt.contains(char)
}
