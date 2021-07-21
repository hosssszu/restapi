package com.sample.postgress.config;

import com.sample.postgress.convertors.StringToEnumConvertor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.sql.DataSource;
import java.util.Collections;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
        dataSourceBuilder.url("jdbc:oracle:thin:@localhost:1521/xe");
        dataSourceBuilder.username("system");
        dataSourceBuilder.password("password");
        return dataSourceBuilder.build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/postgressApp/*"))
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Employees API",
                "Sample API",
                "1.0",
                "Free to use",
                new Contact("Szegedi Lorand", "https://www.szegedi.lorand", "szegedi@lorand.com"),
                "API License",
                "https://www.szegedi.lorand",
                Collections.emptyList()
        );
    }

    protected void addFormatters (FormatterRegistry registry) {
        registry.addConverter(new StringToEnumConvertor());
    }

}
