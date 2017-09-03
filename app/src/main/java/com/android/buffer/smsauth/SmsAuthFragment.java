package com.android.buffer.smsauth;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.android.buffer.smsauth.WebConstants.EXTRA_PHONE_NO;

public class SmsAuthFragment extends Fragment implements View.OnClickListener {

    private String phoneNo;
    private EditText editTextCode1, editTextCode2, editTextCode3, editTextCode4;
    private AppCompatImageButton buttonVerify;

    public static SmsAuthFragment getInstance(String phoneNo) {
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_PHONE_NO, phoneNo);
        SmsAuthFragment smsAuthFragment = new SmsAuthFragment();
        smsAuthFragment.setArguments(bundle);
        return smsAuthFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        phoneNo = getArguments().getString(EXTRA_PHONE_NO);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sms_auth, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);
        setListeners();
    }

    private void setListeners() {
        //here setting the listeners
        buttonVerify.setOnClickListener(this);

        editTextCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 1) {
                    editTextCode1.clearFocus();
                    editTextCode2.requestFocus();
                }
            }
        });
        editTextCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 1) {
                    editTextCode2.clearFocus();
                    editTextCode3.requestFocus();
                }
            }
        });
        editTextCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 1) {
                    editTextCode3.clearFocus();
                    editTextCode4.requestFocus();
                }
            }
        });
    }

    private void bindViews(View view) {
        //here initialize view components
        TextView textView = view.findViewById(R.id.textViewMsg);
        textView.setText(getString(R.string.text_enter_code, phoneNo));
        editTextCode1 = view.findViewById(R.id.editTextCode1);
        editTextCode2 = view.findViewById(R.id.editTextCode2);
        editTextCode3 = view.findViewById(R.id.editTextCode3);
        editTextCode4 = view.findViewById(R.id.editTextCode4);
        buttonVerify = view.findViewById(R.id.buttonVerify);
    }

    @Override
    public void onClick(View view) {
        //here handle the button click
        if (validate()) {
            Toast.makeText(getActivity(),"Valid code",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(),"Invalid code",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validate() {
        //validate the code input
        if (editTextCode1.length() == 0) {
            return false;
        } else if (editTextCode2.length() == 0) {
            return false;
        } else if (editTextCode3.length() == 0) {
            return false;
        } else if (editTextCode4.length() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
