package com.android.buffer.smsauth;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            //do nothing here for now
        } else {
            openFragment(SmsSendFragment.getInstance());
        }
    }

    private void openFragment(Fragment fragment) {
        //here open the fragment
        getFragmentManager().beginTransaction().replace(R.id.frameLayoutContainer, fragment).commit();
    }
}
