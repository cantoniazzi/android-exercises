package com.example.aluno.aula2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aluno on 12/07/2016.
 */
public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        RecyclerView rvList = (RecyclerView)findViewById(R.id.rvList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);

        List<String> list = new ArrayList<String>();
//        for (int i = 0; i < 100; i++){
//            list.add(String.format("Item %s",i));
//        }
        list.add(getString(R.string.show_msg));
        list.add(getString(R.string.call_phone));
        list.add(getString(R.string.open_web));

        ListAdapter adapter = new ListAdapter(this, list);
        rvList.setAdapter(adapter);

        Intent intent = getIntent();

        if (intent != null) {
            String text = intent.getStringExtra("MY_KEY");
            boolean boolValue = intent.getBooleanExtra("MY_BOOL_KEY",false);

//            list.set(0, String.format("%s is %s", text, boolValue));

        }

    }

}
