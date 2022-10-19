package com.example.demo.server;

import com.example.demo.entity.TbCustomerWallet;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TbCustomerWalletService extends IService<TbCustomerWallet>{
        TbCustomerWallet queryObj(String userId);

        void  consumeMoney(String userId,Integer money);

        void  addMoney(String userId,Integer money);

        List<TbCustomerWallet> queryTrack(String userId);
}
