package com.danielvelastegui.deberpetagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.danielvelastegui.deberpetagram.adapter.MascotasAdapter;
import com.danielvelastegui.deberpetagram.adapter.PageAdapter;
import com.danielvelastegui.deberpetagram.contenedor.Mascota;
import com.danielvelastegui.deberpetagram.fragment.HomeFragment;
import com.danielvelastegui.deberpetagram.fragment.ProfileFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar materialToolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materialToolBar = findViewById(R.id.mainToolBar);
        setSupportActionBar(materialToolBar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();
    }

    private ArrayList<Fragment> addFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new HomeFragment());
        fragments.add(new ProfileFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), 1, addFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile_icon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
//            case R.id.mEstrella:
//                abrirFavoritos();
//                break;

            case R.id.mAcerca:
                Intent intentAbout = new Intent(MainActivity.this, About.class);
                startActivity(intentAbout);
                break;
            case R.id.mContacto:
                Intent intentContact = new Intent(MainActivity.this, Contact.class);
                startActivity(intentContact);
                break;
            case R.id.mConfigurar:
                Intent intentSettings = new Intent(MainActivity.this, Settings.class);
                startActivity(intentSettings);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void abrirFavoritos(){
        Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
        startActivity(intent);
    }
}