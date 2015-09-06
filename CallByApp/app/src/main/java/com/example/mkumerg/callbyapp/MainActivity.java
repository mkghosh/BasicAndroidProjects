package com.example.mkumerg.callbyapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.et_call);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_call:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+tv.getText().toString()));
                startActivity(intent);
                break;
            case R.id.btn_camera:
                //Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Intent intent1 = getPackageManager().getLaunchIntentForPackage("com.android.camera");
                startActivity(intent1);
                break;
            case R.id.btn_contact:
                Intent intContact = getPackageManager().getLaunchIntentForPackage("com.android.contacts");
                startActivity(intContact);
                break;
            case R.id.btn_gallery:
                Intent intGallery = new Intent(Intent.ACTION_VIEW,Uri.parse("content://media/internal/images/media"));
                startActivity(intGallery);
                break;
            case R.id.btn_sms:
                Intent sendIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("sms:"));
                startActivity(sendIntent);
                break;
            case R.id.btn_gmail:
                Intent intGmail = getPackageManager().getLaunchIntentForPackage("com.android.email");
                startActivity(intGmail);
                break;
            case R.id.btn_facebook:
                Intent intFacebook = getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                startActivity(intFacebook);
                break;
        }

    }
}