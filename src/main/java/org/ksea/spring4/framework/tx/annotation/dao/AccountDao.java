package org.ksea.spring4.framework.tx.annotation.dao;

import org.ksea.spring4.framework.tx.annotation.model.Account;

/**
 * Created by mexican on 2017/4/8.
 */
public interface AccountDao {
    void insertAccount(Account account);

    void updateAccount(String accountName, double money, boolean isBuy);
}
