package com.example.gpa_shresthaa1_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView gpaText, errorText;
    Button compute_gpa;
    EditText course1, course2, course3, course4, course5;

    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        errorText = (TextView) findViewById(R.id.errorText);
        gpaText = (TextView) findViewById(R.id.gpaText);

        course1 = (EditText) findViewById(R.id.course1);
        course2 = (EditText) findViewById(R.id.course2);
        course3 = (EditText) findViewById(R.id.course3);
        course4 = (EditText) findViewById(R.id.course4);
        course5 = (EditText) findViewById(R.id.course5);


        compute_gpa = (Button) findViewById(R.id.compute_gpa);
        compute_gpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float c1, c2, c3, c4, c5;
                if (count % 2 == 0) {
                    if (course1.getText().toString().equals("") ||
                            course2.getText().toString().equals("") ||
                            course3.getText().toString().equals("") ||
                            course4.getText().toString().equals("") ||
                            course5.getText().toString().equals("")) {
                        errorText.setText("Enter grades in all fields");
                    }
                    else {
                        c1 = Float.parseFloat(course1.getText().toString());
                        c2 = Float.parseFloat(course2.getText().toString());
                        c3 = Float.parseFloat(course3.getText().toString());
                        c4 = Float.parseFloat(course4.getText().toString());
                        c5 = Float.parseFloat(course5.getText().toString());
                        float avg = c1 + c2 + c3 + c4 + c5;
                        avg = avg / 5;
                        if (avg < 60) {
                            gpaText.setText(Float.toString(avg));
                            ScrollView activity_main = (ScrollView) findViewById(R.id.activity_main);
                            activity_main.setBackgroundColor(Color.RED);
                        } else if (avg > 60 && avg < 80) {
                            gpaText.setText(Float.toString(avg));
                            ScrollView activity_main = (ScrollView) findViewById(R.id.activity_main);
                            activity_main.setBackgroundColor(Color.YELLOW);
                        } else if (avg >= 80 && avg <= 100) {
                            gpaText.setText(Float.toString(avg));
                            ScrollView activity_main = (ScrollView) findViewById(R.id.activity_main);
                            activity_main.setBackgroundColor(Color.GREEN);
                        }
                        count++;
                        compute_gpa.setText("Clear");
                    }

                }
                else
                {
                    course1.setText("");
                    course2.setText("");
                    course3.setText("");
                    course4.setText("");
                    course5.setText("");
                    gpaText.setText("");
                    compute_gpa.setText("Compute GPA");
                    gpaText.setBackgroundColor(Color.WHITE);
                    count++;
                }
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(getApplicationContext(), "Portrait Mode", Toast.LENGTH_SHORT).show();
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getApplicationContext(), "Landscape Mode", Toast.LENGTH_SHORT).show();
        }
    }
}




