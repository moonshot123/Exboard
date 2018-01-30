package board.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import board.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	/** BoardDAO */
	@Resource(name = "BoardDAO")
	private BoardDao boardDoa;
	
	/** BoardService */
	@Resource(name = "BoardService")
	private BoardService boardService;
			
	@Override
	public String boardList(HttpServletRequest req, ModelAndView mav)throws Exception{
		
		return  "1";
	}
	
}
