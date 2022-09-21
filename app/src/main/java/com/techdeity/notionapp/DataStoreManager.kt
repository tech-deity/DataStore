package com.techdeity.notionapp

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class DataStoreManager(val context: Context) {
    //we need to create data store object using a delegate
    private val Context.dataStore:DataStore<Preferences> by preferencesDataStore(name = "USER_DATASTORE")

// we define the key that is required by us as the data saved in key value pair

    companion object{
        val NAME = stringPreferencesKey("NAME")

        val PHONE_NUMBER = stringPreferencesKey("PHONE_NUMBER")
        val ADDRESS = stringPreferencesKey("ADDRESS")
    }

    suspend fun saveToDataStore(phonebook: PhoneBook) {
        context.dataStore.edit {

            it[NAME] = phonebook.name
            it[PHONE_NUMBER] = phonebook.phoneNumber
            it[ADDRESS] = phonebook.address

        }
    }

    suspend fun getFromDataStore() = context.dataStore.data.map {
        PhoneBook(
            name=it[NAME]?:"",
            phoneNumber = it[PHONE_NUMBER]?:"",
            address = it[ADDRESS]?:""

        )
    }
}