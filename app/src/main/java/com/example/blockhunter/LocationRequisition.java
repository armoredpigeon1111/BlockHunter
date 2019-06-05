package com.example.blockhunter;

import android.Manifest;
import android.app.Activity;
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
    Context context;

    public LocationRequisition() {

    }
    public String getLocation(){
        client = LocationServices.getFusedLocationProviderClient(context);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return "";
        }
        //having issues with this section
        //Looking at https://www.youtube.com/watch?v=XQJiiuk8Feo
        client.getLastLocation().addOnSuccessListener((Activity) context, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                locationString = Location.convert(location.getLatitude(), Location.FORMAT_DEGREES) +
                        " " + Location.convert(location.getLongitude(), Location.FORMAT_DEGREES);
                System.out.println(locationString);
            }
        });
        return locationString;
    }
    public static String locationStringFromLocation(final Location location) {
        return Location.convert(location.getLatitude(), Location.FORMAT_DEGREES) + " "
                + Location.convert(location.getLongitude(), Location.FORMAT_DEGREES);
    }






}
