package com.software.sekhon.jason.curve;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class SearchActivity extends AppCompatActivity {

    private Toolbar toolbar;

    public EditText firstName;
    public EditText lastName;
    public Spinner positions;
    public Spinner brands;
    public Spinner faces;
    public Spinner toes;
    public EditText minLie;
    public EditText maxLie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        firstName = findViewById(R.id.FirstName);
        lastName = findViewById(R.id.LastName);
        positions = findViewById(R.id.Positions);
        brands = findViewById(R.id.Brands);
        faces = findViewById(R.id.Faces);
        toes = findViewById(R.id.Toes);
        minLie = findViewById(R.id.MinLie);
        maxLie = findViewById(R.id.MaxLie);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.return_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_back) {
            finish();
            return true;
        }
        return false;
    }

    public void filterList(View v){
        int minLieTemp = 0;
        int maxLieTemp = 10;
        if (!minLie.getText().toString().matches(""))
            minLieTemp = Integer.parseInt(minLie.getText().toString());
        if (!maxLie.getText().toString().matches(""))
            maxLieTemp = Integer.parseInt(maxLie.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("firstName", firstName.getText().toString());
        intent.putExtra("lastName", lastName.getText().toString());
        intent.putExtra("position", positions.getSelectedItem().toString());
        intent.putExtra("brand", brands.getSelectedItem().toString());
        intent.putExtra("face", faces.getSelectedItem().toString());
        intent.putExtra("toe", toes.getSelectedItem().toString());
        intent.putExtra("minLie", minLieTemp);
        intent.putExtra("maxLie", maxLieTemp);
        setResult(RESULT_OK, intent);
        finish();
    }
}
