package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.vo.PageInfo;

public class BoardDao {
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
		
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi){
		// 마이바티스에서는 페이징 처리를 위해서 rowBounds라는 클래스를 제공한다.
		/* offset: 몇 개의 게시글을 건너뛰고 조회할 것인지에 대한 값
		 * 
		 * currnetPage : 1		1~5		0
		 * currnetPage : 2		6~10	5
		 * currnetPage : 3		11~15	10
		 * 
		 */
		
		int offset = (pi.getCurrnetPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		System.out.println(pi);
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}
	

}
