package org.ksea.spring4.framework.tx.xml.service;

import org.ksea.spring4.framework.tx.xml.ex.StockProcessException;
import org.ksea.spring4.framework.tx.xml.model.Account;
import org.ksea.spring4.framework.tx.xml.model.Stock;

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
