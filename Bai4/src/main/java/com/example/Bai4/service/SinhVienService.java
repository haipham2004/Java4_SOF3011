package com.example.Bai4.service;

import com.example.Bai4.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    private List<SinhVien> listSV = new ArrayList<>();

    public SinhVienService() {
        listSV.add(new SinhVien("SV01", "Hải", 19, "Ninh Bình", true));
        listSV.add(new SinhVien("SV02", "Khanh", 19, "Ninh Bình", true));
        listSV.add(new SinhVien("SV03", "Tâm", 19, "Nghệ An", false));
        listSV.add(new SinhVien("SV01", "Ngân", 19, "Hà Tĩnh", false));
        listSV.add(new SinhVien("SV04", "Quang", 19, "Ninh Bình", true));
    }

    public List<SinhVien> getAll() {
        return listSV;
    }

    public SinhVien getOne(String mssv) {
        for (SinhVien sv : listSV) {
            if (sv.getMaSoSinhVien().equals(mssv)) {
                return sv;
            }
        }
        return null;
    }

    public void addSinhVien(SinhVien sv) {
        listSV.add(sv);
    }

    public void deleteSinhVien(String mssv) {
        for (int i = 0; i < listSV.size(); i++) {
            if (listSV.get(i).getMaSoSinhVien().equalsIgnoreCase(mssv))
                listSV.remove(i);
        }
    }


}
