package com.himanshu.wallpaper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import java.util.Collections;

public class MainActivity extends AppCompatActivity
{
    // initialize variable
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView naviagtionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign variable
        drawerLayout = findViewById(R.id.drawer_layout);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        toggle = new ActionBarDrawerToggle(this , drawerLayout , toolbar , R.string.open , R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        naviagtionView = findViewById(R.id.nav_view);
        naviagtionView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
               int id = menuItem.getItemId();
               Fragment fragment = null;
               switch (id)
               {
                   case R.id.nav_photos:
                        fragment = new PhotosFragment();
                        loadFragment(fragment);
                       break;

                   case R.id.nav_collections:
                       fragment = new CollectionsFragment();
                       loadFragment(fragment);
                       break;

                   case R.id.nav_favorite:
                       fragment = new FavoriteFragment();
                       loadFragment(fragment);
                       break;

                   default:
                       return true;
               }

               return true;
            }
        });
    }


    public void loadFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame , fragment).commit();

        drawerLayout.closeDrawer(GravityCompat.START);
        fragmentTransaction.addToBackStack(null);
    }

//    public void ClickMenu(View view)
//    {
//        // open drawer
//        openDrawer(drawerLayout);
//    }
//
//    static void openDrawer(DrawerLayout drawerLayout)
//    {
//        // open drawer layout
//        drawerLayout.openDrawer(GravityCompat.START);
//    }
//
//    public void ClickLogo(View view)
//    {
//        // close drawer
//        closeDrawer(drawerLayout);
//    }
//
//    public static void closeDrawer(DrawerLayout drawerLayout)
//    {
//        // close drawer layout
//        // check condition
//        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//        }
//    }
//
//    public void ClickPhotos(View view)
//    {
//        // go to photos activity
//        redirectActivity(this , Photos.class);
//    }
//
//    public void ClickCollections(View view)
//    {
//        // redirect activity to collections
//        redirectActivity(this , Collections.class);
//    }
//
//    public void ClickFavorite(View view)
//    {
//        // redirect Activity to favorite
//        redirectActivity(this , Favorite.class);
//    }
//
//    public void ClickLogout(View view)
//    {
//        //close app
//        logout(this);
//    }
//
//    public static void logout(final Activity activity)
//    {
//        // initialize alert dialog box
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//
//        // set title
//        builder.setTitle("Logout");
//
//        // set message
//        builder.setMessage("Are you sure , you want to logout ?");
//
//        // positive yes button
//        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which)
//            {
//                // finish activity
//                activity.finishAffinity();
//
//                // exit app
//                System.exit(0);
//            }
//        });
//
//        // negative no button
//        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which)
//            {
//                // Dismiss dialog
//                dialog.dismiss();
//            }
//        });
//
//        // show dialog
//        builder.show();
//
//    }
//    public static void redirectActivity(Activity activity , Class aClass)
//    {
//        // Intialize Intent
//        Intent intent = new Intent(activity , aClass);
//
//        // set flag
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//        // start activity
//        activity.startActivity(intent);
//    }
//
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        // close drawer
//        closeDrawer(drawerLayout);
//    }
}