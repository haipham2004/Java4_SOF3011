package com.example.BTVN12c.service;

import com.example.BTVN12c.entity.SinhVien;

import java.util.List;

public interface SinhVienService {
    public List<SinhVien> getAll();

    public boolean add(SinhVien sv);

    public boolean update(SinhVien sv);

    public boolean delete(SinhVien sv);

    public SinhVien getOne(int ma);
}
