package com.mapc.yzcms.common.util;

import com.mapc.yzcms.common.config.datasource.DataSourceProperties;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;

/**
 * 新数据库初始化工具
 *
 * @author duchao
 */
@Slf4j
@Component
public class NewWebsiteDbUtil {

	private final DataSourceProperties dataSourceProperties;

	@Autowired
	public NewWebsiteDbUtil(DataSourceProperties dataSourceProperties) {
		this.dataSourceProperties = dataSourceProperties;
	}

	/**
	 * 创建数据库（包含创建几个内容表）
	 *
	 * @param schema 数据库名
	 */
	public void createSchema(String schema) {

		try (HikariDataSource dataSource = DataSourceBuilder.create()
				.driverClassName(dataSourceProperties.getDriverClassName())
				.url(dataSourceProperties.getConUrl())
				.username(dataSourceProperties.getUsername())
				.password(dataSourceProperties.getPassword())
				.type(dataSourceProperties.getType())
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
		}
	}

	/**
	 * 删除数据库
	 *
	 * @param schema 数据库名
	 */
	public void dropSchema(String schema) {

		try (HikariDataSource dataSource = DataSourceBuilder.create()
				.driverClassName(dataSourceProperties.getDriverClassName())
				.url(dataSourceProperties.getConUrl())
				.username(dataSourceProperties.getUsername())
				.password(dataSourceProperties.getPassword())
				.type(dataSourceProperties.getType())
				.build();
		     Connection connection = dataSource.getConnection();
		     Statement statement = connection.createStatement()) {

			statement.executeUpdate("DROP DATABASE IF EXISTS " + schema);

			log.info("新站数据库{}删除成功", schema);
		} catch (Exception e) {
			log.info("新站数据库{}删除失败：{}", schema, e.getMessage());
		}
	}
}
