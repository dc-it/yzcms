package com.mapc.yzcms.common.util;

import cn.hutool.core.lang.Assert;
import com.mapc.yzcms.common.exception.BaseException;
import com.zaxxer.hikari.HikariDataSource;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;

/**
 * 新数据库初始化工具
 *
 * @author duchao
 */
@Slf4j
@UtilityClass
public class NewWebsiteDbUtil {

	/**
	 * 创建数据库（包含创建几个内容表）
	 *
	 * @param schema   数据库名
	 * @param url      数据库连接地址
	 * @param username 账户名
	 * @param password 密码
	 */
	public static void createSchema(String schema, String url, String username, String password) {

		checkConnectionParams(schema, url, username, password);

		url = "jdbc:mysql://"+url+"?useUnicode=true&useSSL=false&autoReconnect=true&allowPublicKeyRetrieval=true&allowMultiQueries=true";

		try (HikariDataSource dataSource = DataSourceBuilder.create()
				.url(url)
				.driverClassName("com.mysql.cj.jdbc.Driver")
				.username(username)
				.password(password)
				.type(com.zaxxer.hikari.HikariDataSource.class)
				.build();
		     Connection connection = dataSource.getConnection();
		     Statement statement = connection.createStatement();
		     InputStream stream = NewWebsiteDbUtil.class.getClassLoader().getResourceAsStream("website.sql")) {

			//创建数据库
			statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + schema);

			connection.setSchema(schema);

			//创建表
			String createTabSql = new String(stream.readAllBytes());
			StringBuilder sql = new StringBuilder();
			sql.append("USE ").append(schema).append(";")
					.append(createTabSql);
			statement.executeUpdate(sql.toString());

			log.info("新站数据库{}创建成功", schema);
		} catch (Exception e) {
			log.info("新站数据库{}创建失败：{}", schema, e.getMessage());
			throw new BaseException("新站数据库" + schema + "创建失败");
		}
	}

	/**
	 * 删除数据库（包含创建几个内容表）
	 *
	 * @param schema   数据库名
	 * @param url      数据库连接地址
	 * @param username 账户名
	 * @param password 密码
	 */
	public static void dropSchema(String schema, String url, String username, String password) {

		checkConnectionParams(schema, url, username, password);

		url = "jdbc:mysql://"+url+"?useUnicode=true&useSSL=false&autoReconnect=true&allowPublicKeyRetrieval=true&allowMultiQueries=true";

		try (HikariDataSource dataSource = DataSourceBuilder.create()
				.driverClassName("com.mysql.cj.jdbc.Driver")
				.url(url)
				.username(username)
				.password(password)
				.type(com.zaxxer.hikari.HikariDataSource.class)
				.build();
		     Connection connection = dataSource.getConnection();
		     Statement statement = connection.createStatement()) {

			statement.executeUpdate("DROP DATABASE IF EXISTS " + schema);

			log.info("新站数据库{}删除成功", schema);
		} catch (Exception e) {
			log.info("新站数据库{}删除失败：{}", schema, e.getMessage());
			throw new BaseException("新站数据库" + schema + "删除失败");
		}
	}

	/**
	 * 检查数据库连接参数
	 *
	 * @param schema   数据库名
	 * @param url      数据库连接地址
	 * @param username 账户名
	 * @param password 密码
	 */
	private void checkConnectionParams(String schema, String url, String username, String password){
		AssertUtil.notBlank(schema,"数据库名称不能为空");
		AssertUtil.notBlank(url,"数据库连接地址不能为空");
		AssertUtil.notBlank(username,"数据库账号不能为空");
		AssertUtil.notBlank(password,"数据库密码不能为空");
	}
}
