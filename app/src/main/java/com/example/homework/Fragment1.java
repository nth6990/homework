package com.example.homework;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.provider.ContactsContract;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fragment1 extends Fragment {
    EditText edit1, edit2;
//    DatePicker date;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1,container, false);
        edit1 = rootView.findViewById(R.id.edit1);
        edit2 = rootView.findViewById(R.id.edit2);
        final Button date = rootView.findViewById(R.id.date);
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(System.currentTimeMillis());
        date.setText(time);
        Button btn = rootView.findViewById(R.id.btn);
        final Calendar calendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String setTime= format.format(calendar.getTime());
                date.setText(setTime);
            }
        };
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), onDateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "이름: "+edit1.getText().toString()+", "+"나이: "+edit2.getText().toString()+", "+"생년월일: "+date.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }
}
