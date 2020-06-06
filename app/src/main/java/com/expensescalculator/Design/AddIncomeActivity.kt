package com.expensescalculator.Design

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.expensescalculator.Adapter.AdapterIncCategory
import com.expensescalculator.Bean.BeanExpense
import com.expensescalculator.Bean.BeanIncome
import com.expensescalculator.Bean.BeanIncomeCategory
import com.expensescalculator.DBhelper.DB_Expense
import com.expensescalculator.DBhelper.DB_Income
import com.expensescalculator.DBhelper.DB_IncomeCategory
import com.expensescalculator.Design.AddIncomeActivity
import com.expensescalculator.R
import java.text.SimpleDateFormat
import java.util.*

//import android.support.v7.app.ActionBarActivity;
class AddIncomeActivity : AppCompatActivity() {
    var edDate: EditText? = null
    var edIncome: EditText? = null
    var spCategory: Spinner? = null
    var edPayer: EditText? = null
    var edDiscription: EditText? = null
    var btnAdd: Button? = null
    var btnCancel: Button? = null
    private var birthDatePickerDialog: DatePickerDialog? = null
    private var dateFormatter: SimpleDateFormat? = null
    var dbi: DB_Income? = null
    var dbe: DB_Expense? = null
    var dbic: DB_IncomeCategory? = null
    var arrayIncCategory: ArrayList<BeanIncomeCategory>? = null
    var binc: BeanIncome? = null
    var be: BeanExpense? = null

    //    String catName;
    //    int strIncCat=1;
    var Syear: String? = null
    var Smonth: String? = null
    var Sday: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_income)
        dateFormatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)
        dbi = DB_Income(this)
        dbic = DB_IncomeCategory(this)
        binc = BeanIncome()
        be = BeanExpense()
        dbe = DB_Expense(this)
        edDate = findViewById<View>(R.id.addincome_ed_Date) as EditText
        edIncome = findViewById<View>(R.id.addincome_ed_Income) as EditText
        edDiscription = findViewById<View>(R.id.addincome_ed_Discription) as EditText
        spCategory = findViewById<View>(R.id.addincome_sp_Category) as Spinner
        edPayer = findViewById<View>(R.id.addincome_ed_payer) as EditText
        btnAdd = findViewById<View>(R.id.addincome_btn_add) as Button
        btnCancel = findViewById<View>(R.id.addincome_btn_Cancel) as Button
        arrayIncCategory = dbic!!.selectAllIncCat()
        spCategory!!.adapter = AdapterIncCategory(this, arrayIncCategory!!)
        setDateTimeField()
        edDate!!.setOnTouchListener { v, event ->
            birthDatePickerDialog!!.show()
            //setDateTimeField();
            false
        }
        edDate!!.setOnClickListener { }
        btnAdd!!.setOnClickListener {
            val bi = BeanIncome()
            var flag = 0
            if (edDate!!.text.length > 0) {
                bi.incDate = edDate!!.text.toString()
                bi.incDay = Sday
                bi.incYear = Syear
                val MonthName = Smonth?.let { it1 -> dbi!!.getMonthName(it1) }
                bi.incMonth = MonthName
            } else {
                flag = 1
                edDate!!.error = "Select Date"
            }
            if (edIncome!!.text.length > 0) {
                bi.incIncome = edIncome!!.text.toString()
            } else {
                flag = 1
                edIncome!!.error = "Enter Income"
            }
            bi.incCatID = spCategory!!.selectedItemPosition + 1
            if (edPayer!!.text.length > 0) {
                bi.incPayer = edPayer!!.text.toString()
            }
            if (edDiscription!!.text.length > 0) {
                bi.incDiscription = edDiscription!!.text.toString()
            }
            if (flag == 0) {
                dbi!!.insertIncome(bi)
                Toast.makeText(applicationContext, "Income Inserted", Toast.LENGTH_LONG).show()
                Toast.makeText(applicationContext, "Data" + bi.incCategory + bi.incDate + bi.incIncome + bi.incDiscription + bi.incPayer, Toast.LENGTH_LONG).show()
                clearData()
                //Toast.makeText(getApplicationContext(),bi.getIncDate()+"==="+bi.getIncIncome(),Toast.LENGTH_LONG).show();
            }
        }
        btnCancel!!.setOnClickListener {
            clearData()
            val intent = Intent(this@AddIncomeActivity, HomeScreenActivity::class.java)
            startActivity(intent)
        }
    }

    fun clearData() {
        edDate!!.setText("")
        edIncome!!.setText("")
        edDiscription!!.setText("")
        spCategory!!.setSelection(0)
        edPayer!!.setText("")
    }

    private fun setDateTimeField() {
        val newCalendar = Calendar.getInstance()
        birthDatePickerDialog = DatePickerDialog(this, OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            val newDate = Calendar.getInstance()
            newDate[year, monthOfYear] = dayOfMonth
            Syear = year.toString()
            Smonth = (monthOfYear + 1).toString()
            Sday = dayOfMonth.toString()
            edDate!!.setText(dateFormatter!!.format(newDate.time))
        }, newCalendar[Calendar.YEAR], newCalendar[Calendar.MONTH], newCalendar[Calendar.DAY_OF_MONTH])
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_add_income, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}