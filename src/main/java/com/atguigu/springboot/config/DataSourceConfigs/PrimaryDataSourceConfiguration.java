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

/**
 * 主数据源mysql配置
 * rocky
 */
@Configuration
@MapperScan(basePackages = "com.atguigu.springboot.mapper.primary", sqlSessionTemplateRef  = "primarySqlSessionTemplate")
public class PrimaryDataSourceConfiguration {

    @Bean(name = "primaryDataSource")
    @Primary   //配置默认数据源
    @ConfigurationProperties(prefix = "spring.datasource.druid.primary")
    public DataSource dataSource() {
        return  new DruidDataSource();
    }

    @Bean(name = "primarySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
        //创建SqlSessionFactoryBean
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //原有扫描.xml配置
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));
        // 扫描mapper.xml
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:com/atguigu/springboot/mapper/primary/*.xml");
        bean.setMapperLocations(resources);
        return bean.getObject();

    }

    @Bean(name = "primaryTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "primarySqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
