package com.example.BTVN6.service;

import com.example.BTVN6.entity.GiangVien;

import java.util.ArrayList;
import java.util.List;

public class GiangVienService {
    private List<GiangVien> listGV = new ArrayList<>();

    public GiangVienService() {
        listGV.add(new GiangVien("GV01", "Nguyễn Thuý Hằng", 22, "Hà Nội"));
        listGV.add(new GiangVien("GV02", "Phạm Ngọc Hải", 19, "Ninh Bình"));
        listGV.add(new GiangVien("GV03", "Nguyễn Tuấn Khanh", 25, "Ninh Bình"));
        listGV.add(new GiangVien("GV04", "Nguyễn Văn Quang", 19, "27"));
        listGV.add(new GiangVien("GV05", "Nguyễn Linh Phương", 19, "Hà Tĩnh"));
    }

    public List<GiangVien> getAll() {
        return listGV;
    }

    public void addGiangVien(GiangVien gv) {
        listGV.add(gv);
    }

    public GiangVien updateGiangVien(GiangVien gvUpdate) {
        for (GiangVien gv : listGV) {
            if (gv.getMaGV().equalsIgnoreCase(gvUpdate.getMaGV())) {
                gv.setTen(gvUpdate.getTen());
                gv.setTuoi(gvUpdate.getTuoi());
                gv.setQueQuan(gvUpdate.getQueQuan());
                return gv;
            }
        }
        return null;
    }

    public void deleteGiangVien(String maGV) {
        for (int i = 0; i < listGV.size(); i++) {
            if (listGV.get(i).getMaGV().equals(maGV)) {
                listGV.remove(i);
            }
        }
    }

    public GiangVien getOne(String maGV) {
        for (GiangVien gv : listGV) {
            if (gv.getMaGV().equalsIgnoreCase(maGV)) {
                return gv;
            }
        }
        return null;
    }

    public List<GiangVien> timKiem(String ten, int tuoiMin, int tuoiMax) {
        List<GiangVien> listTam = new ArrayList<>();
        for (GiangVien gv : listGV) {
            if (gv.getTen().contains(ten) && gv.getTuoi() >= tuoiMin && gv.getTuoi() <= tuoiMax) {
                listTam.add(gv);
            }
        }
        return listTam;
    }

    public static void main(String[] args) {
        GiangVienService gvs = new GiangVienService();
        List<GiangVien> list = gvs.timKiem("Phạm Ngọc Hải", 0, 19);
        for (GiangVien gv : list) {
            System.out.println("hi: " + gv);
        }

    }
}
