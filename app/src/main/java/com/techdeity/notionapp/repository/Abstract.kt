package com.techdeity.notionapp.repository

import com.techdeity.notionapp.PhoneBook
import kotlinx.coroutines.flow.Flow

interface Abstract {

    suspend fun savePhoneBook(phoneBook: PhoneBook)
    suspend fun getPhoneBook(): Flow<PhoneBook>
}