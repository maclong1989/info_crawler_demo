/**
 * Project Name:ssh_test File Name:SSHSessionFactory.java Package Name:com.asiainfo.sshtest2 Date:2017年10月31日下午5:36:03
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.ssh;

import com.asiainfo.biapp.infocrawlerdemo.model.MyUserInfo;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * ClassName:SSHSessionFactory <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年10月31日 下午5:36:03 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
public class SSHSessionFactory {

    public static Session getSession(final String ip, final int port, final String username, final String password) {

        Session session = null;

        try {

            JSch jsch = new JSch();
            MyUserInfo userInfo = new MyUserInfo();

            session = jsch.getSession(username, ip, port);
            session.setPassword(password);
            session.setUserInfo(userInfo);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return session;
    }

}

