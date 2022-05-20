package com.choong.spr.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.choong.spr.domain.BoardDto;

import com.choong.spr.mapper.BoardMapper;
import com.choong.spr.mapper.ReplyMapper;


@Service
public class BoardService {
	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	public List<BoardDto> listBoard() {
		return mapper.selectBoard();
	}

	public BoardDto getBoard(int id) {
		return mapper.getBoard(id);
	}

	public boolean updateBoard(BoardDto board) {
		int cnt = mapper.updateBoard(board);
		
		return cnt == 1;
	}

	@Transactional
	public boolean removeBoardById(int id) {

		replyMapper.deleteReplyByBoard(id);

	
		int cnt = mapper.deleteBoard(id);
		
		return cnt == 1;
	}

	public boolean addBoard(BoardDto board) {
		
		
		int cnt = mapper.insertBoard(board);
		
		return cnt == 1;
	}
	
}
