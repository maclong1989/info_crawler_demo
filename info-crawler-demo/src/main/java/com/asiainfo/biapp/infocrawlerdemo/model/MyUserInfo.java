/**
 * Project Name:ssh_test File Name:MyUserInfo.java Package Name:com.asiainfo.sshtest Date:2017年10月31日下午5:19:07 Copyright
 * (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.model;

import com.jcraft.jsch.UserInfo;

/**
 * ClassName:MyUserInfo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年10月31日 下午5:19:07 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
public class MyUserInfo implements UserInfo {
    @Override
    public String getPassphrase() {
        // TODO Auto-generated method stub
        System.out.println("MyUserInfo.getPassphrase()");
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        System.out.println("MyUserInfo.getPassword()");
        return null;
    }

    @Override
    public boolean promptPassphrase(String arg0) {
        // TODO Auto-generated method stub
        System.out.println("MyUserInfo.promptPassphrase()");
        System.out.println(arg0);
        return false;
    }

    @Override
    public boolean promptPassword(String arg0) {
        // TODO Auto-generated method stub
        System.out.println("MyUserInfo.promptPassword()");
        System.out.println(arg0);
        return false;
    }

    @Override
    public boolean promptYesNo(String arg0) {
        // TODO Auto-generated method stub'
        System.out.println("MyUserInfo.promptYesNo()");
        System.out.println(arg0);
        if (arg0.contains("The authenticity of host")) {
            return true;
        }
        return true;
    }

    @Override
    public void showMessage(String arg0) {
        // TODO Auto-generated method stub
        System.out.println("MyUserInfo.showMessage()");
    }
}

