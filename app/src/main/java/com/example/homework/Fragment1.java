package com.example.homework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    EditText edit1, edit2;
//    DatePicker date;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1,container, false);
        edit1 = rootView.findViewById(R.id.edit1);
        edit2 = rootView.findViewById(R.id.edit2);
//        date = rootView.findViewById(R.id.date);
        Button btn = rootView.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "이름: "+edit1.getText().toString()+", "+"나이: "+edit2.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }
}
