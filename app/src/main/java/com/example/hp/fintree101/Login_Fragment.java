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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.w3c.dom.Text;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by hp on 8/25/2017.
 */

public class Login_Fragment extends Fragment implements View.OnClickListener {
    TextView sign;
    TextView forgot;
    private static CheckBox show_hide_password;
    View view;
    LoginButton loginButton;
    CallbackManager callbackManager;
    private static FragmentManager fragmentManager;
    private static Animation shake;
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
        forgot.setOnClickListener(this);
        loginButton.setOnClickListener(this);

    }

    private void intit() {

        fragmentManager = getActivity().getFragmentManager();
        sign = (TextView) view.findViewById(R.id.createAccount);
        forgot=(TextView)view.findViewById(R.id.forgot_password);
        loginButton=(LoginButton)view.findViewById(R.id.login_button);
        show_hide_password=(CheckBox)view.findViewById(R.id.show_hide_password);
        callbackManager= CallbackManager.Factory.create();
        shake= AnimationUtils.loadAnimation(getActivity(),R.anim.shake);



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
                        Profile profile=Profile.getCurrentProfile();
                       /* if(profile!=null)
                        {
                            Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                            intent.putExtra("name",profile.getFirstName());
                            intent.putExtra("surname",profile.getLastName());
                            intent.putExtra("dp",profile.getProfilePictureUri(200,200).toString());
                            startActivity(intent);
                        }*/
                        Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                       startActivity(intent);

                        //nextActivity(profile);



                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });

                break;
            case R.id.forgot_password:fragmentManager.beginTransaction().replace(R.id.frameContainer,new ForgotPassword_Fragment()).commit();
                break;
        }
    }


}
