package com.example.OnTapDTO1s.service;

import com.example.OnTapDTO1s.entiy.Ban;
import com.example.OnTapDTO1s.response.BanResponse;

import java.util.List;

public interface BanService {

    public List<BanResponse> getAll();

    public Ban getOne(int id );

    public boolean add(Ban ban);

    public boolean update(Ban ban);

    public boolean delete(Ban ban);

}
