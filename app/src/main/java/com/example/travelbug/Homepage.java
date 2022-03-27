package com.example.travelbug;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.Toast;
import android.widget.VideoView;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO;

public class Homepage extends AppCompatActivity {
    Animation scaleUp,scaleDown;
    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
    HorizontalScrollView hs;
    VideoView v;
    String video = "city_video";
    View toolbar;
    SharedPreferences sp;
    SharedPref sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        sharedpref = new SharedPref(this);

        if(sharedpref.loadNightModeState()==true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        sp = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String isset = sp.getString("cityname","");

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar((Toolbar) toolbar);


        v=(VideoView)findViewById(R.id.videoView);
        v.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.city_video);
        v.start();
        /*v.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (isFinishing())
                    return;
            }
        });*/

        v.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });


       /* hs = findViewById(R.id.horizontalScroll);
        hs.post(new Runnable() {
            @Override
            public void run() {
                hs.fullScroll(hs.FOCUS_RIGHT);
            }
        });*/



        c1 = findViewById(R.id.card1);
        c2 = findViewById(R.id.card2);
        c3 = findViewById(R.id.card3);
        c4 = findViewById(R.id.card4);
        c5 = findViewById(R.id.card5);
        c6 = findViewById(R.id.card6);
        c7 = findViewById(R.id.card7);
        c8 = findViewById(R.id.card8);
        c9 = findViewById(R.id.card9);
        c10 = findViewById(R.id.card10);

        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        /*c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1.setAnimation(scaleDown);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("cityname","mumbai");
                editor.commit();

                Intent i = new Intent(Homepage.this, city.class);
                startActivity(i);
            }
        });*/

        c1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    c1.startAnimation(scaleUp);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("cityname","delhi");
                    editor.commit();

                    Intent i = new Intent(Homepage.this, city.class);
                    startActivity(i);
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    c1.startAnimation(scaleDown);
                }

                return true;
            }
        });


        c2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    c2.startAnimation(scaleUp);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("cityname","mumbai");
                    editor.commit();

                    Intent i = new Intent(Homepage.this, city.class);
                    startActivity(i);
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    c2.startAnimation(scaleDown);
                }
                return true;
            }
        });

        c3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    c3.startAnimation(scaleUp);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("cityname","ahmedabad");
                    editor.commit();

                    Intent i = new Intent(Homepage.this, city.class);
                    startActivity(i);
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    c3.startAnimation(scaleDown);
                }

                return true;
            }
        });

        c4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    c4.startAnimation(scaleUp);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("cityname","agra");
                    editor.commit();

                    Intent i = new Intent(Homepage.this, city.class);
                    startActivity(i);
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    c4.startAnimation(scaleDown);
                }

                return true;
            }
        });

        c5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    c5.startAnimation(scaleUp);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("cityname","bangalore");
                    editor.commit();

                    Intent i = new Intent(Homepage.this, city.class);
                    startActivity(i);
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    c5.startAnimation(scaleDown);
                }

                return true;
            }
        });

        c6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    c6.startAnimation(scaleUp);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("cityname","chennai");
                    editor.commit();

                    Intent i = new Intent(Homepage.this, city.class);
                    startActivity(i);
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    c6.startAnimation(scaleDown);
                }
                return true;
            }
        });

        c7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    c7.startAnimation(scaleUp);
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    c7.startAnimation(scaleDown);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("cityname","hyderabad");
                    editor.commit();

                    Intent i = new Intent(Homepage.this, city.class);
                    startActivity(i);
                }

                return true;
            }
        });

        c8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    c8.startAnimation(scaleUp);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("cityname","jaipur");
                    editor.commit();

                    Intent i = new Intent(Homepage.this, city.class);
                    startActivity(i);
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    c8.startAnimation(scaleDown);
                }

                return true;
            }
        });

        c9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    c9.startAnimation(scaleUp);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("cityname","kolkatta");
                    editor.commit();

                    Intent i = new Intent(Homepage.this, city.class);
                    startActivity(i);
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    c9.startAnimation(scaleDown);
                }

                return true;
            }
        });

        c10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    c10.startAnimation(scaleUp);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("cityname","lucknow");
                    editor.commit();

                    Intent i = new Intent(Homepage.this, city.class);
                    startActivity(i);
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    c10.startAnimation(scaleDown);
                }

                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.thememenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_themech:
                    sharedpref.setNightModeState(true);
                //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    startActivity(new Intent(getApplicationContext(), Homepage.class));
                    return true;
            case R.id.action_themenight:
                sharedpref.setNightModeState(false);
                //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                startActivity(new Intent(getApplicationContext(), Homepage.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Homepage.this);
        builder.setMessage("Do you want to exit ?");
    builder.setTitle("Alert !");
    builder.setCancelable(false);
    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            finish();
        }
    });

    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    });

    AlertDialog alertDialog = builder.create();
    alertDialog.show();

    }

    @Override
    protected void onResume(){
        super.onResume();
        v.start();
    }

    /*public void light(View view) {
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO);
        startActivity(new Intent(getApplicationContext(),Homepage.class));
        finish();
    }

    public void dark(View view) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        startActivity(new Intent(getApplicationContext(),Homepage.class));
        finish();
    }*/
}