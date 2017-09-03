package com.android.buffer.smsauth;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class SmsSendFragment extends Fragment implements View.OnClickListener {

    private EditText editTextPhone;

    public static SmsSendFragment getInstance() {
        return new SmsSendFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_sms_send, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppCompatImageButton appCompatImageButton = view.findViewById(R.id.imageViewSend);
        editTextPhone = view.findViewById(R.id.editTextPhone);
        setButtonListener(appCompatImageButton);
    }


    private void setButtonListener(AppCompatImageButton appCompatImageButton) {
        //set the button onclick listener
        appCompatImageButton.setOnClickListener(this);
    }

    private boolean validate(int length) {
        //validate the phone number length
        if (length < 10) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onClick(View view) {
        //here handle the button click
        if (validate(editTextPhone.length())) {
            getFragmentManager().
                    beginTransaction().
                    replace(R.id.frameLayoutContainer, SmsAuthFragment.getInstance(editTextPhone.getText().toString())).
                    addToBackStack(SmsAuthFragment.class.getCanonicalName()).
                    commit();
        } else {
            Toast.makeText(getActivity(), R.string.text_phone_valid, Toast.LENGTH_SHORT).show();
        }
    }
}
