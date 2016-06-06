package com.example.user.wase.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.wase.R;
import com.example.user.wase.model.MyHereAgent;
import com.example.user.wase.model.MyInformation;
import com.example.user.wase.model.MyRecord;
import com.example.user.wase.model.MyRoutine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymbaek on 2016-04-18.
 */
public class DatabaseTestActivity extends AppCompatActivity {

    public static final String TAG = "DatabaseTestActivity";
    public static final String TAG_DB = "DatabaseTestDBTag";

    /* MyInformation */
    EditText dbtest_et_myinfo_id;
    EditText dbtest_et_myinfo_nick;
    EditText dbtest_et_myinfo_name;
    EditText dbtest_et_myinfo_age;
    EditText dbtest_et_myinfo_sex;
    EditText dbtest_et_myinfo_height;
    EditText dbtest_et_myinfo_weight;
    EditText dbtest_et_myinfo_registered;
    EditText dbtest_et_myinfo_deviceid;

    Button dbtest_btn_myinfo_add;

    TextView dbtest_tv_myinfo_table;

    /* MyHereAgent */
    EditText dbtest_et_myeq_id;
    EditText dbtest_et_myeq_name;
    EditText dbtest_et_myeq_type;
    EditText dbtest_et_myeq_majorid;
    EditText dbtest_et_myeq_minorid;

    Button dbtest_btn_myeq_add;

    TextView dbtest_tv_myeq_table;

    /* MyRoutine */
    EditText dbtest_et_myroutine_id;
    EditText dbtest_et_myroutine_name;
    EditText dbtest_et_myroutine_eq1_id;
    EditText dbtest_et_myroutine_eq1_goal;
    EditText dbtest_et_myroutine_eq2_id;
    EditText dbtest_et_myroutine_eq2_goal;
    EditText dbtest_et_myroutine_eq3_id;
    EditText dbtest_et_myroutine_eq3_goal;
    EditText dbtest_et_myroutine_eq4_id;
    EditText dbtest_et_myroutine_eq4_goal;
    EditText dbtest_et_myroutine_eq5_id;
    EditText dbtest_et_myroutine_eq5_goal;

    Button dbtest_btn_myroutine_add;
    TextView dbtest_tv_myroutine_table;

    /* MyRecord */
    EditText dbtest_et_myrecord_id;
    EditText dbtest_et_myrecord_name;
    EditText dbtest_et_myrecord_eq1_id;
    EditText dbtest_et_myrecord_eq1_done;
    EditText dbtest_et_myrecord_eq2_id;
    EditText dbtest_et_myrecord_eq2_done;
    EditText dbtest_et_myrecord_eq3_id;
    EditText dbtest_et_myrecord_eq3_done;
    EditText dbtest_et_myrecord_eq4_id;
    EditText dbtest_et_myrecord_eq4_done;
    EditText dbtest_et_myrecord_eq5_id;
    EditText dbtest_et_myrecord_eq5_done;

    Button dbtest_btn_myrecord_add;
    TextView dbtest_tv_myrecord_table;

    //Toolbar
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Database Test");
        toolbar.setNavigationIcon(R.mipmap.ic_menu_arrow_back);
        toolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Database Test");
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);

        initWidgets();

        printMyInfoTable();
        printMyHereAgentTable();

//        //Database tests
//        dbTestCountEntries();
//
//        dbTestInsertAgent();
//        dbTestInsertRoutine();
//        dbTestInsertRecord();
    }


    private void initWidgets() {
        /* MyInformation */
        dbtest_et_myinfo_id = (EditText) findViewById(R.id.dbtest_edit_myinfo_id);
        dbtest_et_myinfo_nick = (EditText) findViewById(R.id.dbtest_edit_myinfo_nick);
        dbtest_et_myinfo_name = (EditText) findViewById(R.id.dbtest_edit_myinfo_name);
        dbtest_et_myinfo_age = (EditText) findViewById(R.id.dbtest_edit_myinfo_age);
        dbtest_et_myinfo_sex = (EditText) findViewById(R.id.dbtest_edit_myinfo_sex);
        dbtest_et_myinfo_height = (EditText) findViewById(R.id.dbtest_edit_myinfo_height);
        dbtest_et_myinfo_weight = (EditText) findViewById(R.id.dbtest_edit_myinfo_weight);
        dbtest_et_myinfo_registered = (EditText) findViewById(R.id.dbtest_edit_myinfo_registered);
        dbtest_et_myinfo_deviceid = (EditText) findViewById(R.id.dbtest_edit_myinfo_deviceid);

        dbtest_btn_myinfo_add = (Button) findViewById(R.id.dbtest_btn_myinfo_add);

        dbtest_tv_myinfo_table = (TextView) findViewById(R.id.dbtest_tv_table_myinfo);

        /* MyHereAgent */
        dbtest_et_myeq_id = (EditText) findViewById(R.id.dbtest_edit_myeq_macid);
        dbtest_et_myeq_name = (EditText) findViewById(R.id.dbtest_edit_myeq_name);
        dbtest_et_myeq_type = (EditText) findViewById(R.id.dbtest_edit_myeq_type);
        dbtest_et_myeq_majorid = (EditText) findViewById(R.id.dbtest_edit_myeq_majorid);
        dbtest_et_myeq_minorid = (EditText) findViewById(R.id.dbtest_edit_myeq_minorid);

        dbtest_btn_myeq_add = (Button) findViewById(R.id.dbtest_btn_myeq_add);

        dbtest_tv_myeq_table = (TextView) findViewById(R.id.dbtest_tv_table_myhereagents);

        /* MyRoutine */
        dbtest_et_myroutine_id = (EditText) findViewById(R.id.dbtest_edit_myroutine_id);
        dbtest_et_myroutine_name = (EditText) findViewById(R.id.dbtest_edit_myroutine_name);
        dbtest_et_myroutine_eq1_id = (EditText) findViewById(R.id.dbtest_edit_myroutine_eq1_id);
        dbtest_et_myroutine_eq1_goal = (EditText) findViewById(R.id.dbtest_edit_myroutine_eq1_goal);
        dbtest_et_myroutine_eq2_id = (EditText) findViewById(R.id.dbtest_edit_myroutine_eq2_id);
        dbtest_et_myroutine_eq2_goal = (EditText) findViewById(R.id.dbtest_edit_myroutine_eq2_goal);
        dbtest_et_myroutine_eq3_id = (EditText) findViewById(R.id.dbtest_edit_myroutine_eq3_id);
        dbtest_et_myroutine_eq3_goal = (EditText) findViewById(R.id.dbtest_edit_myroutine_eq3_goal);
        dbtest_et_myroutine_eq4_id = (EditText) findViewById(R.id.dbtest_edit_myroutine_eq4_id);
        dbtest_et_myroutine_eq4_goal = (EditText) findViewById(R.id.dbtest_edit_myroutine_eq4_goal);
        dbtest_et_myroutine_eq5_id = (EditText) findViewById(R.id.dbtest_edit_myroutine_eq5_id);
        dbtest_et_myroutine_eq5_goal = (EditText) findViewById(R.id.dbtest_edit_myroutine_eq5_goal);

        dbtest_btn_myroutine_add = (Button) findViewById(R.id.dbtest_btn_myroutine_add);
        dbtest_tv_myroutine_table = (TextView) findViewById(R.id.dbtest_tv_table_myroutines);

        /* MyRecord */
        dbtest_et_myrecord_id = (EditText) findViewById(R.id.dbtest_edit_myrecord_id);
        dbtest_et_myrecord_name = (EditText) findViewById(R.id.dbtest_edit_myrecord_name);
        dbtest_et_myrecord_eq1_id = (EditText) findViewById(R.id.dbtest_edit_myrecord_eq1_id);
        dbtest_et_myrecord_eq1_done = (EditText) findViewById(R.id.dbtest_edit_myrecord_eq1_done);
        dbtest_et_myrecord_eq2_id = (EditText) findViewById(R.id.dbtest_edit_myrecord_eq2_id);
        dbtest_et_myrecord_eq2_done = (EditText) findViewById(R.id.dbtest_edit_myrecord_eq2_done);
        dbtest_et_myrecord_eq3_id = (EditText) findViewById(R.id.dbtest_edit_myrecord_eq3_id);
        dbtest_et_myrecord_eq3_done = (EditText) findViewById(R.id.dbtest_edit_myrecord_eq3_done);
        dbtest_et_myrecord_eq4_id = (EditText) findViewById(R.id.dbtest_edit_myrecord_eq4_id);
        dbtest_et_myrecord_eq4_done = (EditText) findViewById(R.id.dbtest_edit_myrecord_eq4_done);
        dbtest_et_myrecord_eq5_id = (EditText) findViewById(R.id.dbtest_edit_myrecord_eq5_id);
        dbtest_et_myrecord_eq5_done = (EditText) findViewById(R.id.dbtest_edit_myrecord_eq5_done);

        dbtest_btn_myrecord_add = (Button) findViewById(R.id.dbtest_btn_myrecord_add);
        dbtest_tv_myrecord_table = (TextView) findViewById(R.id.dbtest_tv_table_myrecords);
    }


    private int dbTestCountAgent() {
        return MainActivity.hereDB.getMyHereAgentCount();
    }


//    /**
//     * [Database test] Count currently stored entries
//     */
//    private void dbTestCountEntries() {
//        int agentCount = MainActivity.hereDB.getMyHereAgentCount();
//        int routineCount = MainActivity.hereDB.getMyRoutineCount();
//        int recordCount = MainActivity.hereDB.getMyRecordCount();
//
//        Log.d(TAG_DB, "[Database] agentCount = " + agentCount);
//        Log.d(TAG_DB, "[Database] routineCount = " + routineCount);
//        Log.d(TAG_DB, "[Database] recordCount = " + recordCount);
//    }
//
//    /**
//     * [Database test] Insert sample entries to the table
//     */
//    private void dbTestInsertAgent() {
//        MyHereAgent agent1 = new MyHereAgent();
//        MyHereAgent agent2 = new MyHereAgent();
//        agent1.setMyeqMacId("ABC");
//        agent2.setMyeqMacId("DEF");
//
//        dbTestCountEntries();
//
//        MainActivity.hereDB.insertHereAgent(agent1);
//        MainActivity.hereDB.insertHereAgent(agent2);
//
//        dbTestCountEntries();
//    }
//
//    /**
//     * [Database test] Insert sample routines to the table
//     */
//    private void dbTestInsertRoutine() {
//        MyRoutine routine1 = new MyRoutine();
//        MyRoutine routine2 = new MyRoutine();
//        routine1.setRoutineId("ABC");
//        routine2.setRoutineId("DEF");
//
//        dbTestCountEntries();
//
//        MainActivity.hereDB.insertRoutine(routine1);
//        MainActivity.hereDB.insertRoutine(routine2);
//
//        dbTestCountEntries();
//
//    }
//
//    /**
//     * [Database test] Insert sample records to the table
//     */
//    private void dbTestInsertRecord() {
//        MyRecord record1 = new MyRecord();
//        MyRecord record2 = new MyRecord();
//        record1.setRecordId("ABC");
//        record2.setRecordId("DEF");
//
//        dbTestCountEntries();
//
//        MainActivity.hereDB.insertRecord(record1);
//        MainActivity.hereDB.insertRecord(record2);
//
//        dbTestCountEntries();
//    }

//    private void dbTestMyEquipments() {
//        MyHereAgent agent1 = new MyHereAgent();
//
//        MainActivity.hereDB.insertHereAgent()
//    }

    private void printMyInfoTable() {
        MyInformation myinfo = MainActivity.hereDB.getMyInformation();

        if (myinfo != null) {
            dbtest_tv_myinfo_table.setText(
                    "- id: " + myinfo.getUserId() + "\n" +
                            "- nick: " + myinfo.getUserNick() + "\n" +
                            "- name: " + myinfo.getUserName() + "\n" +
                            "- age: " + myinfo.getUserAge() + "\n" +
                            "- sex: " + myinfo.getUserSex() + "\n" +
                            "- height: " + myinfo.getUserHeight() + "\n" +
                            "- weight: " + myinfo.getUserWeight() + "\n" +
                            "- registered: " + myinfo.getUserRegistered() + "\n" +
                            "- deviceid: " + myinfo.getUserDeviceId()
            );
        } else {
            dbtest_tv_myinfo_table.setText("NO RECORDS");
        }

    }

    private void printMyHereAgentTable() {
        List<MyHereAgent> myAgents = new ArrayList<>();
        myAgents = MainActivity.hereDB.getAllMyHereAgents();

        if (myAgents != null) {
            String myAgentsString = "";

            for (int i = 0; i < myAgents.size(); i++) {
                myAgentsString += "- mac id: " + myAgents.get(i).getMyeqMacId() + "\n";
                myAgentsString += "- name: " + myAgents.get(i).getMyeqName() + "\n";
                myAgentsString += "- type: " + myAgents.get(i).getMyeqType() + "\n";
                myAgentsString += "- major id: " + myAgents.get(i).getMyeqBeaconMajorId() + "\n";
                myAgentsString += "- minor id: " + myAgents.get(i).getMyeqBeaconMinorId() + "\n\n";
            }
            dbtest_tv_myeq_table.setText(myAgentsString);
        } else {
            dbtest_tv_myeq_table.setText("NO RECORDS");
        }

    }

    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.dbtest_btn_myinfo_add:
                MyInformation tmpMyInfo = new MyInformation();

                String myinfo_id = dbtest_et_myinfo_id.getText().toString();
                String myinfo_nick = dbtest_et_myinfo_nick.getText().toString();
                String myinfo_name = dbtest_et_myinfo_name.getText().toString();
                int myinfo_age = Integer.parseInt(dbtest_et_myinfo_age.getText().toString());
                int myinfo_sex = Integer.parseInt(dbtest_et_myinfo_sex.getText().toString());
                int myinfo_height = Integer.parseInt(dbtest_et_myinfo_height.getText().toString());
                int myinfo_weight = Integer.parseInt(dbtest_et_myinfo_weight.getText().toString());
                int myinfo_registered = Integer.parseInt(dbtest_et_myinfo_registered.getText().toString());
                String myinfo_deviceid = dbtest_et_myinfo_deviceid.getText().toString();

                tmpMyInfo.setUserId(myinfo_id);
                tmpMyInfo.setUserNick(myinfo_nick);
                tmpMyInfo.setUserName(myinfo_name);
                tmpMyInfo.setUserAge(myinfo_age);
                tmpMyInfo.setUserSex(myinfo_sex);
                tmpMyInfo.setUserHeight(myinfo_height);
                tmpMyInfo.setUserWeight(myinfo_weight);
                tmpMyInfo.setUserRegistered(myinfo_registered);
                tmpMyInfo.setUserDeviceId(myinfo_deviceid);

                MainActivity.hereDB.insertMyInformation(tmpMyInfo);
                Log.d(TAG_DB, "[DatabaseTest] MyInformation is added to DB.");

                printMyInfoTable();
                Toast.makeText(getApplicationContext(), "Table is updated.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dbtest_btn_myeq_add:
                MyHereAgent tmpMyAgent = new MyHereAgent();

                String myeq_macid = dbtest_et_myeq_id.getText().toString();
                String myeq_name = dbtest_et_myeq_name.getText().toString();
                int myeq_type = Integer.parseInt(dbtest_et_myeq_type.getText().toString());
                String myeq_majorid = dbtest_et_myeq_majorid.getText().toString();
                String myeq_minorid = dbtest_et_myeq_minorid.getText().toString();

                tmpMyAgent.setMyeqMacId(myeq_macid);
                tmpMyAgent.setMyeqName(myeq_name);
                tmpMyAgent.setMyeqType(myeq_type);
                tmpMyAgent.setMyeqBeaconMajorId(myeq_majorid);
                tmpMyAgent.setMyeqBeaconMinorId(myeq_minorid);

                MainActivity.hereDB.insertHereAgent(tmpMyAgent);
                Log.d(TAG_DB, "[DatabaseTest] MyHereAgent is added to DB.");
                Log.d(TAG_DB, "[DatabaseTest]  > Table size (myhereagents): " + dbTestCountAgent());

                printMyHereAgentTable();
                Toast.makeText(getApplicationContext(), "Table is updated.", Toast.LENGTH_SHORT).show();

                break;
            case R.id.dbtest_btn_myroutine_add:
                Toast.makeText(getApplicationContext(), "Not implemented", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dbtest_btn_myrecord_add:
                Toast.makeText(getApplicationContext(), "Not implemented", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dbtest_btn_drop_myinfo:
                MainActivity.hereDB.dropTableMyInfo();
                printMyInfoTable();
                Toast.makeText(getApplicationContext(), "Table is dropped.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dbtest_btn_drop_myhereagents:
                MainActivity.hereDB.dropTableMyHereAgents();
                printMyHereAgentTable();
                Toast.makeText(getApplicationContext(), "Table is dropped.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dbtest_btn_drop_myroutines:
                //MainActivity.hereDB.dropTableMyRoutines();
                Toast.makeText(getApplicationContext(), "Check the code", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dbtest_btn_drop_myrecords:
                //MainActivity.hereDB.dropTableMyRecords();
                Toast.makeText(getApplicationContext(), "Check the code", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dbtest_btn_drop_all:
                //MainActivity.hereDB.dropAllTables();
                Toast.makeText(getApplicationContext(), "Check the code", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}