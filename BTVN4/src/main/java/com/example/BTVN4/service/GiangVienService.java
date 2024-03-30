package com.example.BTVN4.service;

import com.example.BTVN4.entity.GiangVien;

import java.util.ArrayList;
import java.util.List;

public class GiangVienService {
    private List<GiangVien> listGV=new ArrayList<>();

    public GiangVienService() {
        listGV.add(new GiangVien("ID01","Ma01","Phạm Ngọc Hải",19,true,"Ninh Bình"));
        listGV.add(new GiangVien("ID02","Ma02","Dương Kim Anh",19,false,"Hưng Yên"));
        listGV.add(new GiangVien("ID03","Ma03","Nguyễn Tuấn Khanh",19,true,"Ninh Bình"));
        listGV.add(new GiangVien("ID04","Ma04","Hoàng Minh Tâm",20,false,"Nghệ An"));
        listGV.add(new GiangVien("ID05","Ma05","Nguyễn Văn Quang",20,true,"Hưng Yên"));
        listGV.add(new GiangVien("ID06","Ma06","Nguyễn Văn Anh",20,true,"Hà Tĩnh"));
    }

    public List<GiangVien> getAll(){
       return listGV;
    }
    public GiangVien getOne(String id){
        for (GiangVien gv:listGV){
            if(gv.getID().equals(id)){
                return gv;
            }
        }
        return null;
    }
    public void addGiangVien(GiangVien gv){
        listGV.add(gv);
    }

    public List<GiangVien> search(String ten){
        List<GiangVien> listTenGv = new ArrayList<>();
        for (GiangVien gv : listGV) {
            if (gv.getTen().contains(ten) && gv.getTen() != null) {
                listTenGv.add(gv);
            }
        }
        return listTenGv;
    }

    public List<GiangVien> searchGiangVienNu(){
        List<GiangVien> listTenGv = new ArrayList<>();
        for (GiangVien gv : listGV) {
            if (gv.isGioiTinh()==false) {
                listTenGv.add(gv);
            }
        }
        return listTenGv;
    }

    public static void main(String[] args) {
        GiangVienService gvs=new GiangVienService();
        List<GiangVien> listTenGv=gvs.search("Phạm Ngọc Hải");
        for (GiangVien gv:listTenGv){
            System.out.println("Hi: "+gv);
        }
    }




}
