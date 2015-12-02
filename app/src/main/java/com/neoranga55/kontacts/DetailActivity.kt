package com.neoranga55.kontacts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.activity_detail.*
import org.jetbrains.anko.image

class DetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_NAME = "extraName"
        val EXTRA_IMAGE = "extraImage"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra(EXTRA_NAME)
        supportActionBar.title = name
        contactText.text = name
        contactImage.loadUrl(intent.getStringExtra(EXTRA_IMAGE))
    }
}

