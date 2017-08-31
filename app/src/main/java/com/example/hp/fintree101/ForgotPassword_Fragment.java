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
 * Created by hp on 8/31/2017.
 */

public class ForgotPassword_Fragment extends Fragment implements View.OnClickListener {
    View view;
    TextView back;
    FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       view= inflater.inflate(R.layout.forgotpassword_layout,container,false);
        init();
        sellisteners();
        return view;
    }

    private void sellisteners() {
        back.setOnClickListener(this);

    }

    private void init() {
        fragmentManager=getActivity().getFragmentManager();
        back=(TextView)view.findViewById(R.id.backToLoginBtn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.backToLoginBtn:fragmentManager.beginTransaction().replace(R.id.frameContainer,new Login_Fragment()).commit();
                break;
        }

    }
}
