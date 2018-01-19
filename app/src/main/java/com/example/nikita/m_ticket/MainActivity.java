package com.example.nikita.m_ticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    Button btn;
    TextView t1;
    int Counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1= (EditText)findViewById(R.id.et1);
        et2= (EditText)findViewById(R.id.et2);
        btn= (Button)findViewById(R.id.btn);
        t1= (TextView) findViewById(R.id.t1);
        t1.setText("No. of incorrect attempts: 5");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               validate(et1.getText().toString(),et2.getText().toString());
            }
        });
    }

    public void validate(String userName,String userPassword)
    {
        if((userName == "admin" ) && (userPassword =="123456"))
        {
            Intent intent1 = new Intent(MainActivity.this , SecondActivity.class);
            startActivity(intent1);
        }
        else
        {
            Counter++;

            t1.setText("No. of attempts: "+String.valueOf(Counter));

            if (Counter==0)
            {
             btn.setEnabled(false);
            }
        }
    }
}
