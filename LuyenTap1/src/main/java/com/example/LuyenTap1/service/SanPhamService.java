package com.example.LuyenTap1.service;

import com.example.LuyenTap1.entity.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {
    private List<SanPham> listSP = new ArrayList<>();

    public SanPhamService() {
        listSP.add(new SanPham(1, "SP01", "Trứng", "Loại 1", 5000));
        listSP.add(new SanPham(2, "SP02", "Bánh đa", "Loại 2", 6000));
        listSP.add(new SanPham(3, "SP03", "Mì tôm", "Loại 3", 7000));
    }

    public List<SanPham> getAll() {
        return listSP;
    }

    public void themSP(SanPham sp) {
        listSP.add(sp);
    }

    public void suaSP(SanPham sp) {
        for (SanPham sps : listSP) {
            if (sps.getId() == sp.getId()) {
                sps.setMa(sp.getMa());
                sps.setTen(sp.getTen());
                sps.setLoai(sp.getLoai());
                sps.setGia(sp.getGia());
            }
        }
    }

    public void xoaSP(int id) {
        for (int i = 0; i < listSP.size(); i++) {
            if (listSP.get(i).getId() == id) {
                listSP.remove(i);
            }
        }
    }

    public SanPham getOne(int id) {
        for (SanPham sps : listSP) {
            if (sps.getId() == id) {
                return sps;
            }
        }
        return null;
    }
    public List<SanPham> listTim(String ten){
   List<SanPham> listSPTam = new ArrayList<>();
        for(SanPham sp:listSP){
            if(sp.getTen().equalsIgnoreCase(ten)){
                listSPTam.add(sp);
            }
        }
        return listSPTam;
    }
}
