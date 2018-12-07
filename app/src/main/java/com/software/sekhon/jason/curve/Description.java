package com.software.sekhon.jason.curve;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.software.sekhon.jason.curve.MyDB.Player;

public class Description extends AppCompatActivity {

    private Toolbar toolbar;

    private Player player;
    ImageView headshot;
    ImageView stickImg;
    TextView playerName;
    TextView position;
    TextView brand;
    TextView curveName;
    TextView curveType;
    TextView lie;
    TextView face;
    TextView toe;
    TextView length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        player = (Player) getIntent().getSerializableExtra("Player");
        playerName = findViewById(R.id.PlayerName);
        position = findViewById(R.id.Position);
        brand = findViewById(R.id.Brand);
        curveName = findViewById(R.id.CurveName);
        curveType = findViewById(R.id.CurveType);
        lie = findViewById(R.id.Lie);
        face = findViewById(R.id.Face);
        toe = findViewById(R.id.Toe);
        length = findViewById(R.id.Length);
        headshot = findViewById(R.id.HeadShot);
        stickImg = findViewById(R.id.StickImg);
        setDisplay();
    }

    protected void setDisplay(){
        Glide.with(this).load(player.headshotURL).into(headshot);
        Glide.with(this).load(player.stickURL).into(stickImg);
        playerName.setText(player.firstName + " " + player.lastName);
        position.setText(player.position);
        brand.setText(player.brand);
        curveName.setText(player.curveName);
        curveType.setText(player.curveType);
        lie.setText(""+player.lie);
        face.setText(player.face);
        toe.setText(player.toe);
        length.setText(player.bladeLength);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.description_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.desc_action_back) {
            finish();
            return true;
        }
        return false;
    }
}
