package com.dwayne.com.minasocket.socket;

import org.apache.mina.core.session.IoSession;

/**
 *
 * @author Dwayne
 * @email dev1024@foxmail.com
 * @time 2019/8/25 16:35
 * @change
 * @chang time
 * @class describe
 */

public class SessionManager {

    private static SessionManager instance;

    private IoSession mSession;

    private volatile static Object bytes = new Object();

    public static SessionManager getInstance() {
        if (null == instance) {
            instance = new SessionManager();
        }
        return instance;
    }

    private SessionManager() {
    }

    public void setSeesion(IoSession session) {
        this.mSession = session;
    }


    public void writeToServer(Object msg) {
        if (mSession != null) {
            mSession.write(msg);
        }
    }

    public void closeSession() {
        if (mSession != null) {
            mSession.closeOnFlush();
        }
    }

    public void removeSession() {
        this.mSession = null;
    }
}
