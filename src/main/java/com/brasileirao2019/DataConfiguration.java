package com.brasileirao2019;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	
	//Configuração de conexão com o banco MYSQL
		@Bean
		public DataSource dataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/brasileirao2019");
			dataSource.setUsername("root");
			dataSource.setPassword("");
			return dataSource;
		}
		
		//Conexão do Hibernete - JPA
		@Bean
		public JpaVendorAdapter jpaVendorAdapter() {
			HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
			adapter.setDatabase(Database.MYSQL);
			adapter.setShowSql(true);
			adapter.setGenerateDdl(true);
			adapter.setDatabasePlatform("org.hibernate.dialect.MariaDBDialect");
			/* 
			 * https://stackoverflow.com/questions/43716068/invalid-syntax-error-type-myisam-in-ddl-generated-by-hibernate
			    org.hibernate.dialect.MySQLDialect
			 	org.hibernate.dialect.MariaDBDialect
			 	org.hibernate.dialect.MariaDB53Dialect
			 	org.hibernate.dialect.MySQL5Dialect
			 	org.hibernate.dialect.MySQL55Dialect
			 	org.hibernate.dialect.MySQL57Dialect
			*/
			adapter.setPrepareConnection(true);
			return adapter;
		}
}
