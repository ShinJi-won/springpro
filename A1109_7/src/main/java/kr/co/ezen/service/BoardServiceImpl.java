package kr.co.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ezen.entity.Board;
import kr.co.ezen.entity.Criteria;
import kr.co.ezen.entity.Member;
import kr.co.ezen.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<Board> getList(Criteria cri) {
		//반영할 로직
		List<Board> list= boardMapper.getList(cri);
		
		return list;
	}

	@Override
	public Member login(Member vo) {
		Member mvo=boardMapper.login(vo);
		return mvo;
	}

	@Override
	public void register(Board vo) {
		boardMapper.insertSelectKey(vo);
		
	}

	@Override
	public Board get(int idx) {
		Board vo=boardMapper.read(idx);
		return vo;
	}

	@Override
	public void modify(Board vo) {
		boardMapper.update(vo);
		
	}

	@Override
	public void remove(int idx) {
		boardMapper.delete(idx);
		
	}

	@Override
	public void replyProcess(Board vo) {
		Board parent=boardMapper.read(vo.getIdx());
		vo.setBoardGroup(parent.getBoardGroup());
		vo.setBoardSequence(parent.getBoardSequence()+1);
		vo.setBoardLevel(parent.getBoardLevel()+1);
		boardMapper.replySeqUpdate(parent); 
		
		//6. 답글을 저장하기
		boardMapper.replyInsert(vo);
	}

	@Override
	public int totalCount(Criteria cri) {
		return boardMapper.totalCount(cri);
	}

	@Override
	public void countUpdate(int idx) {
		boardMapper.countUpdate(idx);
		
	}



	
	
	
}
