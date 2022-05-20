package com.example.applet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity { //main program


    @Override //check the error first
    protected void onCreate(Bundle savedInstanceState) { //function for create the program
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //link with activity_main.xml, show content inside it
    }

    protected void onStart(){ //function when the program is about to display
        super.onStart();
        setContentView(R.layout.activity_main);
    }

    protected void onResume(){ //function when the program is become display
        super.onResume();
        setContentView(R.layout.activity_menu);//show the menu page for the app
    }
    public void ChangePage(View view){
        setContentView(R.layout.activity_menu);//when button is pressed, change the page to home
    }
    public void ChangePage2(View view){
        setContentView(R.layout.activity_profile);
    }
    public void ChangePage3(View view){
        setContentView(R.layout.activity_news);
    }

    public void hourCalendar(View view){
        setContentView(R.layout.activity_hourcalendar);

    }

    protected void onPause(){  //function when other activity is taking focus
        super.onPause();
    }

    protected void onStop(){ //function when the program is invisiable
        super.onStop();
    }

    protected void onDestroy(){  //function before kill the activity
        super.onDestroy();
    }
}

class calendar extends AppCompatActivity{

    private  static final String TAG = "Calendar";

    protected void calendarA(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourcalendar);
        CalendarView mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener((CalendarView, year, month, dayOfMonth) -> {
            String date = 2022 + "/" + 5 + "/"+ 31 ;
            Log.d(TAG, "onSelectedDayChange: yyyy/mm/dd:" + date);
            Intent intent = new Intent(calendar.this,MainActivity.class);
            intent.putExtra("date",date);
            startActivity(intent);
        });
    }
}