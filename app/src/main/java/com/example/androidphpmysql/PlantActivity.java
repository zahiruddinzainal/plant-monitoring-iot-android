package com.example.androidphpmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.androidphpmysql.CreatePlant.CreatePlantDashboard;
import com.example.androidphpmysql.CreatePlant.EditorActivity;
import com.getbase.floatingactionbutton.FloatingActionButton;

public class PlantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);

        FloatingActionButton fab1 = findViewById(R.id.fab_action1);

        fab1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent x = new Intent(PlantActivity.this, EditorActivity.class);
                startActivity(x);
            }

        });

        FloatingActionButton fab2 = findViewById(R.id.fab_action2);

        fab2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showToast("Plantpedia");
            }

        });

    }

    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}