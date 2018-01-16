package com.taobao.rigel.rap.mail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.taobao.rigel.rap.common.config.SystemConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 邮件发送配置信息加载类
 * 
 * @date 2016-10-27
 * @author 吴俊杰
 * @Description:
 * @project rap
 */
public class ConfigLoader {
	//日志记录对象
	private static Logger log = LoggerFactory.getLogger(ConfigLoader.class);
	// 邮件发送SMTP主机
	private static String server;
	// 发件人邮箱地址
	private static String sender;
	// 发件人邮箱用户名
	private static String username;
	// 发件人邮箱密码
	private static String password;
	// 发件人显示昵称
	private static String nickname;
	static {
		server = SystemConstant.getConfig("mail.server");
		sender = SystemConstant.getConfig("mail.sender");
		username = SystemConstant.getConfig("mail.username");
		password = SystemConstant.getConfig("mail.password");
		nickname = SystemConstant.getConfig("mail.nickname");
	}

	public static String getServer() {
		return server;
	}

	public static String getSender() {
		return sender;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}

	public static String getNickname() {
		return nickname;
	}

}
