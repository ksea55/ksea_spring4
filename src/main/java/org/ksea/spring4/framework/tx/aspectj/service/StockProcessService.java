package org.ksea.spring4.framework.tx.aspectj.service;

import org.ksea.spring4.framework.tx.aspectj.ex.StockProcessException;
import org.ksea.spring4.framework.tx.aspectj.model.Account;
import org.ksea.spring4.framework.tx.aspectj.model.Stock;

/**
 * Created by mexican on 2017/4/8.
 */
public interface StockProcessService {
    //开户银行
    void openAccount(Account account);

    //交易股票
    void openStock(Stock stock);

    //股票处理
    void stockProcess(String accountName, double money, String stockName, int stockAmount, boolean isBuy) throws StockProcessException;

}
