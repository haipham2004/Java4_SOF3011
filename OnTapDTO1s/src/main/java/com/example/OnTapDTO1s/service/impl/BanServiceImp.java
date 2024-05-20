package com.example.OnTapDTO1s.service.impl;

import com.example.OnTapDTO1s.entiy.Ban;
import com.example.OnTapDTO1s.entiy.MoiQuanHe;
import com.example.OnTapDTO1s.repository.BanRepository;
import com.example.OnTapDTO1s.repository.MoiQuanHeRepository;
import com.example.OnTapDTO1s.request.BanRequest;
import com.example.OnTapDTO1s.response.BanResponse;
import com.example.OnTapDTO1s.service.BanService;

import java.util.List;

public class BanServiceImp implements BanService {
    BanRepository repo=new BanRepository();
    MoiQuanHeRepository repo2=new MoiQuanHeRepository();
    @Override
    public List<BanResponse> getAll() {
        return repo.getAll();
    }

    @Override
    public Ban getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(Ban ban) {
        return false;
    }

    @Override
    public boolean update(Ban ban) {
        return false;
    }

    @Override
    public boolean delete(Ban ban) {
        return repo.delete(ban);
    }

    public boolean addRequest(BanRequest banRequest){
        Ban ban=new Ban();
        ban.setMa(banRequest.getMa());
        ban.setTen(banRequest.getTen());
        ban.setSoThich(banRequest.getSoThich());
        ban.setGioiTinh(banRequest.isGioiTinh());
        MoiQuanHe mqh=repo2.getOne(banRequest.getIdMoiQuanHe());
        ban.setMoiQuanHe(mqh);
        return repo.add(ban);
    }

    public boolean updateRequest(BanRequest banRequest){
        Ban ban=new Ban();
        ban.setId(banRequest.getId());
        ban.setMa(banRequest.getMa());
        ban.setTen(banRequest.getTen());
        ban.setSoThich(banRequest.getSoThich());
        ban.setGioiTinh(banRequest.isGioiTinh());
        MoiQuanHe mqh=repo2.getOne(banRequest.getIdMoiQuanHe());
        ban.setMoiQuanHe(mqh);
        return repo.add(ban);
    }
}
