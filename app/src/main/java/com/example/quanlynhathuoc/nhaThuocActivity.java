package com.example.quanlynhathuoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class nhaThuocActivity extends AppCompatActivity {
    Button NT_btnThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frmnhathuoc);
        setControl();
        setEvent();
    }

    private void setControl() {
        NT_btnThem = findViewById(R.id.NT_btnThem);
    }

    private void setEvent() {

        NT_btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nhaThuocActivity.this, themNhaThuocActivity.class);
                startActivity(intent);
            }
        });
    }
}
