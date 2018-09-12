package com.elterabit.mymultimediadatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //referencia a la imagen inicial de la app
    private ImageView imagenSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //pondremos la imagen a pantalla completa y sin titulo
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //cargamos el activity de la imagen
        setContentView(R.layout.activity_main);
        //ocultamos el actionBar
        getSupportActionBar().hide();

        imagenSplash = findViewById(R.id.imagesplash);
        Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.transicion);
        imagenSplash.startAnimation(myAnimation);

        //referencia a el intent de carga del drawlerMenu(HomePage)
        final Intent intentDrawlerMenu = new Intent(this, HomePage.class);

        //lanzamos un timer para mantener la imagen el tiempo que le pasemos
        Thread timer = new Thread(){

            public void run(){
                try{
                    sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                finally{
                    startActivity(intentDrawlerMenu);
                    finish();
                }
            }
        };

        timer.start();
    }
}
