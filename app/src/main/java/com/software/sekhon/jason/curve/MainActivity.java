package com.software.sekhon.jason.curve;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.software.sekhon.jason.curve.MyDB.AppDatabase;
import com.software.sekhon.jason.curve.MyDB.Player;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = "MainActivity";
    public static final int SEARCH_ACTIVITY_REQUEST_CODE = 0;

    private Toolbar toolbar;
    private List<Player> players;
    public static RecyclerView recyclerView;
    public static RecyclerViewAdapter adapter;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(TAG, "onCreate: started.");
        db = AppDatabase.getInstance(getApplication());
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        players = db.playerDao().getALL();
        adapter = new RecyclerViewAdapter(players, getApplication());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SEARCH_ACTIVITY_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                players = db.playerDao().filterQuery(
                        "%"+data.getStringExtra("firstName")+"%",
                        "%"+data.getStringExtra("lastName")+"%",
                        "%"+data.getStringExtra("position")+"%",
                        "%"+data.getStringExtra("brand"),
                        "%"+data.getStringExtra("face"),
                        "%"+data.getStringExtra("toe"),
                        data.getIntExtra("minLie", 0),
                        data.getIntExtra("maxLie", 10));
                for (Player p: players)
                    Log.d(TAG, p.firstName);
                adapter.swap(players);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            startActivityForResult(new Intent(this, SearchActivity.class), SEARCH_ACTIVITY_REQUEST_CODE);
            return true;
        }
        return false;
    }
}
