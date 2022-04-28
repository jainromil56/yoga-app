package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class slidetrial extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//    onclick
    public void setgo(View view){
        Intent intent =new Intent(this,slide.class);
        startActivity(intent);
    }
//    onclick

//snackbar
    public void snackbar(View view){

        SharedPreferences sharedPreferences = getSharedPreferences("Days",MODE_PRIVATE);
        final int valo= (int) sharedPreferences.getInt("over", MODE_PRIVATE);

        Snackbar.make(view, "First complete previous task" + valo, Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();


    }
//    snackbar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidetrial);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        callText();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

            Intent intent =new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.slidetrial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent =new Intent(this, MainActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void callText(){

        TextView textView1 = (TextView)findViewById(R.id.text1);
        TextView textView2 = (TextView)findViewById(R.id.text2);
        TextView textView3 = (TextView)findViewById(R.id.text3);
        TextView textView4 = (TextView)findViewById(R.id.text4);
        TextView textView5 = (TextView)findViewById(R.id.text5);
        TextView textView6 = (TextView)findViewById(R.id.text6);
        TextView textView7 = (TextView)findViewById(R.id.text7);

        ImageView imageView1 = (ImageView)findViewById(R.id.image1);
        ImageView imageView2 = (ImageView)findViewById(R.id.image2);
        ImageView imageView3 = (ImageView)findViewById(R.id.image3);
        ImageView imageView4 = (ImageView)findViewById(R.id.image4);
        ImageView imageView5 = (ImageView)findViewById(R.id.image5);
        ImageView imageView6 = (ImageView)findViewById(R.id.image6);
        ImageView imageView7 = (ImageView)findViewById(R.id.image7);
        ImageView imageView8 = (ImageView)findViewById(R.id.image8);
//        ------------------------------------------------------------------------------------------------
        TextView textView01 = (TextView)findViewById(R.id.text01);
        TextView textView02 = (TextView)findViewById(R.id.text02);
        TextView textView03 = (TextView)findViewById(R.id.text03);
        TextView textView04 = (TextView)findViewById(R.id.text04);
        TextView textView05 = (TextView)findViewById(R.id.text05);
        TextView textView06 = (TextView)findViewById(R.id.text06);
        TextView textView07 = (TextView)findViewById(R.id.text07);

        ImageView imageView01 = (ImageView)findViewById(R.id.image01);
        ImageView imageView02 = (ImageView)findViewById(R.id.image02);
        ImageView imageView03 = (ImageView)findViewById(R.id.image03);
        ImageView imageView04 = (ImageView)findViewById(R.id.image04);
        ImageView imageView05 = (ImageView)findViewById(R.id.image05);
        ImageView imageView06 = (ImageView)findViewById(R.id.image06);
        ImageView imageView07 = (ImageView)findViewById(R.id.image07);
        ImageView imageView08 = (ImageView)findViewById(R.id.image08);
//        ------------------------------------------------------------------------------------------------
        TextView textView001 = (TextView)findViewById(R.id.text001);
        TextView textView002 = (TextView)findViewById(R.id.text002);
        TextView textView003 = (TextView)findViewById(R.id.text003);
        TextView textView004 = (TextView)findViewById(R.id.text004);
        TextView textView005 = (TextView)findViewById(R.id.text005);
        TextView textView006 = (TextView)findViewById(R.id.text006);
        TextView textView007 = (TextView)findViewById(R.id.text007);

        ImageView imageView001 = (ImageView)findViewById(R.id.image001);
        ImageView imageView002 = (ImageView)findViewById(R.id.image002);
        ImageView imageView003 = (ImageView)findViewById(R.id.image003);
        ImageView imageView004 = (ImageView)findViewById(R.id.image004);
        ImageView imageView005 = (ImageView)findViewById(R.id.image005);
        ImageView imageView006 = (ImageView)findViewById(R.id.image006);
        ImageView imageView007 = (ImageView)findViewById(R.id.image007);
        ImageView imageView008 = (ImageView)findViewById(R.id.image008);
//        ------------------------------------------------------------------------------------------------
        TextView textView0001 = (TextView)findViewById(R.id.text0001);
        TextView textView0002 = (TextView)findViewById(R.id.text0002);
        TextView textView0003 = (TextView)findViewById(R.id.text0003);
        TextView textView0004 = (TextView)findViewById(R.id.text0004);
        TextView textView0005 = (TextView)findViewById(R.id.text0005);
        TextView textView0006 = (TextView)findViewById(R.id.text0006);
        TextView textView0007 = (TextView)findViewById(R.id.text0007);

        ImageView imageView0001 = (ImageView)findViewById(R.id.image0001);
        ImageView imageView0002 = (ImageView)findViewById(R.id.image0002);
        ImageView imageView0003 = (ImageView)findViewById(R.id.image0003);
        ImageView imageView0004 = (ImageView)findViewById(R.id.image0004);
        ImageView imageView0005 = (ImageView)findViewById(R.id.image0005);
        ImageView imageView0006 = (ImageView)findViewById(R.id.image0006);
        ImageView imageView0007 = (ImageView)findViewById(R.id.image0007);
        ImageView imageView0008 = (ImageView)findViewById(R.id.image0008);

        SharedPreferences sharedPreferences = getSharedPreferences("Days",MODE_PRIVATE);
        final int valo= (int) sharedPreferences.getInt("over", MODE_PRIVATE);
        if(valo==1){
            textView1.setText("");
            imageView1.setImageResource(R.drawable.star);
        }
        if (valo==2){
            textView1.setText("");
            textView2.setText("");
            imageView1.setImageResource(R.drawable.star);
            imageView2.setImageResource(R.drawable.star);
        }
        if (valo==3){
            textView1.setText("");
            textView2.setText("");
            textView3.setText("");
            imageView1.setImageResource(R.drawable.star);
            imageView2.setImageResource(R.drawable.star);
            imageView3.setImageResource(R.drawable.star);
        }
        if (valo==4){
            textView1.setText("");
            textView2.setText("");
            textView3.setText("");
            textView4.setText("");
            imageView1.setImageResource(R.drawable.star);
            imageView2.setImageResource(R.drawable.star);
            imageView3.setImageResource(R.drawable.star);
            imageView4.setImageResource(R.drawable.star);
        }
        if (valo==5){
            textView1.setText("");
            textView2.setText("");
            textView3.setText("");
            textView4.setText("");
            textView5.setText("");
            imageView1.setImageResource(R.drawable.star);
            imageView2.setImageResource(R.drawable.star);
            imageView3.setImageResource(R.drawable.star);
            imageView4.setImageResource(R.drawable.star);
            imageView5.setImageResource(R.drawable.star);
        }
        if (valo==6){
            textView1.setText("");
            textView2.setText("");
            textView3.setText("");
            textView4.setText("");
            textView5.setText("");
            textView6.setText("");
            imageView1.setImageResource(R.drawable.star);
            imageView2.setImageResource(R.drawable.star);
            imageView3.setImageResource(R.drawable.star);
            imageView4.setImageResource(R.drawable.star);
            imageView5.setImageResource(R.drawable.star);
            imageView6.setImageResource(R.drawable.star);
        }
        if (valo==7){
            textView1.setText("");
            textView2.setText("");
            textView3.setText("");
            textView4.setText("");
            textView5.setText("");
            textView6.setText("");
            textView7.setText("");
            imageView1.setImageResource(R.drawable.star);
            imageView2.setImageResource(R.drawable.star);
            imageView3.setImageResource(R.drawable.star);
            imageView4.setImageResource(R.drawable.star);
            imageView5.setImageResource(R.drawable.star);
            imageView6.setImageResource(R.drawable.star);
            imageView7.setImageResource(R.drawable.star);
        }
        if (valo==8){
            textView1.setText("");
            textView2.setText("");
            textView3.setText("");
            textView4.setText("");
            textView5.setText("");
            textView6.setText("");
            textView7.setText("");
            imageView1.setImageResource(R.drawable.star);
            imageView2.setImageResource(R.drawable.star);
            imageView3.setImageResource(R.drawable.star);
            imageView4.setImageResource(R.drawable.star);
            imageView5.setImageResource(R.drawable.star);
            imageView6.setImageResource(R.drawable.star);
            imageView7.setImageResource(R.drawable.star);
            imageView8.setImageResource(R.drawable.trophy1);
        }
//        2nd row
        if (valo==9){
            firstcom();
            textView01.setText("");
            imageView01.setImageResource(R.drawable.star);
        }
        if (valo==10){
            firstcom();
            textView01.setText("");
            textView02.setText("");
            imageView01.setImageResource(R.drawable.star);
            imageView02.setImageResource(R.drawable.star);
        }
        if (valo==11){
            firstcom();
            textView01.setText("");
            textView02.setText("");
            textView03.setText("");
            imageView01.setImageResource(R.drawable.star);
            imageView02.setImageResource(R.drawable.star);
            imageView03.setImageResource(R.drawable.star);
        }
        if (valo==12){
            firstcom();
            textView01.setText("");
            textView02.setText("");
            textView03.setText("");
            textView04.setText("");
            imageView01.setImageResource(R.drawable.star);
            imageView02.setImageResource(R.drawable.star);
            imageView03.setImageResource(R.drawable.star);
            imageView04.setImageResource(R.drawable.star);
        }
        if (valo==13){
            firstcom();
            textView01.setText("");
            textView02.setText("");
            textView03.setText("");
            textView04.setText("");
            textView05.setText("");
            imageView01.setImageResource(R.drawable.star);
            imageView02.setImageResource(R.drawable.star);
            imageView03.setImageResource(R.drawable.star);
            imageView04.setImageResource(R.drawable.star);
            imageView05.setImageResource(R.drawable.star);
        }
        if (valo==14){
            firstcom();
            textView01.setText("");
            textView02.setText("");
            textView03.setText("");
            textView04.setText("");
            textView05.setText("");
            textView06.setText("");
            imageView01.setImageResource(R.drawable.star);
            imageView02.setImageResource(R.drawable.star);
            imageView03.setImageResource(R.drawable.star);
            imageView04.setImageResource(R.drawable.star);
            imageView05.setImageResource(R.drawable.star);
            imageView06.setImageResource(R.drawable.star);
        }
        if (valo==15){
            firstcom();
            textView01.setText("");
            textView02.setText("");
            textView03.setText("");
            textView04.setText("");
            textView05.setText("");
            textView06.setText("");
            textView07.setText("");
            imageView01.setImageResource(R.drawable.star);
            imageView02.setImageResource(R.drawable.star);
            imageView03.setImageResource(R.drawable.star);
            imageView04.setImageResource(R.drawable.star);
            imageView05.setImageResource(R.drawable.star);
            imageView06.setImageResource(R.drawable.star);
            imageView07.setImageResource(R.drawable.star);
        }
        if (valo==16){
            firstcom();
            textView01.setText("");
            textView02.setText("");
            textView03.setText("");
            textView04.setText("");
            textView05.setText("");
            textView06.setText("");
            textView07.setText("");
            imageView01.setImageResource(R.drawable.star);
            imageView02.setImageResource(R.drawable.star);
            imageView03.setImageResource(R.drawable.star);
            imageView04.setImageResource(R.drawable.star);
            imageView05.setImageResource(R.drawable.star);
            imageView06.setImageResource(R.drawable.star);
            imageView07.setImageResource(R.drawable.star);
            imageView08.setImageResource(R.drawable.trophy1);
        }
//        3rd row
        if (valo==17){
            secondcom();
            textView001.setText("");
            imageView001.setImageResource(R.drawable.star);
        }
        if (valo==18){
            secondcom();
            textView001.setText("");
            textView002.setText("");
            imageView001.setImageResource(R.drawable.star);
            imageView002.setImageResource(R.drawable.star);
        }
        if (valo==19){
            secondcom();
            textView001.setText("");
            textView002.setText("");
            textView003.setText("");
            imageView001.setImageResource(R.drawable.star);
            imageView002.setImageResource(R.drawable.star);
            imageView003.setImageResource(R.drawable.star);
        }
        if (valo==20){
            secondcom();
            textView001.setText("");
            textView002.setText("");
            textView003.setText("");
            textView004.setText("");
            imageView001.setImageResource(R.drawable.star);
            imageView002.setImageResource(R.drawable.star);
            imageView003.setImageResource(R.drawable.star);
            imageView004.setImageResource(R.drawable.star);
        }
        if (valo==21){
            secondcom();
            textView001.setText("");
            textView002.setText("");
            textView003.setText("");
            textView004.setText("");
            textView005.setText("");
            imageView001.setImageResource(R.drawable.star);
            imageView002.setImageResource(R.drawable.star);
            imageView003.setImageResource(R.drawable.star);
            imageView004.setImageResource(R.drawable.star);
            imageView005.setImageResource(R.drawable.star);
        }
        if (valo==22){
            secondcom();
            textView001.setText("");
            textView002.setText("");
            textView003.setText("");
            textView004.setText("");
            textView005.setText("");
            textView006.setText("");
            imageView001.setImageResource(R.drawable.star);
            imageView002.setImageResource(R.drawable.star);
            imageView003.setImageResource(R.drawable.star);
            imageView004.setImageResource(R.drawable.star);
            imageView005.setImageResource(R.drawable.star);
            imageView006.setImageResource(R.drawable.star);
        }
        if (valo==23){
            secondcom();
            textView001.setText("");
            textView002.setText("");
            textView003.setText("");
            textView004.setText("");
            textView005.setText("");
            textView006.setText("");
            textView007.setText("");
            imageView001.setImageResource(R.drawable.star);
            imageView002.setImageResource(R.drawable.star);
            imageView003.setImageResource(R.drawable.star);
            imageView004.setImageResource(R.drawable.star);
            imageView005.setImageResource(R.drawable.star);
            imageView006.setImageResource(R.drawable.star);
            imageView007.setImageResource(R.drawable.star);
        }
        if (valo==24){
            secondcom();
            textView001.setText("");
            textView002.setText("");
            textView003.setText("");
            textView004.setText("");
            textView005.setText("");
            textView006.setText("");
            textView007.setText("");
            imageView001.setImageResource(R.drawable.star);
            imageView002.setImageResource(R.drawable.star);
            imageView003.setImageResource(R.drawable.star);
            imageView004.setImageResource(R.drawable.star);
            imageView005.setImageResource(R.drawable.star);
            imageView006.setImageResource(R.drawable.star);
            imageView007.setImageResource(R.drawable.star);
            imageView008.setImageResource(R.drawable.trophy1);
        }
//        4th row
        if (valo==25){
            thirdcom();
            textView0001.setText("");
            imageView0001.setImageResource(R.drawable.star);
        }
        if (valo==26){
            thirdcom();
            textView0001.setText("");
            textView0002.setText("");
            imageView0001.setImageResource(R.drawable.star);
            imageView0002.setImageResource(R.drawable.star);
        }
        if (valo==27){
            thirdcom();
            textView0001.setText("");
            textView0002.setText("");
            textView0003.setText("");
            imageView0001.setImageResource(R.drawable.star);
            imageView0002.setImageResource(R.drawable.star);
            imageView0003.setImageResource(R.drawable.star);
        }
        if (valo==28){
            thirdcom();
            textView0001.setText("");
            textView0002.setText("");
            textView0003.setText("");
            textView0004.setText("");
            imageView0001.setImageResource(R.drawable.star);
            imageView0002.setImageResource(R.drawable.star);
            imageView0003.setImageResource(R.drawable.star);
            imageView0004.setImageResource(R.drawable.star);
        }
        if (valo==29){
            thirdcom();
            textView0001.setText("");
            textView0002.setText("");
            textView0003.setText("");
            textView0004.setText("");
            textView0005.setText("");
            imageView0001.setImageResource(R.drawable.star);
            imageView0002.setImageResource(R.drawable.star);
            imageView0003.setImageResource(R.drawable.star);
            imageView0004.setImageResource(R.drawable.star);
            imageView0005.setImageResource(R.drawable.star);
        }
        if (valo==30){
            thirdcom();
            textView0001.setText("");
            textView0002.setText("");
            textView0003.setText("");
            textView0004.setText("");
            textView0005.setText("");
            textView0006.setText("");
            imageView0001.setImageResource(R.drawable.star);
            imageView0002.setImageResource(R.drawable.star);
            imageView0003.setImageResource(R.drawable.star);
            imageView0004.setImageResource(R.drawable.star);
            imageView0005.setImageResource(R.drawable.star);
            imageView0006.setImageResource(R.drawable.star);
        }
        if (valo==31){
            thirdcom();
            textView0001.setText("");
            textView0002.setText("");
            textView0003.setText("");
            textView0004.setText("");
            textView0005.setText("");
            textView0006.setText("");
            textView0007.setText("");
            imageView0001.setImageResource(R.drawable.star);
            imageView0002.setImageResource(R.drawable.star);
            imageView0003.setImageResource(R.drawable.star);
            imageView0004.setImageResource(R.drawable.star);
            imageView0005.setImageResource(R.drawable.star);
            imageView0006.setImageResource(R.drawable.star);
            imageView0007.setImageResource(R.drawable.star);
        }
        if (valo==32){
            thirdcom();
            textView0001.setText("");
            textView0002.setText("");
            textView0003.setText("");
            textView0004.setText("");
            textView0005.setText("");
            textView0006.setText("");
            textView0007.setText("");
            imageView0001.setImageResource(R.drawable.star);
            imageView0002.setImageResource(R.drawable.star);
            imageView0003.setImageResource(R.drawable.star);
            imageView0004.setImageResource(R.drawable.star);
            imageView0005.setImageResource(R.drawable.star);
            imageView0006.setImageResource(R.drawable.star);
            imageView0007.setImageResource(R.drawable.star);
            imageView0008.setImageResource(R.drawable.trophy1);
        }

    }

    public void firstcom(){
        TextView textView1 = (TextView)findViewById(R.id.text1);
        TextView textView2 = (TextView)findViewById(R.id.text2);
        TextView textView3 = (TextView)findViewById(R.id.text3);
        TextView textView4 = (TextView)findViewById(R.id.text4);
        TextView textView5 = (TextView)findViewById(R.id.text5);
        TextView textView6 = (TextView)findViewById(R.id.text6);
        TextView textView7 = (TextView)findViewById(R.id.text7);

        ImageView imageView1 = (ImageView)findViewById(R.id.image1);
        ImageView imageView2 = (ImageView)findViewById(R.id.image2);
        ImageView imageView3 = (ImageView)findViewById(R.id.image3);
        ImageView imageView4 = (ImageView)findViewById(R.id.image4);
        ImageView imageView5 = (ImageView)findViewById(R.id.image5);
        ImageView imageView6 = (ImageView)findViewById(R.id.image6);
        ImageView imageView7 = (ImageView)findViewById(R.id.image7);
        ImageView imageView8 = (ImageView)findViewById(R.id.image8);
        textView1.setText("");
        textView2.setText("");
        textView3.setText("");
        textView4.setText("");
        textView5.setText("");
        textView6.setText("");
        textView7.setText("");
        imageView1.setImageResource(R.drawable.star);
        imageView2.setImageResource(R.drawable.star);
        imageView3.setImageResource(R.drawable.star);
        imageView4.setImageResource(R.drawable.star);
        imageView5.setImageResource(R.drawable.star);
        imageView6.setImageResource(R.drawable.star);
        imageView7.setImageResource(R.drawable.star);
        imageView8.setImageResource(R.drawable.trophy1);

        TextView textweek = (TextView)findViewById(R.id.week2);
        int blue = Color.parseColor("#024556");
        textweek.setTextColor(blue);

        ImageView sidebar = (ImageView)findViewById(R.id.sidebar2);
        sidebar.setImageResource(R.drawable.sidebar);
    }
    public void secondcom(){
        firstcom();
        TextView textView01 = (TextView)findViewById(R.id.text01);
        TextView textView02 = (TextView)findViewById(R.id.text02);
        TextView textView03 = (TextView)findViewById(R.id.text03);
        TextView textView04 = (TextView)findViewById(R.id.text04);
        TextView textView05 = (TextView)findViewById(R.id.text05);
        TextView textView06 = (TextView)findViewById(R.id.text06);
        TextView textView07 = (TextView)findViewById(R.id.text07);

        ImageView imageView01 = (ImageView)findViewById(R.id.image01);
        ImageView imageView02 = (ImageView)findViewById(R.id.image02);
        ImageView imageView03 = (ImageView)findViewById(R.id.image03);
        ImageView imageView04 = (ImageView)findViewById(R.id.image04);
        ImageView imageView05 = (ImageView)findViewById(R.id.image05);
        ImageView imageView06 = (ImageView)findViewById(R.id.image06);
        ImageView imageView07 = (ImageView)findViewById(R.id.image07);
        ImageView imageView08 = (ImageView)findViewById(R.id.image08);
        textView01.setText("");
        textView02.setText("");
        textView03.setText("");
        textView04.setText("");
        textView05.setText("");
        textView06.setText("");
        textView07.setText("");
        imageView01.setImageResource(R.drawable.star);
        imageView02.setImageResource(R.drawable.star);
        imageView03.setImageResource(R.drawable.star);
        imageView04.setImageResource(R.drawable.star);
        imageView05.setImageResource(R.drawable.star);
        imageView06.setImageResource(R.drawable.star);
        imageView07.setImageResource(R.drawable.star);
        imageView08.setImageResource(R.drawable.trophy1);

        TextView textweek = (TextView)findViewById(R.id.week2);
        int blue = Color.parseColor("#024556");
        textweek.setTextColor(blue);

        TextView textweek1 = (TextView)findViewById(R.id.week3);
        textweek1.setTextColor(blue);

        ImageView sidebar = (ImageView)findViewById(R.id.sidebar3);
        sidebar.setImageResource(R.drawable.sidebar);
    }
    public void thirdcom(){
        secondcom();
        TextView textView001 = (TextView)findViewById(R.id.text001);
        TextView textView002 = (TextView)findViewById(R.id.text002);
        TextView textView003 = (TextView)findViewById(R.id.text003);
        TextView textView004 = (TextView)findViewById(R.id.text004);
        TextView textView005 = (TextView)findViewById(R.id.text005);
        TextView textView006 = (TextView)findViewById(R.id.text006);
        TextView textView007 = (TextView)findViewById(R.id.text007);

        ImageView imageView001 = (ImageView)findViewById(R.id.image001);
        ImageView imageView002 = (ImageView)findViewById(R.id.image002);
        ImageView imageView003 = (ImageView)findViewById(R.id.image003);
        ImageView imageView004 = (ImageView)findViewById(R.id.image004);
        ImageView imageView005 = (ImageView)findViewById(R.id.image005);
        ImageView imageView006 = (ImageView)findViewById(R.id.image006);
        ImageView imageView007 = (ImageView)findViewById(R.id.image007);
        ImageView imageView008 = (ImageView)findViewById(R.id.image008);

        textView001.setText("");
        textView002.setText("");
        textView003.setText("");
        textView004.setText("");
        textView005.setText("");
        textView006.setText("");
        textView007.setText("");
        imageView001.setImageResource(R.drawable.star);
        imageView002.setImageResource(R.drawable.star);
        imageView003.setImageResource(R.drawable.star);
        imageView004.setImageResource(R.drawable.star);
        imageView005.setImageResource(R.drawable.star);
        imageView006.setImageResource(R.drawable.star);
        imageView007.setImageResource(R.drawable.star);
        imageView008.setImageResource(R.drawable.trophy1);

        TextView textweek = (TextView)findViewById(R.id.week2);
        int blue = Color.parseColor("#024556");
        textweek.setTextColor(blue);

        TextView textweek1 = (TextView)findViewById(R.id.week3);
        textweek1.setTextColor(blue);
        TextView textweek2 = (TextView)findViewById(R.id.week4);
        textweek2.setTextColor(blue);

        ImageView sidebar = (ImageView)findViewById(R.id.sidebar4);
        sidebar.setImageResource(R.drawable.sidebar);
    }


}
