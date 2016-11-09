package com.ivanslushko.training.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
public class Log4jDBExample
{
    static final Logger logger = LogManager.getLogger(Log4jDBExample.class.getName());
 
    
    
    public static void main(String[] args)
    {

        logger.trace("Trace Message!");
        logger.debug("Debug Message!");
        logger.info("Info Message!");
        logger.warn("Warn Message!");
        logger.error("Error Message!");
        logger.fatal("Fatal Message!");
        
        
    }  
}