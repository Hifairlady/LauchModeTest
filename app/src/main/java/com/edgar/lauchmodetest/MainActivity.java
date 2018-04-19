package com.edgar.lauchmodetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String currentInfoString;
    private String lastInfoString = "";
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastInfoString = DeliverString.getInstance().getDeliverString();
        DeliverString.getInstance().setDeliverString(lastInfoString + "Main>");
        currentInfoString = DeliverString.getInstance().getDeliverString();
        initUI();
    }

    private void initUI() {

        ((Button)findViewById(R.id.btn_standard)).setOnClickListener(mOnClickListener);
        ((Button)findViewById(R.id.btn_single_instance)).setOnClickListener(mOnClickListener);
        ((Button)findViewById(R.id.btn_single_task)).setOnClickListener(mOnClickListener);
        ((Button)findViewById(R.id.btn_single_top)).setOnClickListener(mOnClickListener);

        tvInfo = (TextView)findViewById(R.id.tv_information);
        tvInfo.setText(currentInfoString);

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.btn_single_instance:
                    Intent intent1 = new Intent(MainActivity.this, SingleInstanceActivity.class);
                    intent1.putExtra("infoString", currentInfoString);
                    startActivity(intent1);
                    break;

                case R.id.btn_single_task:
                    Intent intent2 = new Intent(MainActivity.this, SingleTaskActivity.class);
                    intent2.putExtra("infoString", currentInfoString);
                    startActivity(intent2);
                    break;

                case R.id.btn_single_top:
                    Intent intent3 = new Intent(MainActivity.this, SingleTopActivity.class);
                    intent3.putExtra("infoString", currentInfoString);
                    startActivity(intent3);
                    break;

                case R.id.btn_standard:
                    Intent intent4 = new Intent(MainActivity.this, StandardActivity.class);
                    intent4.putExtra("infoString", currentInfoString);
                    startActivity(intent4);
                    break;

                default:
                    break;
            }
        }
    };

}
