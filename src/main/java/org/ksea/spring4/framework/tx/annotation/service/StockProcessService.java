package org.ksea.spring4.framework.tx.annotation.service;

import org.ksea.spring4.framework.tx.annotation.ex.StockProcessException;
import org.ksea.spring4.framework.tx.annotation.model.Account;
import org.ksea.spring4.framework.tx.annotation.model.Stock;

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
