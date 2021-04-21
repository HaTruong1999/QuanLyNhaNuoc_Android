package com.example.quanlynhathuoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnMoThuoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frmmain);
        setControl();
        setEvent();
    }

    private void setControl() {
        btnMoThuoc = findViewById(R.id.btnMoThuoc);
    }
    private void  setEvent()
    {
        btnMoThuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, nhaThuocActivity.class);
                startActivity(intent);
            }
        });
    }
}