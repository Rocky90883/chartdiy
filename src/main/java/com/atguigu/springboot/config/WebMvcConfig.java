package com.atguigu.springboot.config;

import com.atguigu.springboot.Interceptor.CheckParamsInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //必须存在Swagger需要
@EnableSwagger2 //必须存在Swagger需要
public class WebMvcConfig extends WebMvcConfigurationSupport {

    //CheckParamsInterceptor checkSourceInterceptor = new CheckParamsInterceptor();   //参数非空拦截器

    /**
     * Swagger需要
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.atguigu.springboot"))
                .paths(PathSelectors.any()).build();
    }

    /**
     * Swagger需要
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("图表接口API")
                .description("接口一览")
                .version("1.0").build();
    }

    /**
     * 防止@EnableMvc把默认的静态资源路径覆盖了，手动设置的方式
     * Swagger需要
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决静态资源无法访问
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    /**
     * Swagger需要
     * 将以/swagger结束的请求，重定向为访问/swagger-ui.html
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addRedirectViewController("/swagger","/swagger-ui.html");
    }

    //增加校验参数非空拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 这个地方可以定义拦截器的具体的路径
//        registry.addInterceptor(checkSourceInterceptor).addPathPatterns("/**");
//    }
}
