package com.example.hp.fintree101;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by hp on 8/25/2017.
 */

public class SignUp_Fragment extends Fragment implements View.OnClickListener {
    View v;
    TextView log;
    private  static FragmentManager fragmentManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.signup_layout,container,false);

       intit();
        setlisteners();
        return v;
    }

    private void setlisteners() {

        log.setOnClickListener(this);
    }

    private void intit() {
        fragmentManager=getActivity().getFragmentManager();
        log = (TextView) v.findViewById(R.id.already_user);

    }

    @Override
    public void onClick(View v) {


        switch (v.getId())
        {
            case R.id.already_user:fragmentManager.beginTransaction().replace(R.id.frameContainer,new Login_Fragment()).commit();
                break;
        }

    }
}
