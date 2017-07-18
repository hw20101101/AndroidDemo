package com.hw.h20170717listviewheader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listview);
        ViewGroup headerView = (ViewGroup)getLayoutInflater().inflate(R.layout.layout_header, listView, false);
        listView.addHeaderView(headerView);

        String[] items = getResources().getStringArray(R.array.list_items);
        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.layout_row, R.id.tv_name, items);
        listView.setAdapter(adapter);
    }
}
