package com.tykamm.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BuQuiz(View view) {
        try{
            EditText edtusername=findViewById(R.id.edtusername);
            EditText edtphoneno=findViewById(R.id.edtphoneno);
            String username=edtusername.getText().toString();
            String phoneno=edtphoneno.getText().toString();
            int phonenumber=Integer.parseInt(phoneno);
            Button takeQuiz=(Button)view;
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"Something went wrong!",Toast.LENGTH_LONG).show();
        }


    }
}
