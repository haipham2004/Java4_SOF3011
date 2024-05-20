package com.example.OnTapXeMay.service;

import com.example.OnTapXeMay.entity.XeMay;
import com.example.OnTapXeMay.response.XeMayResponse;

import java.util.List;

public interface XeMayService {
    public List<XeMayResponse> getAll();

    public XeMay getOne(int id);

    public boolean add(XeMay xm);

    public boolean update(XeMay xm);

    public boolean delete(XeMay xm);
}
