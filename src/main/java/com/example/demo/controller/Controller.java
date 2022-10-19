package com.example.demo.controller;

import com.example.demo.entity.TbCustomerWallet;
import com.example.demo.server.TbCustomerWalletService;
import com.example.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/demo")
public class Controller {
    @Autowired
    private TbCustomerWalletService tbCustomerWalletService;
//查询钱包信息
    @RequestMapping("/query_money")
    public R<TbCustomerWallet> query(String userId){
        R<TbCustomerWallet> r = new R<>();
       r.setEntity(tbCustomerWalletService.queryObj(userId));
       return r;
    }
//消费
    @RequestMapping("/consume_money")
    public R<String> consumeMoney(@RequestParam("userId") String userId,@RequestParam("money") Integer money){
        R<String> r = new R<>();
        tbCustomerWalletService.consumeMoney(userId,money);
        r.setEntity("消费成功");
        return r;
    }

    @RequestMapping("/add_money")
    public R<String> addMoney(@RequestParam("userId") String userId,@RequestParam("money") Integer money){
        R<String> r = new R<>();
        tbCustomerWalletService.addMoney(userId,money);
        r.setEntity("退款成功");
        return r ;
    }

    @RequestMapping("/query_track")
    public R<List<TbCustomerWallet>> queryTrack(String userId){
        R<List<TbCustomerWallet>> r = new R<>();
        r.setEntity(tbCustomerWalletService.queryTrack(userId));
        return r;
    }
}
