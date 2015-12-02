package com.neoranga55.kontacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(layoutRes: Int, attachToRoot: Boolean = false): View {
    LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}