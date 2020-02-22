package com.tykamm.quiz;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlarmFragment extends Fragment {
TextView textView;
Button start,pause,stop,lap;
ListView listView;
long millisecondTime,startTime,timeBuff,updateTime=0L;
Handler handler;
int seconds,minutes,milliSeconds;
String[] listElements=new String[]{};
List<String> listElementArrayList;
ArrayAdapter<String> adapter;

    public Runnable runnable=new Runnable() {
        @Override
        public void run() {
            millisecondTime=SystemClock.uptimeMillis()-startTime;
            updateTime=timeBuff+millisecondTime;
            seconds=(int)(updateTime/1000);
            minutes=seconds/60;
            seconds=seconds%60;
            milliSeconds=(int)(updateTime%1000);
            textView.setText(""+minutes+":"+String.format("%02d",seconds)+":"+String.format("%02d",seconds));
            handler.postDelayed(this,0);
        }
    };

    public AlarmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_alarm, container, false);

        return view;
    }

}
