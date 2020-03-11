package com.atguigu.springboot.config.DataSourceConfigs;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.atguigu.springboot.mapper.hualala", sqlSessionTemplateRef  = "hualalaSqlSessionTemplate")
public class HualalaDatasourceConfiguration {

    @Bean(name = "hualalaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.hualala")
    public DataSource dataSource() {
        return  new DruidDataSource();
    }

    @Bean(name = "hualalaSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("hualalaDataSource") DataSource dataSource) throws Exception {
        // 创建sessionFactory
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //原本.xml是放在Resources/mybatis目录下的配置
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));
        // 扫描mapper.xml
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:com/atguigu/springboot/mapper/hualala/*.xml");
        bean.setMapperLocations(resources);
        //读取config
//        bean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis/mybatis-config.xml"));

        return bean.getObject();
    }

    @Bean(name = "hualalaTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("hualalaDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "hualalaSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("hualalaSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
}
