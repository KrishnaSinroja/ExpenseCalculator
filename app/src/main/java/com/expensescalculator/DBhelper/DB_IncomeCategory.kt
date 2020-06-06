package com.expensescalculator.DBhelper

import android.content.Context
import com.expensescalculator.Bean.BeanIncomeCategory
import com.expensescalculator.Utility.Constant
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper
import java.util.*


class DB_IncomeCategory(context: Context?) : SQLiteAssetHelper(context, Constant.dbName, null, Constant.dbVersion) {
    fun selectAllIncCat(): ArrayList<BeanIncomeCategory> {
        val arrayIncCategory = ArrayList<BeanIncomeCategory>()
        val db = readableDatabase
        val query = "select * from EC_Inc_Category"
        val c = db.rawQuery(query, null)
        if (c.moveToFirst()) {
            do {
                val bic = BeanIncomeCategory()
                bic.incCatID = c.getInt(c.getColumnIndex("IncCatID"))
                bic.incCatName = c.getString(c.getColumnIndex("IncCatName"))
                arrayIncCategory.add(bic)
            } while (c.moveToNext())
        }
        db.close()
        return arrayIncCategory
    }

    fun selectById(incCatID: Int): String {
        val db = readableDatabase
        val query = "select IncCatName from EC_Inc_Category where IncCatID=$incCatID"
        val cursor = db.rawQuery(query, null)
        cursor.moveToFirst()
        var strCat = ""
        if (cursor.moveToFirst()) strCat = cursor.getString(cursor.getColumnIndex("IncCatName"))
        db.close()
        return strCat
    }
}