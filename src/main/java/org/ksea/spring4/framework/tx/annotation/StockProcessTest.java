package org.ksea.spring4.framework.tx.annotation;

import org.junit.Before;
import org.junit.Test;
import org.ksea.spring4.framework.tx.annotation.ex.StockProcessException;
import org.ksea.spring4.framework.tx.annotation.model.Account;
import org.ksea.spring4.framework.tx.annotation.model.Stock;
import org.ksea.spring4.framework.tx.annotation.service.StockProcessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mexican on 2017/4/8.
 */
public class StockProcessTest {
    private StockProcessService stockProcessService;

    @Before
    public void before() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("org/ksea/spring4/framework/tx/annotation/spring-tx-config.xml");
       //已经采用注解方式来管理事务
        stockProcessService = (StockProcessService) applicationContext.getBean("stockProcessService");


    }

    @Test
    public void openAccountTest() {
        stockProcessService.openAccount(new Account("mexican", 10000));
    }

    @Test
    public void openStockTest() {
        stockProcessService.openStock(new Stock("alibaba", 100));
    }

    @Test
    public void stockProcessTest() throws StockProcessException {
        stockProcessService.stockProcess("mexican", 2000, "alibaba", 200, true);
    }
}
