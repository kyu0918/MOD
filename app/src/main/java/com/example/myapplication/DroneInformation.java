package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DroneInformation extends AppCompatActivity {
    private Intent intent;
    private int number;
    private String title, content, price;
    private ImageView imageView;
    private TextView textView, textView1, textView2, textView3, textView4, textView5, textView6, textView7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drone_information);

        ImageButton back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DroneList.class);
                startActivity(intent);
            }
        });

        intent = getIntent();
        number = intent.getIntExtra("number", -1);
        title = intent.getStringExtra("title");
        content = intent.getStringExtra("content");
        price = intent.getStringExtra("price");

        imageView = findViewById(R.id.droneInfoImg);
        textView = findViewById(R.id.droneInfoName);
        textView1 = findViewById(R.id.droneInfoSize);
        textView2 = findViewById(R.id.droneInfoWeight);
        textView3 = findViewById(R.id.droneInfoFlyTime);
        textView4 = findViewById(R.id.droneInfoFlySpeed);
        textView5 = findViewById(R.id.droneInfoPrice);
        textView6 = findViewById(R.id.droneInfoState);
        textView7 = findViewById(R.id.droneInfoCamera);

        switch (number){
            case 0:
                imageView.setImageResource(R.drawable.real_drone_1);
                textView.setText("드론 명 : "+title);
                textView1.setText("크기 : 180 X 100 X 80");
                textView2.setText("무게 : "+content);
                textView3.setText("최대 비행시간 : 15분");
                textView4.setText("최대 비행속도 : 15m/s");
                textView5.setText("비용 : "+price);
                textView6.setText("드론상태 : 양호");
                textView7.setText("카메라 유무 : 없음");

                break;

            case 1:
                imageView.setImageResource(R.drawable.real_drone_2);
                textView.setText("드론 명 : "+title);
                textView1.setText("크기 : 160 X 95 X 75");
                textView2.setText("무게 : "+content);
                textView3.setText("최대 비행시간 : 10분");
                textView4.setText("최대 비행속도 : 10m/s");
                textView5.setText("비용 : "+price);
                textView6.setText("드론상태 : 양호");
                textView7.setText("카메라 유무 : 4K");

                break;

            case 2:
                imageView.setImageResource(R.drawable.real_drone_3);
                textView.setText("드론 명 : "+title);
                textView1.setText("크기 : 200 X 80 X 55");
                textView2.setText("무게 : "+content);
                textView3.setText("최대 비행시간 : 7분");
                textView4.setText("최대 비행속도 : 20m/s");
                textView5.setText("비용 : "+price);
                textView6.setText("드론상태 : 우수");
                textView7.setText("카메라 유무 : 4K");

                break;

            case 3:
                imageView.setImageResource(R.drawable.real_drone_4);
                textView.setText("드론 명 : "+title);
                textView1.setText("크기 : 100 X 40 X 45");
                textView2.setText("무게 : "+content);
                textView3.setText("최대 비행시간 : 12분");
                textView4.setText("최대 비행속도 : 30m/s");
                textView5.setText("비용 : "+price);
                textView6.setText("드론상태 : 양호");
                textView7.setText("카메라 유무 : 없음");

                break;
        }
    }
}