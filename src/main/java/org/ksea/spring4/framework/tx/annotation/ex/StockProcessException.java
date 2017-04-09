package org.ksea.spring4.framework.tx.annotation.ex;

/**
 * Created by mexican on 2017/4/9.
 */
public class StockProcessException extends Exception {
    public StockProcessException() {
        super();
    }

    public StockProcessException(String message) {
        super(message);
    }
}
