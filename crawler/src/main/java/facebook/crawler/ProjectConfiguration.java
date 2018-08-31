package facebook.crawler;

import facebook.crawler.services.implementations.UserServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan(basePackages = {"facebook.crawler.controllers"})
@EntityScan(value = "facebook.crawler.domain")
public class ProjectConfiguration {

    private static final String PACKAGES_TO_SCAN = "facebook.crawler.domain";
    private static final String USERNAME_DATABASE = "root";
    private static final String PASSWORD_DATABASE = "Password_95";
    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/facebook_crawler";
    private static final String ENTITY_MANAGER_DIALECT = "org.hibernate.dialect.MySQL5Dialect";

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername(USERNAME_DATABASE);
        dataSource.setPassword(PASSWORD_DATABASE);
        dataSource.setUrl(URL_DATABASE);

        return dataSource;
    }

    @Bean
    public Connection getConnectionBean() {
        try {
            return dataSource().getConnection();
        } catch (SQLException e) {
            System.out.println("Could not retrieve connection bean!");
        }

        return null;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform(ENTITY_MANAGER_DIALECT);
        return adapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource());
        emfb.setJpaVendorAdapter(jpaVendorAdapter());
        emfb.setPackagesToScan(PACKAGES_TO_SCAN);

        return emfb;
    }

    @Bean
    public UserServiceImpl getUserServiceImplBean() {
        return new UserServiceImpl();
    }
}
