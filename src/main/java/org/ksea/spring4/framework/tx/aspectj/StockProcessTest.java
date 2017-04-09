package org.ksea.spring4.framework.tx.aspectj;

import org.junit.Before;
import org.junit.Test;
import org.ksea.spring4.framework.tx.aspectj.ex.StockProcessException;
import org.ksea.spring4.framework.tx.aspectj.model.Account;
import org.ksea.spring4.framework.tx.aspectj.model.Stock;
import org.ksea.spring4.framework.tx.aspectj.service.StockProcessService;
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
                new ClassPathXmlApplicationContext("org/ksea/spring4/framework/tx/xml/spring-tx-config.xml");
       //stockProcessService = (StockProcessService) applicationContext.getBean("stockProcessService");
        //加入事务之后这里要使用事务的代理对象
        stockProcessService = (StockProcessService) applicationContext.getBean("stockProcessServiceProxy");

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
