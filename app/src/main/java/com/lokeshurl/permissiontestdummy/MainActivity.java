package com.lokeshurl.permissiontestdummy;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button mBTLocation;
    private Button mBTContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBTLocation = findViewById(R.id.bt_location);
        mBTContact = findViewById(R.id.bt_contact);

        mBTLocation.setOnClickListener(this);
        mBTContact.setOnClickListener(this);
    }

    @Override
    public void permissionGranted(String permission, int requestCode) {
        if (permission.equals(Manifest.permission.ACCESS_FINE_LOCATION) && requestCode == 10 )
            Toast.makeText(this, "Location permission granted", Toast.LENGTH_SHORT).show();
        if (permission.equals(Manifest.permission.READ_CONTACTS), && requestCode == 20)
            Toast.makeText(this, "Contact read permission granted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_location:
                requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, 10, 
                         "Please accept now location permissions",
                        "You denied permission of location, please accept in permissions settings page");
                break;
            case R.id.bt_contact:
                requestPermission(Manifest.permission.READ_CONTACTS, 20, 
                        "Please accept now contact permission",
                        "You denied permission of contact, please accept in permissions settings page");
                break;

        }
    }
}
