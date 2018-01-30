package board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.service.BoardService;
import board.service.BoardVO;
import board.service.impl.BoardDao;
import utility.Paging;

/**
 * 게시판 페이지 컨트롤러 클래스
 * @author JJW
 * @since 2018.01.30
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *  2018.01.30 JJW		 	 최초생성
 *   
 *
 * </pre>
 */

@Controller
public class BoardController {
		
	/** BoardService */
	@Resource(name = "boardService")
	private BoardService boardService;
	
	@Autowired
	@Qualifier("myBoardDao")
	private BoardDao baordDao;
	
	@RequestMapping(value="/boardlist.do")
	public String boardList(@RequestParam(value = "whatColumn", required = false ) String whatColumn,
			@RequestParam(value = "keyword", required = false ) String keyword,
			@RequestParam(value = "pageNumber", required = false ) String pageNumber,
			@RequestParam(value = "pageSize", required = false ) String pageSize,
			HttpServletRequest req) throws Exception{
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%" + keyword + "%");
		
		int totalCount = baordDao.GetTotalCount( map );
		
		String url = req.getContextPath() + "/boardlist.do";
		
		ModelAndView mav = new ModelAndView();
		
		Paging pageInfo 
			= new Paging( pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		
		List<BoardVO> boardLists = baordDao.GetDataList( pageInfo, map );
		
		System.out.println("boardLists.size(): " + boardLists.size());
		mav.addObject( "boardLists", boardLists );		
		mav.addObject( "pageInfo", pageInfo );
		mav.setViewName("BoardList");		
		
		return boardService.boardList(req,mav);
	} 
		
}
