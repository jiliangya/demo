package com.example.demo.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.TbCustomerWalletMapper;
import com.example.demo.server.TbCustomerWalletService;
import org.springframework.stereotype.Service;
import com.example.demo.entity.TbCustomerWallet;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.entity.TbCustomerWallet.*;

@Service
public class TbCustomerWalletServiceImpl extends ServiceImpl<TbCustomerWalletMapper, TbCustomerWallet> implements TbCustomerWalletService {

    @Override
    public TbCustomerWallet queryObj(String userId) {
        QueryWrapper<TbCustomerWallet> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(COL_C_USER_ID,userId);
        queryWrapper.eq(COL_C_NEW_FLAG,"1");
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void consumeMoney(String userId, Integer money) {
        QueryWrapper<TbCustomerWallet> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(COL_C_USER_ID,userId);
        queryWrapper.eq(COL_C_NEW_FLAG,"1");
        TbCustomerWallet tbCustomerWallet = baseMapper.selectOne(queryWrapper);
        Integer balance = tbCustomerWallet.getNBalance();
        Integer nVersions = tbCustomerWallet.getNVersions();
        tbCustomerWallet.setCNewFlag("0");
        //更新原来的钱包信息为旧数据
        baseMapper.updateById(tbCustomerWallet);
        tbCustomerWallet.setCPkId(null);
        tbCustomerWallet.setNBalance(balance-money);
        tbCustomerWallet.setCNewFlag("1");
        tbCustomerWallet.setNVersions(nVersions+1);
        //插入新的钱包数据
        baseMapper.insert(tbCustomerWallet);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addMoney(String userId, Integer money) {
        QueryWrapper<TbCustomerWallet> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(COL_C_USER_ID,userId);
        queryWrapper.eq(COL_C_NEW_FLAG,"1");
        TbCustomerWallet tbCustomerWallet = baseMapper.selectOne(queryWrapper);
        Integer balance = tbCustomerWallet.getNBalance();
        Integer nVersions = tbCustomerWallet.getNVersions();
        tbCustomerWallet.setCNewFlag("0");
        //更新原来的钱包信息为旧数据
        baseMapper.updateById(tbCustomerWallet);
        tbCustomerWallet.setCPkId(null);
        tbCustomerWallet.setNBalance(balance+money);
        tbCustomerWallet.setCNewFlag("1");
        tbCustomerWallet.setNVersions(nVersions+1);
        //插入新的钱包数据
        baseMapper.insert(tbCustomerWallet);
    }

    @Override
    public List<TbCustomerWallet> queryTrack(String userId) {
        QueryWrapper<TbCustomerWallet> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(COL_C_USER_ID,userId);
        queryWrapper.orderByDesc(COL_N_VERSIONS);
        List<TbCustomerWallet> tbCustomerWallets = baseMapper.selectList(queryWrapper);
        return tbCustomerWallets;
    }
}
