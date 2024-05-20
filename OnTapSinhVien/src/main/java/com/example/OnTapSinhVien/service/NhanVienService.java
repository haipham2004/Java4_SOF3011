package com.example.OnTapSinhVien.service;

import com.example.OnTapSinhVien.entity.NhanVien;
import com.example.OnTapSinhVien.response.NhanVienResponse;

import java.util.List;

public interface NhanVienService {

    public List<NhanVienResponse> getAll();

    public boolean add(NhanVien nhanVien);

    public boolean update(NhanVien nhanVien);

    public boolean delete(NhanVien nhanVien);
}
