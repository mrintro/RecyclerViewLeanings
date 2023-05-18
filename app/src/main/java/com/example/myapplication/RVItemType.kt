package com.example.myapplication

interface RVItemType {
    fun getItemType() : Int
}

class FirstItem(
    val text: String
) : RVItemType {
    override fun getItemType(): Int = 1
}

class SecondItem(
    val text: String
) : RVItemType {
    override fun getItemType(): Int = 2
}
