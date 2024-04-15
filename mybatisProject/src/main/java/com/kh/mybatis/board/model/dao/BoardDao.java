package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
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
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
//		System.out.println(pi);
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
		// sql문 writer이 들어오는지(where절), title()이 들어오는 지에 따라 실행문이 달라진다. 동적 sql을 만들어야 한다.	
	}
	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);	
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo); // 처리된 행 수 리턴
	}
	
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo); // 객체 하나만 가져올꺼니까 one 쓰면 됨
	}
	
	public  ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo) { 
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo); // 객체 하나만 가져올꺼니까 one 쓰면 됨
	}
	
	

}
