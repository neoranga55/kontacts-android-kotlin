package com.neoranga55.kontacts

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.view_item.view.*

class ContactsAdapter(val contacts: List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.view_item))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount() = contacts.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(contact: Contact) = with(itemView) {
            contactText.text = contact.name
            Picasso.with(context).load(contact.imageUrl).into(contactImage)
        }
    }
}
