package com.example.recyclerviewsib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{
    RecyclerView r1, r2, r3;
    AdapterClass adapter;
    DataClass data;
    List<ModelClass> model = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = findViewById(R.id.rv1);
        r2 = findViewById(R.id.rv2);
        r3 = findViewById(R.id.rv3);

        r1.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterClass(this, model);
        r1.setAdapter(adapter);
        data = new DataClass(this, this);
        data.setData();

        r2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        adapter = new AdapterClass(this, model);
        r2.setAdapter(adapter);
        data = new DataClass(this, this);
        data.setData();

        r3.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        adapter = new AdapterClass(this, model);
        r3.setAdapter(adapter);
        data = new DataClass(this, this);
        data.setData();
    }

    public void onSuccess(List<ModelClass> model) {
        this.model.clear();
        this.model.addAll(model);
        this.adapter.notifyDataSetChanged();
    }
}
