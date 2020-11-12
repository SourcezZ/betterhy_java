package com.betterhy.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * 数据库自动配置
 *
 * @author Source
 * @date 2020-11-12 09:52
 **/

@SpringBootConfiguration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceAutoConfiguration {

    @Resource
    DataSourceProperties properties;

    /**
     * mybatis-config.xml配置文件的路径
     */
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;

    /**
     * mybatis mapper文件所在路径
     */
    @Value("${mapper_path}")
    private String mapperPath;

    /**
     * 实体类所在的package
     */
    @Value("${entity_package}")
    private String entityPackage;

    @Bean
    public DataSource dataSource() {
        //可以在此处调用相关接口获取数据库的配置信息进行 DataSource 的配置
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setDriverClassName(properties.getDriverClassName());
        return dataSource;
    }

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 扫描mybatis配置文件
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        // 扫描相关mapper文件
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        // 调用dataSource
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 映射实体类
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        // 分页
        Interceptor[] plugins =  new Interceptor[]{pageHelper()};
        sqlSessionFactoryBean.setPlugins(plugins);
        return sqlSessionFactoryBean;
    }

    @Bean
    PageHelper pageHelper() {
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();

        // 3.3.0版本可用 - 分页参数合理化，默认false禁用
        // 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页
        // 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据
        properties.setProperty("reasonable", "true");

        // always总是返回PageInfo类型,check检查返回类型是否为PageInfo,none返回Page
        properties.setProperty("returnPageInfo", "none");

        //设置数据库类型 oracle,mysql,db2
        properties.setProperty("dialect", "mysql");

        // 设置为true时，如果pageSize=0或者RowBounds.limit = 0就会查询出全部的结果
        // （相当于没有执行分页查询，但是返回结果仍然是Page类型）
        properties.setProperty("pageSizeZero", "true");

        pageHelper.setProperties(properties);
        return pageHelper;
    }

}
