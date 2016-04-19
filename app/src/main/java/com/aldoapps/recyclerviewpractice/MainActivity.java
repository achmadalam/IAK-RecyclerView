package com.aldoapps.recyclerviewpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
    implements MyAdapter.MyInterface
{

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private ArrayList<Cat> mCatList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCatList.add(new Cat("meong", 3));
        mCatList.add(new Cat("putih", 1));
        mCatList.add(new Cat("hitam", 4));

        mAdapter = new MyAdapter(mCatList);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // untuk nambahin garis pembatas di recycler view
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        mRecyclerView.setAdapter(mAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void OnCatClicked(Cat cat) {
        String message = cat.getName() + " says hello!";
        Toast.makeText(MainActivity.this,
                message,
                Toast.LENGTH_SHORT).show();
    }
}
