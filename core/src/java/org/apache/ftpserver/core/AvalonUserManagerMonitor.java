package org.apache.ftpserver.core;

import org.apache.avalon.framework.logger.Logger;
import org.apache.ftpserver.UserManagerMonitor;

/**
 * @author Paul Hammant
 * @version $Revision$
 */
public class AvalonUserManagerMonitor implements UserManagerMonitor {

    Logger logger;

    public AvalonUserManagerMonitor(Logger logger) {
        this.logger = logger;
    }

    public void generalError(String message, Exception ex) {
        logger.error(message, ex);
    }

    public void info(String message) {
        logger.info(message);
    }
}
