package com.example.quanlynhathuoc;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class nhaThuocAdapter  extends ArrayAdapter<nhaThuoc> {
    Context context;
    int layoutResourceId;
    ArrayList<nhaThuoc> data = null;

    public nhaThuocAdapter(Context context, int layoutResourceId, ArrayList<nhaThuoc> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }
    static class nhaThuocHolder
    {
        TextView edtMaNT,edtTenNT,edtDiaChi;
        Button btnXoa;
    }
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        nhaThuocHolder holder = null;
        if(row!=null)
        {
            holder = (nhaThuocHolder) row.getTag();
        }
        else
        {
            holder = new nhaThuocHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.listviewnhathuoc,parent,false);
            holder.edtMaNT = row.findViewById(R.id.listMaNT);
            holder.edtTenNT = row.findViewById(R.id.listTenNT);
            holder.edtDiaChi = row.findViewById(R.id.listDiaChi);
            row.setTag(holder);
        }
        final nhaThuoc nt = data.get(position);
        holder.edtMaNT.setText(nt.getMaNT());
        holder.edtTenNT.setText(nt.getTenNT());
        holder.edtDiaChi.setText(nt.getDiaChi());
        return row;
    }
}
