package com.mapc.yzcms.common.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 数据源属性
 *
 * @author duchao
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties {

	/**
	 * 数据源类型
	 */
	private Class<HikariDataSource> type;

	/**
	 * 访问地址
	 */
	private String url;

	/**
	 * 账号
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 驱动类名
	 */
	private String driverClassName;

	/**
	 * 获取数据库服务器连接的地址
	 *
	 * @return
	 */
	public String getPrimaryDatabaseIpPort() {
		return this.url.substring(this.url.indexOf("//")+2,this.url.lastIndexOf("/"));
	}

	public String getPrimaryDatabaseName(){
		return this.url.substring(this.url.lastIndexOf("/")+1,this.url.indexOf("?"));
	}


}