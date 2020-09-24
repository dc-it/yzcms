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
	public String getConUrl() {
		return this.url.substring(0, this.url.lastIndexOf("/")) + this.url.substring(this.url.indexOf("?"));
	}
}