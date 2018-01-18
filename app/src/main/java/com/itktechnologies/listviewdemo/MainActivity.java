package com.itktechnologies.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar timesTableSeekBar;
    ListView timesTablesListView;

    public void generateTimesTable(int timesTable) {

        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int i = 1; i <= 10; i++) {
            timesTableContent.add (Integer.toString(i * timesTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesTableContent);
        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timesTableSeekBar = (SeekBar)findViewById(R.id.timesTableSeekBar);
        timesTablesListView = (ListView)findViewById(R.id.timesTablesListView);

        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min = 1;
                int timesTable;

                if (i < min) {
                    timesTable = min;
                    timesTableSeekBar.setProgress(min);

                } else {
                    timesTable = i;
                }

                generateTimesTable(timesTable);
                //Log.i("Seekbar value", Integer.toString(timesTable));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimesTable(10);





/*
        ListView listView = (ListView)findViewById(R.id.listView);

        final ArrayList<String> aNames = new ArrayList<String>();

        aNames.add("Alex");
        aNames.add("Matthew");
        aNames.add("Ron");
        aNames.add("Deb");



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, aNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                Toast.makeText(getApplicationContext(), "Hello " + aNames.get(i), Toast.LENGTH_SHORT).show();
                                            }
                                        });
*/


    }
}
