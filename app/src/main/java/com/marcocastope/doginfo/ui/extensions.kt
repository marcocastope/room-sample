package com.marcocastope.doginfo.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.os.bundleOf

fun Context.toast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, length).show()
}

inline fun <reified T : Activity> Context.startActivity(vararg pairs: Pair<String, Any?>) {
    Intent(this, T::class.java).apply {
        putExtras(bundleOf(*pairs))
        startActivity(this)
    }
}
