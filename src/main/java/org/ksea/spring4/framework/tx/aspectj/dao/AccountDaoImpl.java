package org.ksea.spring4.framework.tx.aspectj.dao;

import org.ksea.spring4.framework.tx.aspectj.model.Account;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by mexican on 2017/4/8.
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    public void insertAccount(Account account) {
        this.getJdbcTemplate().update("insert into account(name,balance)VALUES (?,?)", account.getName(), account.getBalance());
    }

    public void updateAccount(String accountName, double money, boolean isBuy) {
        String sql = "UPDATE account SET  balance=balance+? WHERE  NAME =?";
        if (isBuy) {
            sql = "UPDATE account SET  balance=balance-? WHERE  NAME =?";
        }
        this.getJdbcTemplate().update(sql, money, accountName);

    }
}
