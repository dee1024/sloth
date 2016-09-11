package com.github.coolcooldee.sloth;

import com.github.coolcooldee.sloth.generate.Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Dee1024
 * @since 16/6/16
 *
 */
public class Application {

    static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        if(args==null || args.length==0) {
            String str = "-path/Users/dee/Downloads/abcd/Projectdee -h127.0.0.1 -P3306 -uroot -p  -dtest -strategyssm -packagecom.sloth";
            String[] testargs = str.split(" ");
            Generator.execute(testargs);
            //throw new IllegalArgumentException();
        }else{
            Generator.execute(args);
        }

    }

}
