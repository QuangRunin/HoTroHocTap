package com.adrnangcao.hotrohoctap.hotrohoctap;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import com.adrnangcao.hotrohoctap.hotrohoctap.khoahoc.KhoaHocActivity;
import com.adrnangcao.hotrohoctap.hotrohoctap.tintuc.TinTucActivity;
import com.facebook.CallbackManager;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HomeActivity extends AppCompatActivity {
    private ShareDialog shareDialog;
    private CallbackManager manager;
    String TAG = "LoginFaceActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        shareDialog = new ShareDialog(HomeActivity.this);
        manager = CallbackManager.Factory.create();
        manager = CallbackManager.Factory.create();
        shareDialog.registerCallback(manager, new FacebookCallback<Sharer.Result>() {
            @Override
            public void onSuccess(Sharer.Result result) {
                Toast.makeText(HomeActivity.this.getApplicationContext(), "Share success!", Toast.LENGTH_SHORT).show();
                Log.e(TAG,"Fb onSuccess");
            }

            @Override
            public void onCancel() {
                Toast.makeText(HomeActivity.this.getApplicationContext(), "Did not share", Toast.LENGTH_SHORT).show();
                Log.e(TAG,"Fb onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(HomeActivity.this.getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                Log.e(TAG,"Fb onError");
            }
        }, 90);


    }

    public void Khoahoc(View view) {
        Intent intent = new Intent(this,KhoaHocActivity.class);
        startActivity(intent);
    }

    public void Bando(View view) {
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }

    public void Tintuc(View view) {
        Intent intent = new Intent(this,TinTucActivity.class);
        startActivity(intent);
    }

    public void Xahoi(View view) {
        checkInternet();
    }
    private boolean checkInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager)HomeActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo ==null){
            final ProgressDialog progress = new ProgressDialog(HomeActivity.this);
            progress.setMessage("Không có kết nối mạng...");
            progress.setCancelable(true);
            progress.show();
            return false;
        }
        if(!networkInfo.isConnected()){
            final ProgressDialog progress = new ProgressDialog(HomeActivity.this);
            progress.setMessage("Không có kết nối mạng...");
            progress.setCancelable(true);
            progress.show();
            return false;
        }
        if(!networkInfo.isAvailable()){
            final ProgressDialog progress = new ProgressDialog(HomeActivity.this);
            progress.setMessage("Không có kết nối mạng...");
            progress.setCancelable(true);
            progress.show();
            return false;
        }
        else{
            ShareLinkContent content = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse("https://caodang.fpt.edu.vn/"))
                    .setQuote("FPT Polytechnic")
                    .build();
            shareDialog.show(content);
            return true;}
    }

}
