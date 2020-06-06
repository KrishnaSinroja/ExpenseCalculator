package com.expensescalculator.Design

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Spinner
import com.expensescalculator.Adapter.AdapterMonthSpinner
import com.expensescalculator.Bean.BeanMonth
import com.expensescalculator.DBhelper.DB_Month
import com.expensescalculator.R
import java.util.*

//import android.support.v7.app.ActionBarActivity;
class ReportActivity : AppCompatActivity() {
    var spMonth: Spinner? = null
    var arrayMonth: ArrayList<BeanMonth>? = null
    var dbm: DB_Month? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        spMonth = findViewById<View>(R.id.report_sp_month) as Spinner
        dbm = DB_Month(this)
        arrayMonth = dbm!!.selectAllMonth()
        spMonth!!.adapter = AdapterMonthSpinner(this, arrayMonth!!)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_report, menu)
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