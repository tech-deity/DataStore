package com.techdeity.notionapp.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.techdeity.notionapp.PhoneBook
import kotlinx.coroutines.flow.map

const val DataStore_NAME = "PHONEBOOK"

val Context.datastore : DataStore< Preferences> by  preferencesDataStore(name = DataStore_NAME)


class ImplRepository(private val context: Context) : Abstract {

    companion object{
        val NAME = stringPreferencesKey("NAME")
        val PHONE_NUMBER = stringPreferencesKey("PHONE")
        val address = stringPreferencesKey("ADDRESS")
    }

    override suspend fun savePhoneBook(phonebook: PhoneBook) {
        context.datastore.edit { phonebooks->
            phonebooks[NAME] = phonebook.name
            phonebooks[PHONE_NUMBER]= phonebook.phoneNumber
            phonebooks[address]= phonebook.address

        }

    }

    override suspend fun getPhoneBook() = context.datastore.data.map { phonebook ->
        PhoneBook(
            name = phonebook[NAME]!!,
            address =  phonebook[address]!!,
            phoneNumber = phonebook[PHONE_NUMBER]!!
        )
    }
}