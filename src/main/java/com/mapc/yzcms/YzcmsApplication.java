package com.mapc.yzcms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.InputStream;

@EnableJpaAuditing
@SpringBootApplication
public class YzcmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(YzcmsApplication.class, args);
	}

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void run(String... args) throws Exception {

		InputStream stream = this.getClass().getClassLoader().getResourceAsStream("website.sql");
		String db = new String(stream.readAllBytes());

		StringBuilder sb = new StringBuilder();
		sb.append("CREATE DATABASE IF NOT EXISTS ").append("bbb").append(";")
				.append("USE ").append("bbb").append(";")
				.append(db);

		Query query = entityManager.createNativeQuery(sb.toString());
		int i = query.executeUpdate();
		System.out.println("-------------------创建表," + i);
	}
}
