package pers.ljf.spring.debug.tx.annotation;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author: ljf
 * @date: 2021/4/13 14:41
 * @description: 事务的配置文件
 * @modified By：
 * @version: $ 1.0
 */
@Configuration
@PropertySource("classpath:dbconfig.properties")
@EnableTransactionManagement
public class TransactionConfig {

	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Bean
	public DataSource dataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(this.driverClassName);
		druidDataSource.setUrl(this.url);
		druidDataSource.setUsername(this.username);
		druidDataSource.setPassword(this.password);
		return druidDataSource;
	}


	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public BookService bookService() {
		return new BookService();
	}

	@Bean
	public BookDao bookDao() {
		return new BookDao();
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
