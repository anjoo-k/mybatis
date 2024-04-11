package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession sqlSession, Member m) {
		
		int result = sqlSession.insert("memberMapper.insertMember", m);
	// 구분자(mapper 이름: <mapper namespace="memberMapper"> 로 매퍼 안에 설정), 식별자(넘겨주는 값, 구별할 값, 파라미터)
	// namespace.id
		return result;
	}
	
	
	public Member loginMember(SqlSession sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.loginMember", m);
		// memberMapper 안에 있는 loginMember을 쓸거야
		
		

	}

}
