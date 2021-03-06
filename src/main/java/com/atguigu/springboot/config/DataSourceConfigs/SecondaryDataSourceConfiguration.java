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
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 这是设置第二个数据源postgre数据库配置
 * rocky
 */
@Configuration
@MapperScan(basePackages = "com.atguigu.springboot.mapper.secondary", sqlSessionTemplateRef  = "secondarySqlSessionTemplate")
public class SecondaryDataSourceConfiguration {

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.secondary")
    public DataSource dataSource() {
        return  new DruidDataSource();
    }

    @Bean(name = "secondarySqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("secondaryDataSource") DataSource dataSource) throws Exception {
        // 创建sessionFactory
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //原本.xml是放在Resources/mybatis目录下的配置
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));
        // 扫描mapper.xml
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:com/atguigu/springboot/mapper/secondary/*.xml");
        bean.setMapperLocations(resources);
        //读取config
//        bean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis/mybatis-config.xml"));

        return bean.getObject();
    }

    @Bean(name = "secondaryTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "secondarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("secondarySqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
