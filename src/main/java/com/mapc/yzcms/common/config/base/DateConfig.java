package com.mapc.yzcms.common.config.base;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTime 序列化、反序列化支持
 *
 * @author duchao
 */

@Configuration
public class DateConfig {

	@Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
	private String pattern;

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
		return builder -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			//返回时间数据序列化
			builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(formatter));
			//接收时间数据反序列化
			builder.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(formatter));
		};
	}
}
