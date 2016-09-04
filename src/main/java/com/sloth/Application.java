package com.sloth;

import com.sloth.generate.Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Created by sloth on 16/6/16.
 */
public class Application {

    static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        if(args==null || args.length==0) {
            String str = "-path/Users/dee/Downloads/abcd/Projectdee -h127.0.0.1 -P3306 -uroot -p  -dgamesapi -strategyssm -packagecom.sloth";
            String[] testargs = str.split(" ");
            Generator.execute(testargs);
        }else{
            Generator.execute(args);
        }

    }

}
