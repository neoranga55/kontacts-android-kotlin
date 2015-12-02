package com.neoranga55.kontacts

class RetrieveContacts {
    fun execute(): List<Contact> {
        return (1..10).map { Contact("Contact $it", "http://lorempixel.com/400/400/people/$it") }
    }
}