package com.neoranga55.kontacts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import org.jetbrains.anko.async
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import kotlinx.android.synthetic.activity_main.*
import org.jetbrains.anko.ctx

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = GridLayoutManager(ctx, 2)

        // Anko asynchronous
        async {
            val contacts = RetrieveContacts().execute()
            uiThread {
                recycler.adapter = ContactsAdapter(contacts)
            }
        }
    }
}
