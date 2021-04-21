package com.example.quanlynhathuoc;

public class nhaThuoc {
    private String MaNT, TenNT, diaChi;

    public nhaThuoc(String maNT, String tenNT, String diaChi) {
        MaNT = maNT;
        TenNT = tenNT;
        this.diaChi = diaChi;
    }

    public nhaThuoc() {
    }

    public String getMaNT() {
        return MaNT;
    }

    public void setMaNT(String maNT) {
        MaNT = maNT;
    }

    public String getTenNT() {
        return TenNT;
    }

    public void setTenNT(String tenNT) {
        TenNT = tenNT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
