package uz.silence.phoneappsql.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import uz.silence.phoneappsql.CLASS.Phone
import uz.silence.phoneappsql.CONSTANT.Constant

class MyDbHelper(context: Context) :
    SQLiteOpenHelper(context, Constant.DB_NAME, null, Constant.DB_VERSION), DatabaseService {
    override fun onCreate(p0: SQLiteDatabase?) {
        val query =
            "create table ${Constant.TABLE_NAME} (${Constant.ID} integer not null primary key autoincrement unique,${Constant.TYPE} integer not null,${Constant.NAME} Text not null,${Constant.INFO} Text not null)"

        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists ${Constant.TABLE_NAME}")
        onCreate(p0)
    }

    override fun addPhone(phone: Phone) {
        val database = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(Constant.TYPE, phone.type)
        contentValues.put(Constant.NAME, phone.name)
        contentValues.put(Constant.INFO, phone.info)

        database.insert(Constant.TABLE_NAME, null, contentValues)
        database.close()

    }

    override fun getPhoneById(id: Int): Phone {

        val database = this.readableDatabase


        val cursor = database.query(
            Constant.TABLE_NAME,
            arrayOf(Constant.ID, Constant.TYPE, Constant.NAME, Constant.INFO),
            "${Constant.ID} = ?",
            arrayOf(id.toString()),
            null, null, null
        )

        cursor?.moveToFirst()


        return Phone(
            cursor.getInt(0),
            cursor.getInt(1),
            cursor.getString(2),
            cursor.getString(3)
        )

    }

    override fun getAllPhone(): ArrayList<Phone> {
        val list = ArrayList<Phone>()
        var query = "select * from ${Constant.TABLE_NAME}"

        val database = this.readableDatabase

        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {

                val id = cursor.getInt(0)
                val type = cursor.getInt(1)
                val name = cursor.getString(2)
                val info = cursor.getString(3)

                val phone = Phone(id, type, name, info)
                list.add(phone)


            } while (cursor.moveToNext())
        }

        return list

    }
}