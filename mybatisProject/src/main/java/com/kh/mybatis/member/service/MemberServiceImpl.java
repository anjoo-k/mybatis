package com.kh.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {
	// 서비스가 인터페이스를 구현하고 있다.
	private MemberDao mDao = new MemberDao();

	
	@Override
	public int insertMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		// connection 대신 mybatis에서 제공하는 sqlsession객체 이용
		
		int result = mDao.insertMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}


	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginUser = mDao.loginMember(sqlSession, m);
		
		sqlSession.close();
		
		return loginUser;
	}
	

}
