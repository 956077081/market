package com.pht.common.frame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerFormator {
    private Logger logger;
    private LoggerFormator(Class tclass){
        this.logger =LoggerFactory.getLogger(tclass);
    }
    public static LoggerFormator getLogger(Class tclass){
        LoggerFormator loggerFormator = new LoggerFormator(tclass);
        return loggerFormator;
    }
    public void info(String message){
        logger.info("compCode="+QMENV.getCompCode()+"|"+message);
    }
    public void info(String message,Object o){
        logger.info("compCode="+QMENV.getCompCode()+"|"+message,o);
    }
    public void error(String message){
        logger.error(message);
    }
    public void debug(String message){
        logger.debug(message);
    }
    public void error(String message,Object o){
        logger.error("compCode="+QMENV.getCompCode()+"|"+message,o);
    }
}
