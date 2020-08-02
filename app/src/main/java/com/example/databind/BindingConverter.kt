


@file:JvmName("Converter")

package com.example.databind
import androidx.databinding.InverseMethod


class A (var name: String)

@InverseMethod("a2String")
fun string2a(string: String) : A{
    return A(string)
}

fun a2String(a : A) : String{
    return "${a.name}"
}