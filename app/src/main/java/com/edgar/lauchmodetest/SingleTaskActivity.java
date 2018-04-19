package com.edgar.lauchmodetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SingleTaskActivity extends AppCompatActivity {

    private String currentInfoString;
    private String lastInfoString = "";
    private TextView tvInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);

        lastInfoString = DeliverString.getInstance().getDeliverString();
        DeliverString.getInstance().setDeliverString(lastInfoString + "SingleTask>");
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        int startPos = 0;
        int endPos = currentInfoString.lastIndexOf("SingleTask");
        currentInfoString = currentInfoString.substring(startPos, endPos);
        DeliverString.getInstance().setDeliverString(currentInfoString);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.btn_single_instance:
                    Intent intent1 = new Intent(SingleTaskActivity.this, SingleInstanceActivity.class);
                    intent1.putExtra("infoString", currentInfoString);
                    startActivity(intent1);
                    break;

                case R.id.btn_single_task:
                    Intent intent2 = new Intent(SingleTaskActivity.this, SingleTaskActivity.class);
                    intent2.putExtra("infoString", currentInfoString);
                    startActivity(intent2);
                    break;

                case R.id.btn_single_top:
                    Intent intent3 = new Intent(SingleTaskActivity.this, SingleTopActivity.class);
                    intent3.putExtra("infoString", currentInfoString);
                    startActivity(intent3);
                    break;

                case R.id.btn_standard:
                    Intent intent4 = new Intent(SingleTaskActivity.this, StandardActivity.class);
                    intent4.putExtra("infoString", currentInfoString);
                    startActivity(intent4);
                    break;

                default:
                    break;
            }
        }
    };
}
