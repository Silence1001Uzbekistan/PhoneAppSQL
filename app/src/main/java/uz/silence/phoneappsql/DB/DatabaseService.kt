package uz.silence.phoneappsql.DB

import uz.silence.phoneappsql.CLASS.Phone


interface DatabaseService {

    fun addPhone(phone: Phone)
    fun getPhoneById(id: Int): Phone
    fun getAllPhone(): List<Phone>

}