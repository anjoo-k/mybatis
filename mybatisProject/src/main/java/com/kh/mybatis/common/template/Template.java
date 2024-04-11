package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	// 마이바티스를 사용하겠다
	
	public static SqlSession getSqlSession() {
		// mybatis-config.xml => 읽어들이기
		// 해당 db와 접속된 SqlSession 객체 생성해서 반환하기
		
		SqlSession sqlsession = null;
		
		
		// SqlSession 생성하기 위해서는  =>  SqlSessionFactory 객체 필요
		// SqlSessionFactory를 생상하기 위해서는  =>  SqlSessionFactoryBuiler 필요
		
		String resource = "/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			sqlsession = sqlSessionFactory.openSession(false); // boolean autoCommit => 자동 커밋 여부(true면 자동커밋, false면 수동커밋)
			
			sqlsession =  new SqlSessionFactoryBuilder().build(inputStream).openSession(false);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sqlsession;
		
	}
	

}
