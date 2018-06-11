package br.com.serverBiblioteca.server;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource( value={
		"classpath:application.properties"
})
public class DataConfiguration {
	
	@Value("${bd.url}")
	private String url;
	
	@Value("${bd.port}")	
	private String port;
	
	@Value("${bd.dataBase}")
	private String dataBase;
	
	@Value("${bd.usuario}")
	private String usuario;
	
	@Value("${bd.senha}")
	private String senha;
	
	@Bean
	public DataSource dataSource(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/gerenciar_biblioteca");
//		dataSource.setUsername("root");
		dataSource.setUrl("jdbc:mysql://"+url+":"+port+"/"+dataBase);
		dataSource.setUsername(usuario);
		dataSource.setPassword(senha);
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adapter.setPrepareConnection(true);
		
		return adapter;
	}


}
