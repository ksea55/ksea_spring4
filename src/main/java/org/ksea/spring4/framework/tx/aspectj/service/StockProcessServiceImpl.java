package org.ksea.spring4.framework.tx.aspectj.service;

import org.ksea.spring4.framework.tx.aspectj.dao.AccountDao;
import org.ksea.spring4.framework.tx.aspectj.dao.StockDao;
import org.ksea.spring4.framework.tx.aspectj.ex.StockProcessException;
import org.ksea.spring4.framework.tx.aspectj.model.Account;
import org.ksea.spring4.framework.tx.aspectj.model.Stock;

/**
 * Created by mexican on 2017/4/8.
 */
public class StockProcessServiceImpl implements StockProcessService {

    private AccountDao accountDao;
    private StockDao stockDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    public void openAccount(Account account) {
        accountDao.insertAccount(account);
    }

    public void openStock(Stock stock) {
        stockDao.insertStock(stock);
    }

    /**
     * 该方法主要用与事务的观察
     *
     * @param accountName 账户
     * @param money       金额
     * @param stockName   股票名称
     * @param stockAmount 股票数量
     * @param isBuy       是否购买
     */
    public void stockProcess(String accountName, double money, String stockName, int stockAmount, boolean isBuy) throws StockProcessException {
        accountDao.updateAccount(accountName, money, isBuy);
        if (true) {
            //  throw new RuntimeException("股票交易发生异常!");
            throw new StockProcessException("股票交易发生异常!");
        }
        stockDao.updateStock(stockName, stockAmount, isBuy);
    }
}
