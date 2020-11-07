package com.himanshu.wallpaper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    // initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view)
    {
        // open drawer
        openDrawer(drawerLayout);
    }

    static void openDrawer(DrawerLayout drawerLayout)
    {
        // open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view)
    {
        // close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout)
    {
        // close drawer layout
        // check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view)
    {
        // recreate Activity
        recreate();
    }

    public void ClickDashboard(View view)
    {
        // redirect activity to dashboard
        redirectActivity(this , Dashboard.class);
    }

    public void ClickAboutUs(View view)
    {
        // redirect Activity to about us
        redirectActivity(this , AboutUs.class);
    }

    public void ClickLogout(View view)
    {
        //close app
        logout(this);
    }

    public static void logout(final Activity activity)
    {
        // initialize alert dialog box
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        // set title
        builder.setTitle("Logout");

        // set message
        builder.setMessage("Are you sure , you want to logout ?");

        // positive yes button
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                // finish activity
                activity.finishAffinity();

                // exit app
                System.exit(0);
            }
        });

        // negative no button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                // Dismiss dialog
                dialog.dismiss();
            }
        });

        // show dialog
        builder.show();

    }
    public static void redirectActivity(Activity activity , Class aClass)
    {
        // Intialize Intent
        Intent intent = new Intent(activity , aClass);

        // set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // start activity
        activity.startActivity(intent);
    }


    @Override
    protected void onPause() {
        super.onPause();

        // close drawer
        closeDrawer(drawerLayout);
    }
}