package com.example.blockhunter;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;


public class LocationRequisition {
    private String locationString;
    private FusedLocationProviderClient client;
    Context context; //need to set context

    public LocationRequisition() {
        client = LocationServices.getFusedLocationProviderClient(context);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        //having issues with this section
        //Looking at https://www.youtube.com/watch?v=XQJiiuk8Feo
    /*    client.getLastLocation().addOnSuccessListener(context, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                locationString = location; //wrong
            }
        });*/
    }

    private void getLocation() {

    }





}
