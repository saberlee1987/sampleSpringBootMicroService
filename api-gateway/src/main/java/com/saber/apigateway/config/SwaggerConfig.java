package com.saber.apigateway.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Component
@EnableAutoConfiguration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "documentation.swagger")
public class SwaggerConfig {

    private List<SwaggerServices> swagger;

    public List<SwaggerServices> getSwagger(){
        return swagger;
    }
    public void setServices(List<SwaggerServices> swaggerServices){
        this.swagger =swaggerServices;
    }
    @EnableConfigurationProperties
    @ConfigurationProperties(prefix = "documentation.swagger.services")
    public static class SwaggerServices{
        private String name;
        private String url;
        private String version;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        @Override
        public String toString() {
            return "SwaggerServices{" +
                    "name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    ", version='" + version + '\'' +
                    '}';
        }
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Allow anyone and anything access. Probably ok for Swagger spec
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/swagger-ui.html*", config);
        return new CorsFilter(source);
    }

}
