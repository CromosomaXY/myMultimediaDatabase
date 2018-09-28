package com.elterabit.mymultimediadatabase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class HomePage extends AppCompatActivity{

    private DrawerLayout myDrawlerLayout;
    private ActionBarDrawerToggle myToggle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        myDrawlerLayout = findViewById(R.id.drawler_layout);

        myToggle = new ActionBarDrawerToggle(this, myDrawlerLayout, R.string.open, R.string.close);

        myDrawlerLayout.addDrawerListener(myToggle);
        NavigationView nvDrawler = findViewById(R.id.navigation_view);

        myToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawler);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(myToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void selectMenuItem(MenuItem menuItem){

        android.support.v4.app.Fragment myFragment = null;
        Class fragmentClass;

        switch (menuItem.getItemId()){
            case R.id.menu_sistemas:
                fragmentClass = Sistemas.class;
                break;
            case R.id.menu_videogames:
                fragmentClass = Videojuegos.class;
                break;
            case R.id.menu_peliculas:
                fragmentClass = Peliculas.class;
                break;
            case R.id.menu_musica:
                fragmentClass = Musica.class;
                break;
            case R.id.menu_libros:
                fragmentClass = Libros.class;
                break;
            case R.id.menu_comics:
                fragmentClass = Comics.class;
                break;

            default:
                fragmentClass = Sistemas.class;

        }

        try{
            myFragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();


        }catch (Exception e){
            e.printStackTrace();
        }

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout_content, myFragment).commit();
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        myDrawlerLayout.closeDrawers();
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectMenuItem(item);
                return true;            }

        });
    }


}
