package com.neoranga55.kontacts

import android.content.Context
import android.provider.ContactsContract
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.parseList

class RetrieveContacts {

    private class RawContact(val name: String?, val imageUrl: String?)

    fun execute(ctx: Context): List<Contact> {
//        Fake contacts with images
//        return (1..10).map { Contact("Contact $it", "http://lorempixel.com/400/400/people/$it") }
        val contacts = ctx.contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)
        val parsedContact = contacts.parseList(object : MapRowParser<RawContact> {
            override fun parseRow(columns: Map<String, Any>): RawContact {
                return RawContact(columns[ContactsContract.Contacts.DISPLAY_NAME] as? String,
                        columns[ContactsContract.Contacts.PHOTO_URI] as? String)
            }
        })
        return parsedContact // Transform from a list of RawContacts to a a list of Contacts
                .filter { it.name != null && it.imageUrl != null }
                .sortedBy { it.name }
                .map { Contact(it.name!!, it.imageUrl!!) }
    }
}