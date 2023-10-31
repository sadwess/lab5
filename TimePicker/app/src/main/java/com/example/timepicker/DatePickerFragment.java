package com.example.timepicker.;


import static android.app.PendingIntent.getActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import android.widget.DatePicker;

import androidx.annotation.NonNull;

import com.example.timepicker.DialogFragment;
import com.example.timepicker.MainActivity;

import java.util.Calendar;


public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker.
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it.
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }


    public void onDateSet(DatePicker view, int year, int month, int day) {

        MainActivity activity = (MainActivity) getActivity();

        activity.processDatePickerResult(year, month, day);
    }

}