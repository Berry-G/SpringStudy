package kr.co.heart.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.heart.dao.BoardDao;
import kr.co.heart.domain.BoardDto;

public class BoardServiceImpl implements BoardService
{
	@Autowired(required=false)
	BoardDao boardDao;
	
	public List<BoardDto> getPage(Map map) throws Exception
	{
		return boardDao.selectPage(map);
	}

	@Override
	public int getCount() throws Exception
	{
		// TODO Auto-generated method stub
		return boardDao.count();
	}
	
	@Override
	public BoardDto read(Integer bno) throws Exception
	{
		BoardDto boardDto = boardDao.select(bno);
		
		boardDao.increaseViewCnt(bno);
		
		return boardDto;
	}
}
