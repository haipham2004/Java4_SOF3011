package com.example.OnTapSinhVien.service.Imp;

import com.example.OnTapSinhVien.entity.NhanVien;
import com.example.OnTapSinhVien.repository.ChucVuRepository;
import com.example.OnTapSinhVien.repository.NhanVienRepository;
import com.example.OnTapSinhVien.response.NhanVienResponse;
import com.example.OnTapSinhVien.service.NhanVienService;

import java.util.List;

public class NhanVienServiceImp implements NhanVienService {
    NhanVienRepository repo=new NhanVienRepository();
    ChucVuRepository repo2=new ChucVuRepository();
    @Override
    public List<NhanVienResponse> getAll() {
        return repo.getAll();
    }

    @Override
    public boolean add(NhanVien nhanVien) {
        return false;
    }

    @Override
    public boolean update(NhanVien nhanVien) {
        return false;
    }

    @Override
    public boolean delete(NhanVien nhanVien) {
        return false;
    }
}
