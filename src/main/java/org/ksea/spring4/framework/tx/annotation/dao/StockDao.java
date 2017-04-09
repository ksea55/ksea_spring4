package org.ksea.spring4.framework.tx.annotation.dao;

import org.ksea.spring4.framework.tx.annotation.model.Stock;

/**
 * Created by mexican on 2017/4/8.
 */
public interface StockDao {
    void insertStock(Stock stock);

    void updateStock(String stockName, int stockAmount, boolean isBuy);
}
