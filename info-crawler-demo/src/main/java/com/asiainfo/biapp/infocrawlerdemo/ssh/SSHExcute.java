/**
 * Project Name:ssh_test File Name:ExcuteTool.java Package Name:com.asiainfo.sshtest2 Date:2017年10月31日下午5:40:12
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.asiainfo.biapp.infocrawlerdemo.ssh;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * ClassName:ExcuteTool <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年10月31日 下午5:40:12 <br/>
 * 
 * @author Maclong-work
 * @version
 * @since JDK 1.6
 * @see
 */
public class SSHExcute {

    Session session;

    private ArrayList<String> stdout;

    public SSHExcute(Session session) {
        this.session = session;
    }

    public int excute(final String command) {

        int returnCode = -1;

        try {
            // 打开通道，设置通道类型，和执行的命令
            Channel channel = session.openChannel("exec");
            ChannelExec channelExec = (ChannelExec) channel;
            channelExec.setCommand(command);

            channelExec.setInputStream(null);
            BufferedReader input = new BufferedReader(new InputStreamReader(channelExec.getInputStream()));

            channelExec.connect();

            // 接收远程服务器执行命令的结果
            String line;
            stdout = new ArrayList<String>();
            while ((line = input.readLine()) != null) {
                stdout.add(line);
            }
            input.close();

            // 得到returnCode
            if (channelExec.isClosed()) {
                returnCode = channelExec.getExitStatus();
            }

            // 关闭通道
            channelExec.disconnect();

        } catch (JSchException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnCode;

    }


    /**
     * get stdout
     * 
     * @return
     */
    public ArrayList<String> getStandardOutput() {
        return stdout;
    }


}

