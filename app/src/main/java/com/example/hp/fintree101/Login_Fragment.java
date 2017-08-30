package com.example.hp.fintree101;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by hp on 8/25/2017.
 */

public class Login_Fragment extends Fragment implements View.OnClickListener {
    TextView sign;
    View view;
    LoginButton loginButton;
    CallbackManager callbackManager;
    private static FragmentManager fragmentManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FacebookSdk.sdkInitialize(getApplicationContext());
        view= inflater.inflate(R.layout.login_layout,container,false);
        intit();
        setListeners();
        return view;
    }

    private void setListeners() {
        sign.setOnClickListener(this);
        loginButton.setOnClickListener(this);

    }

    private void intit() {

        fragmentManager = getActivity().getFragmentManager();
        sign = (TextView) view.findViewById(R.id.createAccount);
        loginButton=(LoginButton)view.findViewById(R.id.login_button);
        callbackManager= CallbackManager.Factory.create();



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.createAccount:fragmentManager.beginTransaction().replace(R.id.frameContainer,new SignUp_Fragment()).commit();
                break;
            case R.id.login_button:
                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });

                break;
        }
    }
}
