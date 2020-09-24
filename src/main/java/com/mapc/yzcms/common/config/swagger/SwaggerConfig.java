package com.mapc.yzcms.common.config.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * 接口文档配置
 *
 * @author duchao
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Profile({"dev"})
@Import(BeanValidatorPluginsConfiguration.class)
@ConditionalOnProperty(value = {"knife4j.enable"}, matchIfMissing = true)
public class SwaggerConfig implements WebMvcConfigurer {

	@Value("${spring.application.name}")
	private String applicationName;

	/**
	 * 静态资源映射
	 *
	 * @param registry 资源处理注入器
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/swagger/**").addResourceLocations("classpath:/static/swagger/");
	}

	@Bean
	public Docket restApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.groupName(applicationName)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.mapc.yzcms.controller"))
				.paths(PathSelectors.any())
				.build()
				.securityContexts(Lists.newArrayList(securityContext())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey()));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(applicationName + " api")
				.description(applicationName + " api")
				.version("1.0")
				.build();
	}

	private ApiKey apiKey() {
		return new ApiKey("BearerToken", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder()
				.securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex("/.*"))
				.build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Lists.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
	}

}
