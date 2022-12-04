package com.deeplanguage;


import java.text.NumberFormat;
import java.util.logging.Logger;

/**
 * @Author: drainli
 **/
public class FormaterDemo {

    private static final Logger LOG = Logger.getLogger(FormaterDemo.class.getSimpleName()) ;

    public static void main(String[] args) {
        double salary = 5678.9 ;
        String formatSalary = NumberFormat.getCurrencyInstance().format(salary);
        LOG.info(formatSalary);
    }
}
