package com.example.lab9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName, etPhone;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.edName);
        etPhone = (EditText) findViewById(R.id.edPhon);

        dbHandler = new MyDBHandler(this);
    }


    public void addButtonClicked(View v){

        String n = etName.getText().toString();
        String p = etPhone.getText().toString();

        dbHandler.addRecord(n,p);

        //clear

        etName.setText("");
        etPhone.setText("");


    }

   public void printDatabaseData(View v){
        String db = dbHandler.dataBaseToString();
        Toast.makeText(getApplicationContext(),db,Toast.LENGTH_LONG).show();

    }
}