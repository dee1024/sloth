package com.dee;

import com.dee.generate.Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Created by dee on 16/6/16.
 */
public class Application {

    static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        String str = "-path/Users/dee/Downloads/Project -h127.0.0.1 -P3306 -uroot -p  -dgamesapi -strategyssm -packagecom.dee";
        String[] testargs = str.split(" ");
        Generator.execute(testargs);

    }

}
