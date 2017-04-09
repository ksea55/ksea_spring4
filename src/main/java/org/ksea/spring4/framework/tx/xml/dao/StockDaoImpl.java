package org.ksea.spring4.framework.tx.xml.dao;

import org.ksea.spring4.framework.tx.xml.model.Stock;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by mexican on 2017/4/8.
 */
public class StockDaoImpl extends JdbcDaoSupport implements StockDao {
    public void insertStock(Stock stock) {
        this.getJdbcTemplate().update("insert into stock(name,amount)VALUES (?,?)", stock.getName(), stock.getAmount());
    }

    public void updateStock(String stockName, int stockAmount, boolean isBuy) {
        String sql = "UPDATE stock SET  amount=amount-? WHERE  NAME =?";
        if (isBuy) {
            sql = "UPDATE stock SET  amount=amount+? WHERE  NAME =?";
        }
        this.getJdbcTemplate().update(sql, stockAmount, stockName);

    }
}
