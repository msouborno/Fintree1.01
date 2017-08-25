package com.example.hp.fintree101;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Login_Fragment login_fragment=new Login_Fragment();
        fragmentTransaction.add(R.id.frameContainer,login_fragment);
        fragmentTransaction.commit();
        log=(Button)findViewById(R.id.loginBtn);


    }
}
