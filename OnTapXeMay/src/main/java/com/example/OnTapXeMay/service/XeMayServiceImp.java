package com.example.OnTapXeMay.service;

import com.example.OnTapXeMay.entity.LoaiXeMay;
import com.example.OnTapXeMay.entity.XeMay;
import com.example.OnTapXeMay.repository.LoaiXeMayRepository;
import com.example.OnTapXeMay.repository.XeMayRepository;
import com.example.OnTapXeMay.request.XeMayRequest;
import com.example.OnTapXeMay.response.XeMayResponse;

import java.util.List;

public class XeMayServiceImp implements XeMayService {
    XeMayRepository repo=new XeMayRepository();
    LoaiXeMayRepository repo2=new LoaiXeMayRepository();

    @Override
    public List<XeMayResponse> getAll() {
        return repo.getAll();
    }

    @Override
    public XeMay getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(XeMay xm) {
        return false;
    }

    @Override
    public boolean update(XeMay xm) {
        return false;
    }

    @Override
    public boolean delete(XeMay xm) {
        return repo.delete(xm);
    }

    public boolean addRequest(XeMayRequest xeMayRequest){
        XeMay xeMay=new XeMay();
        xeMay.setMa(xeMayRequest.getMa());
        xeMay.setTen(xeMayRequest.getTen());
        xeMay.setMoTa(xeMayRequest.getMoTa());
        xeMay.setSoLuong(xeMayRequest.getSoLuong());
        LoaiXeMay loaiXeMay=repo2.getOne(xeMayRequest.getIdLoaiXeMay());
        xeMay.setLoaiXeMay(loaiXeMay);
        return  repo.add(xeMay);
    }

    public boolean updateRequest(XeMayRequest xeMayRequest){
        XeMay xeMay=new XeMay();
        xeMay.setId(xeMayRequest.getId());
        xeMay.setMa(xeMayRequest.getMa());
        xeMay.setTen(xeMayRequest.getTen());
        xeMay.setMoTa(xeMayRequest.getMoTa());
        xeMay.setSoLuong(xeMayRequest.getSoLuong());
        LoaiXeMay loaiXeMay=repo2.getOne(xeMayRequest.getIdLoaiXeMay());
        xeMay.setLoaiXeMay(loaiXeMay);
        return  repo.update(xeMay);
    }
}
