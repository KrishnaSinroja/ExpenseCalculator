package com.expensescalculator.DBhelper

import android.content.Context
import com.expensescalculator.Bean.BeanMonth
import com.expensescalculator.Utility.Constant
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper
import java.util.*


class DB_Month(context: Context?) : SQLiteAssetHelper(context, Constant.dbName, null, Constant.dbVersion) {
    fun selectAllMonth(): ArrayList<BeanMonth> {
        val arrayMonth = ArrayList<BeanMonth>()
        val db = readableDatabase
        val query = "select * from EC_Month"
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val bm = BeanMonth()
                bm.monthID = cursor.getInt(cursor.getColumnIndex("ExpMonthID"))
                bm.monthName = cursor.getString(cursor.getColumnIndex("ExpMonthName"))
                arrayMonth.add(bm)
            } while (cursor.moveToNext())
        }
        db.close()
        return arrayMonth
    }

    fun selectById(expMonthID: String): String {
        val db = readableDatabase
        val query = "select ExpMonthName from EC_Month where ExpMonthID=" + expMonthID.toInt()
        val cursor = db.rawQuery(query, null)
        cursor.moveToFirst()
        var stMonthName = ""
        if (cursor.moveToFirst()) stMonthName = cursor.getString(cursor.getColumnIndex("ExpMonthName"))
        db.close()
        return stMonthName
    }
}