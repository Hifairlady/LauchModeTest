package com.edgar.lauchmodetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StandardActivity extends AppCompatActivity {

    private String currentInfoString;
    private String lastInfoString = "";
    private TextView tvInfo;
    private String TAG = "===================";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        lastInfoString = DeliverString.getInstance().getDeliverString();
        DeliverString.getInstance().setDeliverString(lastInfoString + "Standard>");
        currentInfoString = DeliverString.getInstance().getDeliverString();
        Log.d(TAG, "onCreate: " + currentInfoString);
        initUI();

    }

    private void initUI() {

        ((Button)findViewById(R.id.btn_standard)).setOnClickListener(mOnClickListener);
        ((Button)findViewById(R.id.btn_single_instance)).setOnClickListener(mOnClickListener);
        ((Button)findViewById(R.id.btn_single_task)).setOnClickListener(mOnClickListener);
        ((Button)findViewById(R.id.btn_single_top)).setOnClickListener(mOnClickListener);

        tvInfo = (TextView)findViewById(R.id.tv_information);
        tvInfo.setText("Info: " + currentInfoString);

    }

    @Override
    protected void onDestroy() {
        int startPos = 0;
        int endPos = currentInfoString.lastIndexOf("Standard");
        Log.d(TAG, "onDestroy: " + currentInfoString);
        Log.d(TAG, "onDestroy: length " + currentInfoString.length() + " endpos: " + endPos);
        currentInfoString = currentInfoString.substring(startPos, endPos);
        DeliverString.getInstance().setDeliverString(currentInfoString);
        super.onDestroy();
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.btn_single_instance:
                    Intent intent1 = new Intent(StandardActivity.this, SingleInstanceActivity.class);
                    startActivity(intent1);
                    break;

                case R.id.btn_single_task:
                    Intent intent2 = new Intent(StandardActivity.this, SingleTaskActivity.class);
                    startActivity(intent2);
                    break;

                case R.id.btn_single_top:
                    Intent intent3 = new Intent(StandardActivity.this, SingleTopActivity.class);
                    startActivity(intent3);
                    break;

                case R.id.btn_standard:
                    Intent intent4 = new Intent(StandardActivity.this, StandardActivity.class);
                    startActivity(intent4);
                    break;

                default:
                    break;
            }
        }
    };
}
