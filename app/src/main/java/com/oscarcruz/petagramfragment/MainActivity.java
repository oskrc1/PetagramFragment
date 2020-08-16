package com.oscarcruz.petagramfragment;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.oscarcruz.petagramfragment.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager viewPager;
    private int current_page;
    Toolbar miActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar = (Toolbar) findViewById(R.id.miToolbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




    setIconsToTabLayout();
    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
        current_page = position;
        setIconsToTabLayout();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });

    tabs.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);



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

    private void setIconsToTabLayout(){
        for (int i = 0; i<2; i++){
            tabs.getTabAt(i).setIcon(getResource(i));
        }
        tabs.getTabAt(current_page).setIcon(getSelectedIcons(current_page));

    }

    private int getResource(int no){
        switch (no){
            case 0:
                return R.drawable.ic_baseline_home_24_selected;
            case 1:
                return R.drawable.ic_baseline_pets_24_selected;
        }
        return 10;
    }
    private int getSelectedIcons(int no){
        switch (no){
            case 0:
                return R.drawable.ic_baseline_home_24;
            case 1:
                return R.drawable.ic_baseline_pets_24;
        }
        return 10;

    }

}