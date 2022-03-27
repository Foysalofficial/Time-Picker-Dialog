package com.foysaldev.timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    MaterialButton button;
    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.TextViewid);
        button = findViewById(R.id.Buttonid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePicker timePicker = new TimePicker(MainActivity.this);
                int currentHour = timePicker.getCurrentHour();
                int currentMinute = timePicker.getCurrentMinute();

                timePickerDialog = new TimePickerDialog(MainActivity.this,

                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                textView.setText(i+":"+i1);
                            }
                        }, currentHour,currentMinute,true);
                timePickerDialog.show();
            }
        });
    }
}