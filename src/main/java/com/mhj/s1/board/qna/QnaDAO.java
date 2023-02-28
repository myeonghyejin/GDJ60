package com.mhj.s1.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mhj.s1.board.BbsDTO;
import com.mhj.s1.board.BoardDAO;
import com.mhj.s1.board.BoardDTO;
import com.mhj.s1.board.BoardFileDTO;
import com.mhj.s1.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.mhj.s1.board.qna.QnaDAO.";
	
	/** Select **/
	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getBoardList", pager);
	}
	
	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getBoardDetail", boardDTO);
	}
	
	@Override
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception {
		return null;
	}
	
	@Override
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getBoardFileDetail", boardFileDTO);
	}
	
	/** Insert **/
	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setBoardAdd", bbsDTO);
	}
	
	@Override
	public int setBoardFileAdd(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setBoardFileAdd", boardFileDTO);
	}
	
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setReplyAdd", qnaDTO);
	}
	
	/** Update **/
	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		return 0;
	}
	
	public int setStepUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setStepUpdate", qnaDTO);
	}
	
	/** Delete **/

	@Override
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setBoardDelete", bbsDTO);
	}

}
