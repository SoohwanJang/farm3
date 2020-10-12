package com.farm.web.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@Configuration
@EnableTransactionManagement
//어노 테이션 기반 트랜잭션 관리를 사용 합니다.
//<tx:annotation-driven>
//데이터베이스 설정
public class ContextDataSource {
    /**
     * 데이터소스 등록
	 * @return
	 */
	@Bean()
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:33065/farm2?autoReconnect=true&characterEncoding=UTF-8&serverTimezone=Asia/Seoul&allowMultiQueries=true&useUnicode=true");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		dataSource.setDefaultAutoCommit(false);

		return dataSource;

	}
	
	/**
	 * 트랜잭션 매니저 등록
	 * @return
	 */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());

    }
    
	@PostConstruct
	public void init() {
		System.out.println();
	}

}

