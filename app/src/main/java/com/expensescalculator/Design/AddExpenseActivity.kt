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
import com.expensescalculator.Adapter.AdapterExpCategory
import com.expensescalculator.Bean.BeanExpense
import com.expensescalculator.Bean.BeanExpenseCategory
import com.expensescalculator.DBhelper.DB_Expense
import com.expensescalculator.DBhelper.DB_ExpenseCategory
import com.expensescalculator.R
import java.text.SimpleDateFormat
import java.util.*

//import android.support.v7.app.ActionBarActivity;
class AddExpenseActivity : AppCompatActivity() {
    var edDate: EditText? = null
    var edExpense: EditText? = null
    var spExpCategory: Spinner? = null
    var edPayee: EditText? = null
    var edDiscription: EditText? = null
    var btnAdd: Button? = null
    var btnCancel: Button? = null
    private var birthDatePickerDialog: DatePickerDialog? = null
    private var dateFormatter: SimpleDateFormat? = null
    var dbe: DB_Expense? = null
    var dbec: DB_ExpenseCategory? = null
    var arrayExpCategory: ArrayList<BeanExpenseCategory>? = null
    var bec: BeanExpenseCategory? = null

    //    String expCat;
    var strExpCat = 1
    var Syear: String? = null
    var Smonth: String? = null
    var Sday: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)
        dateFormatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)
        dbe = DB_Expense(this)
        dbec = DB_ExpenseCategory(this)
        bec = BeanExpenseCategory()
        edDate = findViewById<View>(R.id.addexpense_ed_date) as EditText
        edExpense = findViewById<View>(R.id.addexpense_ed_expense) as EditText
        edDiscription = findViewById<View>(R.id.addexpense_ed_discription) as EditText
        spExpCategory = findViewById<View>(R.id.addexpense_sp_Category) as Spinner
        edPayee = findViewById<View>(R.id.addexpense_ed_payee) as EditText
        btnAdd = findViewById<View>(R.id.addexpense_btn_add) as Button
        btnCancel = findViewById<View>(R.id.addexpense_btn_cancel) as Button
        setDateTimeField()
        arrayExpCategory = dbec!!.selectAllExpCat()
        spExpCategory!!.adapter = AdapterExpCategory(this, arrayExpCategory!!)
        edDate!!.setOnTouchListener { v, event ->
            birthDatePickerDialog!!.show()
            //setDateTimeField();
            false
        }

        /*spExpCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tvid = ((TextView) view.findViewById(R.id.sp_expcat_tv_id));
                strExpCat = Integer.parseInt(tvid.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/edDate!!.setOnClickListener { }
        btnAdd!!.setOnClickListener {
            val be = BeanExpense()
            var flag = 0
            be.expCatID = spExpCategory!!.selectedItemPosition + 1
            if (edDate!!.text.length > 0) {
                be.expDate = edDate!!.text.toString()
                be.expDay = Sday
                be.expYear = Syear
                val MonthName = dbe!!.getMonthName(Smonth)
                be.expMonth = MonthName
            } else {
                flag = 1
                edDate!!.error = "Select Date"
            }
            if (edExpense!!.text.length > 0) {
                be.expExpense = edExpense!!.text.toString()
            } else {
                flag = 1
                edExpense!!.error = "Enter Expense"
            }
            be.expCategory = spExpCategory!!.selectedItem.toString()
            if (edPayee!!.text.length > 0) {
                be.expPayee = edPayee!!.text.toString()
            } else {
                flag = 1
                edPayee!!.error = "Enter Payee Details"
            }
            if (edDiscription!!.text.length > 0) {
                be.expDiscription = edDiscription!!.text.toString()
            }
            //  be.setExpID(4);
            if (flag == 0) {
                dbe!!.insertExpense(be)
                //Intent intent1=new Intent(AddExpenseActivity.this,Expense.class);
                Toast.makeText(applicationContext, be.expCatID.toString() + " Expense Inserted", Toast.LENGTH_LONG).show()
                //Toast.makeText(getApplicationContext(), be.getExpDate() + "===" + be.getExpExpense()+"==="+be.getExpCatID(), Toast.LENGTH_LONG).show();
                clearData()
            }
        }
        btnCancel!!.setOnClickListener {
            clearData()
            val intent = Intent(this@AddExpenseActivity, HomeScreenActivity::class.java)
            startActivity(intent)
        }
    }

    fun clearData() {
        edDate!!.setText("")
        edExpense!!.setText("")
        edDiscription!!.setText("")
        spExpCategory!!.setSelection(0)
        edPayee!!.setText("")
    }

    private fun setDateTimeField() {
        val month: String
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
        menuInflater.inflate(R.menu.menu_add_expense, menu)
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