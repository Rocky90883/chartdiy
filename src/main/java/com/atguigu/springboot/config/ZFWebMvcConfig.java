//package com.atguigu.springboot.config;
//
//import com.atguigu.springboot.Interceptor.CheckParamsInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.*;
//
//@Configuration
//public class WebMvcConfig  extends WebMvcConfigurationSupport  {
//
//    CheckParamsInterceptor checkSourceInterceptor = new CheckParamsInterceptor();   //参数非空拦截器
//
//    /**
//     * 指定路径名为/**的访问classpath:/static/静态目录下
//     * 指定/swagger-ui.html固定访问/META-INF/resources/目录下 注意该路径在  关于swagger的jar包里面
//     * @param registry
//     */
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
//
//        registry.addResourceHandler("/swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//    /**
//     * 将以/swagger结束的请求，重定向为访问/swagger-ui.html
//     * @param registry
//     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addRedirectViewController("/swagger","/swagger-ui.html");
//    }
//
//
//    //增加校验拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 这个地方可以定义拦截器的具体的路径
//        registry.addInterceptor(checkSourceInterceptor).addPathPatterns("/**");
//    }
//}
