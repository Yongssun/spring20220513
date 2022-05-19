package com.choong.spr.mapper;

import java.util.List;

import com.choong.spr.domain.*;

public interface BoardMapper {
	List<BoardDto> selectBoard();

	BoardDto getBoard(int id);

	int updateBoard(BoardDto board);

	int deleteBoard(int id);

	int insertBoard(BoardDto board);
}
