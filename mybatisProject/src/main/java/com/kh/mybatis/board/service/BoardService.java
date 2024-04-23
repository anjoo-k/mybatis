package com.kh.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.vo.PageInfo;

public interface BoardService {

	// 게시판 리스트 조회
	public int selectListCount();
	public ArrayList<Board> selectList(PageInfo pi);
	
	// 게시글 검색
	public int selectSearchCount(HashMap<String, String> map);
	
	// 게시글검색 - 페이지 내용물 가져오기
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);
	
	// 게시글 상세 조회
	public Board increaseCount(int boardNo);
	public ArrayList<Reply> selectReplyList(int boardNo);
}
