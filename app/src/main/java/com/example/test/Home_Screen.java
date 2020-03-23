package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.ManageAddresses.AddressList;
import com.example.test.ManageAddresses.ManageAddresses;
import com.example.test.OrderCart.Cart;
import com.example.test.adapter.PlansPagerAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;

public class Home_Screen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{


    TabLayout tab;
    ViewPager viewPager;
    Toolbar toolbar;
    EditText locationtext;
    TextView toolbarTitle;
    ArrayList<String> tabTitle = new ArrayList<>();
    ArrayList<HashMap<String,String>> cat_list = new ArrayList<>();
    private DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__screen);

        intent = getIntent();
        if(intent!=null)
        {

            try
            {
                cat_list = (ArrayList<HashMap<String, String>>) intent.getSerializableExtra("All_cat_list");
            }
            catch (Exception e)
            {

            }

        }
        init();

        tabTitle.clear();
        setSupportActionBar(toolbar);
        setupToolbar();

        if(cat_list.isEmpty())
        {

        }
        else
        {
            for (int l = 0; l < cat_list.size(); l++)
            {
                tab.addTab(tab.newTab().setText(cat_list.get(l).get("name")));
                tabTitle.add(cat_list.get(l).get("name"));
            }
        }

        PlansPagerAdapter adapter = new PlansPagerAdapter(getSupportFragmentManager(), tab.getTabCount(), tabTitle,cat_list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
    }


    public void setupToolbar() {
        drawerLayout = findViewById(R.id.drawer);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
    public void init()
    {

        tab = (TabLayout)findViewById(R.id.tabs);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        tab = (TabLayout)findViewById(R.id.tabs);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(Home_Screen.this);
        View header = navigationView.getHeaderView(0);
        //username=header.findViewById(R.id.header_title);
        //  user_image=header.findViewById(R.id.profileimage);


    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.about:
                Intent i = new Intent(this,AboutUs.class);
                onBackPressed();
                startActivity(i);

                Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact:
                Intent intent =new Intent(this,Contactus.class);
                onBackPressed();
                startActivity(intent);

                Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profile:
                Intent intent1 = new Intent(this,Customer_Profile.class);
                onBackPressed();
                startActivity(intent1);
                break;
            case R.id.address_book:
                Intent i3 = new Intent(this, AddressList.class);
                onBackPressed();
                startActivity(i3);
                break;
            case R.id.loginbtn:
                Intent i4 = new Intent(this,Login.class);
                onBackPressed();
                startActivity(i4);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.cart,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }


    }
}
