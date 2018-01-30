package board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;


public interface BoardService {
	/**
	 * 게시판 리스트
	 * @param BoardVO - 조회할 정보가 담긴 VO
	 * @return 리스트목록
	 * @exception Exception
	 */
		
	public String boardList(HttpServletRequest req, ModelAndView mav)throws Exception;
	
}
