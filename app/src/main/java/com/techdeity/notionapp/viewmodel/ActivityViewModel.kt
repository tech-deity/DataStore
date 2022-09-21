package com.techdeity.notionapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techdeity.notionapp.PhoneBook
import com.techdeity.notionapp.repository.ImplRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ActivityViewModel @Inject constructor(private  val implRepository: ImplRepository): ViewModel() {

    var phone : MutableLiveData<String> = MutableLiveData("")
    var address : MutableLiveData<String> = MutableLiveData("")
    var name : MutableLiveData<String> = MutableLiveData("")

    var phonebook :MutableLiveData<PhoneBook> = MutableLiveData()


    fun savaData(){
        viewModelScope.launch(Dispatchers.IO){
            implRepository.savePhoneBook(
                PhoneBook(
                    phoneNumber = phone.value!!,
                    address = address.value!!,
                    name =name.value!!

                )
            )
        }
    }

    fun retrieveData(){
        viewModelScope.launch(Dispatchers.IO){
            implRepository.getPhoneBook().collect{
                phonebook.postValue(it)
            }
        }

    }
}