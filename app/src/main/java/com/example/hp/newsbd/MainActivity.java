package com.example.hp.newsbd;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView textViewId, textViewId1;
    private ListView listView,mainListViewId;
    private WebView webView;
    private ImageView imageView;
    private int[] logo= {R.drawable.pro, R.drawable.mainlogo,R.drawable.ds,R.drawable.kk,R.drawable.somokal,R.drawable.janakantha,
                            R.drawable.inqilab,R.drawable.al,R.drawable.jugantor_logo};
    private int[] logoSports= {R.drawable.cricketlive, R.drawable.crickettournament,R.drawable.cricketnews,R.drawable.football,R.drawable.footballnews,R.drawable.hockey,
            R.drawable.tennis,R.drawable.olympic,R.drawable.golf};
    private int[] logoteach={R.drawable.pro,R.drawable.dshikkha,R.drawable.likhapora,R.drawable.pubuni,R.drawable.nuni,
                                R.drawable.opuni,R.drawable.campus,R.drawable.primary,R.drawable.edubarta};

    private int[] logoJobs={R.drawable.bank,R.drawable.govt,R.drawable.careers,R.drawable.chakri,R.drawable.bikkroy,R.drawable.newsjob,
                            R.drawable.engine,R.drawable.nonjob,R.drawable.privatejob};


    String[] webAddress, sportsItem, sportsWeb, teachItem,teachWeb, jobsItem, jobsWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        ///////////////

        textViewId=findViewById(R.id.textViewId);
        textViewId1=findViewById(R.id.textViewId1);
        listView=findViewById(R.id.listViewId);
        imageView=findViewById(R.id.imageId);
       // mainListViewId=findViewById(R.id.mainListViewId);
        ////////////////
        ///get Resources





        //////////////


        webAddress=getResources().getStringArray(R.array.webAddress);
        sportsItem=getResources().getStringArray(R.array.sportsItem);
        sportsWeb=getResources().getStringArray(R.array.sportsWeb);
        teachItem=getResources().getStringArray(R.array.teachItem);
        teachWeb=getResources().getStringArray(R.array.teachWeb);
        jobsItem=getResources().getStringArray(R.array.jobsItem);
        jobsWeb=getResources().getStringArray(R.array.jobshWeb);

        CustomAdapter adapter= new CustomAdapter (this, webAddress,logo );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=webAddress[position];
                Toast.makeText(MainActivity.this, "দয়া করে অপেক্ষা করুন ",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("loadWeb",value);
                startActivity(intent);
            }
        });
        //listView = getListView();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action

            CustomAdapter adapter= new CustomAdapter (this, webAddress,logo );
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String value=webAddress[position];
                    Toast.makeText(MainActivity.this, "দয়া করে অপেক্ষা করুন ",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("loadWeb",value);
                    startActivity(intent);
                }
            });



///////////////////////

        } else if (id == R.id.nav_gallery) {



            CustomAdapterTemp adapter= new CustomAdapterTemp (this, sportsWeb,logoSports,sportsItem );
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String value=sportsWeb[position];
                    Toast.makeText(MainActivity.this, "দয়া করে অপেক্ষা করুন ",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("loadWeb",value);
                    startActivity(intent);
                }
            });

                                            /*
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.view,R.id.textViewId,sportsItem);


            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String value=sportsWeb[position];
                    Toast.makeText(MainActivity.this, "দয়া করে অপেক্ষা করুন ",Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("loadWeb",value);
                    startActivity(intent);
                }
            });    */




            /*listView.setOnItemClickListener(ListView parent, View v, int position, long id) {
                Toast.makeText(this, "You have selected Item : " + position,
                        Toast.LENGTH_LONG).show();
            }  */


        } else if (id == R.id.nav_slideshow) {


            CustomAdapterTemp adapter= new CustomAdapterTemp (this, teachWeb,logoteach,teachItem );
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String value=teachWeb[position];
                    Toast.makeText(MainActivity.this, "দয়া করে অপেক্ষা করুন ",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("loadWeb",value);
                    startActivity(intent);
                }
            });

        } else if (id == R.id.nav_manage) {

            CustomAdapterTemp adapter = new CustomAdapterTemp(this, jobsWeb, logoJobs, jobsItem);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String value = jobsWeb[position];
                    Toast.makeText(MainActivity.this, "দয়া করে অপেক্ষা করুন ", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("loadWeb", value);
                    startActivity(intent);
                }
            });

        }
        else if (id == R.id.aboutAppId) {


                    Toast.makeText(MainActivity.this, "Thanks for using this App. This app can be help you" +
                            " get all bangla newspaper, jobs news, education news and sports news", Toast.LENGTH_LONG).show();



        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
