package com.expensescalculator.Design

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.expensescalculator.Design.HomeScreenActivity
import com.expensescalculator.R

//import android.support.v7.app.ActionBarActivity;
class HomeScreenActivity : AppCompatActivity() {
    var btnAddIncome: Button? = null
    var AddExpense: Button? = null
    var btnHistory: Button? = null
    var btnReport: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        btnAddIncome = findViewById<View>(R.id.homescreen_btn_addincome) as Button
        AddExpense = findViewById<View>(R.id.homescreen_btn_addexpense) as Button
        btnHistory = findViewById<View>(R.id.homescreen_btn_history) as Button
        //        btnReport=(Button)findViewById(R.id.homescreen_btn_report);
        btnAddIncome!!.setOnClickListener {
            val intent = Intent(this@HomeScreenActivity, AddIncomeActivity::class.java)
            startActivity(intent)
        }
        AddExpense!!.setOnClickListener {
            val intent = Intent(this@HomeScreenActivity, AddExpenseActivity::class.java)
            startActivity(intent)
        }
        btnHistory!!.setOnClickListener {
            val intent = Intent(this@HomeScreenActivity, HistoryActivity::class.java)
            startActivity(intent)
        }

//        btnReport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeScreenActivity.this, ReportActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_home_screen, menu)
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