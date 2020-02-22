package com.tykamm.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
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
            millisecondTime= SystemClock.uptimeMillis()-startTime;
            updateTime=timeBuff+millisecondTime;
            seconds=(int)(updateTime/1000);
            minutes=seconds/60;
            seconds=seconds%60;
            milliSeconds=(int)(updateTime%1000);
            textView.setText(""+minutes+":"+String.format("%02d",seconds)+":"+String.format("%02d",milliSeconds));
            handler.postDelayed(this,0);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

       textView=findViewById(R.id.text_view);
       start=findViewById(R.id.start_button);
       pause=findViewById(R.id.pause_button);
       stop=findViewById(R.id.stop_button);
       lap=findViewById(R.id.lap_button);
       listView=findViewById(R.id.list_view);
        handler=new Handler();

       /* listElementArrayList=new ArrayList<String>(Arrays.asList(listElements));
        adapter=new ArrayAdapter<String>(Main3Activity.this,R.layout.simple_list_item,listElementArrayList);
        listView.setAdapter(adapter);*/
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime= SystemClock.uptimeMillis();
                handler.postDelayed(runnable,0);
//                stop.setEnabled(false);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeBuff+=millisecondTime;
                handler.removeCallbacks(runnable);
                stop.setEnabled(true);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeBuff+=millisecondTime;
                handler.removeCallbacks(runnable);
                millisecondTime=0L;
                startTime=0L;
                timeBuff=0L;
                updateTime=0L;
                seconds=0;
                minutes=0;
                milliSeconds=0;
                textView.setText("00:00:00");
                listElementArrayList.clear();
                adapter.notifyDataSetChanged();

            }
        });

        lap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*listElementArrayList.add(textView.getText().toString());
                adapter.notifyDataSetChanged();*/
                ArrayList<String> list=new ArrayList<>();
                String item=textView.getText().toString();
                list.add(item);
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(Main3Activity.this,R.layout.simple_list_item,list);
                listView.setAdapter(adapter);
            }
        });



    }
}
