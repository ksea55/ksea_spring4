package org.ksea.spring4.framework.tx.annotation.service;

import org.ksea.spring4.framework.tx.annotation.dao.AccountDao;
import org.ksea.spring4.framework.tx.annotation.dao.StockDao;
import org.ksea.spring4.framework.tx.annotation.ex.StockProcessException;
import org.ksea.spring4.framework.tx.annotation.model.Account;
import org.ksea.spring4.framework.tx.annotation.model.Stock;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    /*此处通过注解的方式来管理事务,声明式事务
    * isolation = Isolation.DEFAULT 声明事务的隔离级别这也是spring的默认级别
    * propagation = Propagation.REQUIRED 声明事务的传播行为
    * rollbackFor = {Exception.class} 声明事务回滚的异常
    * */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public void stockProcess(String accountName, double money, String stockName, int stockAmount, boolean isBuy) throws StockProcessException {
        accountDao.updateAccount(accountName, money, isBuy);
        if (true) {
            //  throw new RuntimeException("股票交易发生异常!");
            throw new StockProcessException("股票交易发生异常!");
        }
        stockDao.updateStock(stockName, stockAmount, isBuy);
    }
}
