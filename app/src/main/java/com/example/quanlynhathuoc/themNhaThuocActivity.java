package com.example.quanlynhathuoc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class themNhaThuocActivity extends AppCompatActivity {

    EditText edtmaNT, edtTenNT,edtDiaChi;
    Button btnXacNhanThemNT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frmthemnhathuoc);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnXacNhanThemNT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                NTNhap();
            }
        });
    }

    private void setControl() {
        btnXacNhanThemNT = findViewById(R.id.btnXacNhanThemNT);
        edtmaNT = findViewById(R.id.edtMaNhaThuoc);
        edtTenNT = findViewById(R.id.edtTenNhaThuoc);
        edtDiaChi = findViewById(R.id.edtDiaChi);
    }
    private void NTNhap() {
        database db = new database(this);
        nhaThuoc nt = getNhaThuoc();
        db.saveNhaThuoc(nt);
        edtmaNT.setText("aaa");
    }

    private nhaThuoc getNhaThuoc() {
        nhaThuoc nt = new nhaThuoc();
        nt.setMaNT(edtmaNT.getText().toString());
        nt.setTenNT(edtTenNT.getText().toString());
        nt.setDiaChi(edtDiaChi.getText().toString());
        return nt;

    }
}
