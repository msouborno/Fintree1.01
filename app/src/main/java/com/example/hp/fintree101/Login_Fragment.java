package com.example.hp.fintree101;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hp on 8/25/2017.
 */

public class Login_Fragment extends Fragment implements View.OnClickListener {
    TextView sign;
    View view;
    private static FragmentManager fragmentManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view= inflater.inflate(R.layout.login_layout,container,false);
        intit();
        setListeners();
        return view;
    }

    private void setListeners() {
        sign.setOnClickListener(this);

    }

    private void intit() {
        fragmentManager = getActivity().getFragmentManager();
        sign = (TextView) view.findViewById(R.id.createAccount);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.createAccount:fragmentManager.beginTransaction().replace(R.id.frameContainer,new SignUp_Fragment()).commit();
                break;
        }
    }
}
