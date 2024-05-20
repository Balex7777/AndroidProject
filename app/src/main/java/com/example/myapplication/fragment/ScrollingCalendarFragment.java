package com.example.myapplication.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScrollingCalendarFragment extends Fragment {

    private CalendarView calendarView;
    private EditText editText;
    private String stringDataSelected;
    private DatabaseReference databaseReference;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_scrolling_calendar, container, false);
        calendarView = view.findViewById(R.id.calendarView);
        editText = view.findViewById(R.id.editTextText);
        Button buttonSaveEvent = view.findViewById(R.id.button3);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                stringDataSelected = Integer.toString(year) + Integer.toString(month+1) + Integer.toString(dayOfMonth);
                calendarClicked();
            }
        });

        //databaseReference = FirebaseDatabase.getInstance().getReference("Calendar");


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");
        Log.d("ScrollingCalendarFragment", "test");
        buttonSaveEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSaveEvent(v);
            }
        });
        return view;
    }

    private void calendarClicked(){

    }

    public void buttonSaveEvent(View view){
        if (stringDataSelected != null && !stringDataSelected.isEmpty()) {
            String eventText = editText.getText().toString();
            Log.d("ScrollingCalendarFragment", "Saving event: " + eventText + " on date: " + stringDataSelected);
            databaseReference.child(stringDataSelected).setValue(eventText).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Log.d("ScrollingCalendarFragment", "Event saved successfully.");
                } else {
                    Log.e("ScrollingCalendarFragment", "Failed to save event.", task.getException());
                }
            }).addOnFailureListener(e -> {
                Log.e("ScrollingCalendarFragment", "Error: ", e);
            });
        } else {
            Log.e("ScrollingCalendarFragment", "Date not selected or invalid.");
        }
    }
}