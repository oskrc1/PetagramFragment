package com.oscarcruz.petagramfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AcercaDe extends AppCompatActivity {
    Toolbar miActionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        miActionBar = (Toolbar) findViewById(R.id.miToolbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_p,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mAcercaDe:
                Intent intent1 = new Intent(this, AcercaDe.class);
                startActivity(intent1);
                break;

            case R.id.mContacto:
                Intent intent2 = new Intent(this, Contacto.class);
                startActivity(intent2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}