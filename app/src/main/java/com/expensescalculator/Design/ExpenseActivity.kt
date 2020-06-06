package com.expensescalculator.Design

import android.support.v7.app.AppCompatActivity

//import android.support.v7.app.ActionBarActivity;
class ExpenseActivity : AppCompatActivity() { //
    //    ExpandableListAdapter listAdapter;
    //    ExpandableListView expListView;
    //    List<String> listDataHeader;
    //    HashMap<String, List<String>> listDataChild;
    //    DB_Expense dbe;
    //    ArrayList<BeanExpense> ChildData;
    //
    //
    //    @Override
    //    protected void onCreate(Bundle savedInstanceState) {
    //        super.onCreate(savedInstanceState);
    //        setContentView(R.layout.activity_expense);
    //
    //        // get the listview
    //        expListView = (ExpandableListView) findViewById(R.id.lvExp);
    //
    //        // preparing list data
    //        //prepareListData();
    //
    //
    //        dbe=new DB_Expense(this);
    //        ChildData=new ArrayList<BeanExpense>();
    //
    //        listDataHeader = new ArrayList<String>();
    //        listDataChild = new HashMap<String, List<String>>();
    //
    //        // Adding child data
    //        listDataHeader.add("Top 250");
    //        listDataHeader.add("Now Showing");
    //        listDataHeader.add("Coming Soon..");
    //
    //        // Adding child data
    //
    //        //ChildData=dbe.selectAllIExpense();
    //        //listDataChild.get(ChildData);
    //
    //        List<String> top250 = new ArrayList<String>();
    //        top250.add(ChildData.toString());
    //
    //        List<String> nowShowing = new ArrayList<String>();
    //        nowShowing.add(listDataChild.toString());
    //
    //        List<String> comingSoon = new ArrayList<String>();
    //        comingSoon.add(listDataChild.toString());
    //
    //        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
    //        listDataChild.put(listDataHeader.get(1), nowShowing);
    //        listDataChild.put(listDataHeader.get(2), comingSoon);
    //
    //        listAdapter = new AdapterExpandableExp(this, listDataHeader, listDataChild);
    //
    //        // setting list adapter
    //        expListView.setAdapter(listAdapter);
    //    }
    //
    //    /*
    //     * Preparing the list data
    //     */
    //    /*private void prepareListData() {
    //        listDataHeader = new ArrayList<String>();
    //        listDataChild = new HashMap<String, List<String>>();
    //
    //        // Adding child data
    //        listDataHeader.add("Top 250");
    //        listDataHeader.add("Now Showing");
    //        listDataHeader.add("Coming Soon..");
    //
    //        // Adding child data
    //
    //        ChildData=dbe.selectAllIExpense();
    //        listDataChild.get(ChildData);
    //
    //        List<String> top250 = new ArrayList<String>();
    //        top250.add(listDataChild.toString());
    //        /*top250.add("The Shawshank Redemption");
    //        top250.add("The Godfather");
    //        top250.add("The Godfather: Part II");
    //        top250.add("Pulp Fiction");
    //        top250.add("The Good, the Bad and the Ugly");
    //        top250.add("The Dark Knight");
    //        top250.add("12 Angry Men");*/
    //
    //        /*List<String> nowShowing = new ArrayList<String>();
    //        nowShowing.add(listDataChild.toString());
    //        /*nowShowing.add("The Conjuring");
    //        nowShowing.add("Despicable Me 2");
    //        nowShowing.add("Turbo");
    //        nowShowing.add("Grown Ups 2");
    //        nowShowing.add("Red 2");
    //        nowShowing.add("The Wolverine");*/
    //
    //        /*List<String> comingSoon = new ArrayList<String>();
    //        comingSoon.add(listDataChild.toString());
    //
    //        /*comingSoon.add("2 Guns");
    //        comingSoon.add("The Smurfs 2");
    //        comingSoon.add("The Spectacular Now");
    //        comingSoon.add("The Canyons");
    //        comingSoon.add("Europa Report");*/
    //
    //        /*listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
    //        listDataChild.put(listDataHeader.get(1), nowShowing);
    //        listDataChild.put(listDataHeader.get(2), comingSoon);
    //    }*/
    //
    //
    //    @Override
    //    public boolean onCreateOptionsMenu(Menu menu) {
    //        // Inflate the menu; this adds items to the action bar if it is present.
    //        getMenuInflater().inflate(R.menu.menu_expense, menu);
    //        return true;
    //    }
    //
    //    @Override
    //    public boolean onOptionsItemSelected(MenuItem item) {
    //        // Handle action bar item clicks here. The action bar will
    //        // automatically handle clicks on the Home/Up button, so long
    //        // as you specify a parent activity in AndroidManifest.xml.
    //        int id = item.getItemId();
    //
    //        //noinspection SimplifiableIfStatement
    //        if (id == R.id.action_settings) {
    //            return true;
    //        }
    //
    //        return super.onOptionsItemSelected(item);
    //    }
}