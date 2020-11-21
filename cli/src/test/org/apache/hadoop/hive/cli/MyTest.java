package org.apache.hadoop.hive.cli;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.Driver;
import org.apache.hadoop.hive.ql.session.SessionState;

/**
 * Created by angel
 */
public class MyTest {
    public static void main(String[] args) {
        Driver driver = createDriver();
        int ret = driver.compile("select * from v1 as a join v1 as b on (a.i = b.i)");
    }
    private static Driver createDriver() {
        HiveConf conf = new HiveConf(Driver.class);
//        conf.setVar(HiveConf.ConfVars.SEMANTIC_ANALYZER_HOOK,
//                CheckInputReadEntityDirect.class.getName());
//        HiveConf.setBoolVar(conf, HiveConf.ConfVars.HIVE_SUPPORT_CONCURRENCY, false);
        SessionState.start(conf);
        Driver driver = new Driver(conf);
        driver.init();
        return driver;
    }
}
