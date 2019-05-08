package ${basepackage}.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

<#include "/java_copyright.include">

public class DataBaseConfiguration {

    public static DruidDataSource createDefaultDruidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setMaxWait(60000L);
        druidDataSource.setMaxActive(20);
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(1);
        druidDataSource.setTimeBetweenEvictionRunsMillis(3000L);
        druidDataSource.setMinEvictableIdleTimeMillis(300000L);
        druidDataSource.setConnectionProperties("druid.stat.slowSqlMillis=3000");
        druidDataSource.setValidationQuery("SELECT 'x'");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnBorrow(false);
        try {
            druidDataSource.setFilters("stat,wall");
        } catch (SQLException e) {
            throw new RuntimeException("create dataSource error", e);
        }
        return druidDataSource;
    }

    public static SqlSessionFactory createDefaultSqlSessionFactory(DataSource dataSource, String configLocation, String mapperLocation) {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setConfigLocation(resolver.getResource(configLocation));
        SqlSessionFactory target = null;
        try {
            factory.setMapperLocations(resolver.getResources(mapperLocation));
            target = factory.getObject();
        } catch (Exception e) {
            throw new RuntimeException("create SqlSessionFactory error dataSource:" + dataSource + " configLocation:" + configLocation + " mapperLocation:" + mapperLocation, e);
        }
        return target;
    }
}
