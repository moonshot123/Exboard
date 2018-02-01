package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.board;
import board.model.boardDao;
import utility.Paging;

/**
 * 게시판 페이지 컨트롤러 클래스
 * @author JJW
 * @since 2018.02.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *  2018.02.01 JJW		 	 최초생성
 *   
 *
 * </pre>
 */

@Controller
public class boardController {
	
	
	@Autowired
	@Qualifier("myBoardDao")
	private boardDao boardDao;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	/**
		글 리스트
	*/
		
	@RequestMapping(value="/list.bo")
	public ModelAndView boardlist(
			@RequestParam(value = "whatColumn", required = false ) String whatColumn,
			@RequestParam(value = "keyword", required = false ) String keyword,
			@RequestParam(value = "pageNumber", required = false ) String pageNumber,
			@RequestParam(value = "pageSize", required = false ) String pageSize,
			HttpServletRequest request){		

		System.out.println("whatColumn: " + whatColumn);
		System.out.println("keyword: " + keyword);
		System.out.println("pageNumber: " + pageNumber);
		System.out.println("pageSize: " + pageSize);
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%" + keyword + "%");
		
		int totalCount = boardDao.GetTotalCount( map );
		
		String url = request.getContextPath() + "/list.bo" ;
		
		ModelAndView mav = new ModelAndView();
		
		Paging pageInfo 
			= new Paging( pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		
		List<board> boardLists = boardDao.GetDataList( pageInfo, map );
		
		System.out.println("boardLists.size(): " + boardLists.size());
		mav.addObject( "boardLists", boardLists );		
		mav.addObject( "pageInfo", pageInfo );
		mav.setViewName("BoardList");
		return mav;				
	} 
	

	/**
		글쓰기
	*/
	
	
	@RequestMapping(value="/writeBoard.bo")
	public ModelAndView writeBoard(HttpServletRequest req, board board){
		System.out.println("board.getPasswd()"+board.getPasswd());
		System.out.println("board.getPasswd()"+board.getNum());
		System.out.println("board.getPasswd()"+board.getContent());
		System.out.println("board.getPasswd()"+board.getSubject());
		System.out.println("board.getPasswd()"+board.getWriter());
		System.out.println("board.getPasswd()"+board.getRestep());
		System.out.println("board.getPasswd()"+board.getEmail());
		System.out.println("board.getPasswd()"+board.getRelevel());
		System.out.println("board.getPasswd()"+board.getRegdate());
		System.out.println("board.getPasswd()"+board.getRef());
		
		ModelAndView mav = new ModelAndView();
		
		board.setRegdate("");
		board.setReadcount(0);
		board.setIp(req.getRemoteAddr());
		board.setRestep(0);
		board.setRelevel(0);
		
		int cnt = boardDao.insertBoard(board);
		
		if(cnt != -1){
			mav.setViewName("redirect:/list.bo");
		}else{
			mav.setViewName("writeForm");
		}
		return mav;		
	}
	
	
	
	/**
		업데이트
	 */
	
	@RequestMapping(value="/updateboard.bo" , method=RequestMethod.GET)
	public String updateboard(
			@RequestParam(value="num",required=true) int num,Model model){
		
		board board = boardDao.GetData(num);
		model.addAttribute("board",board);
		return "BoardUpdate";
	}
	

	@RequestMapping(value="/updateboard.bo" , method=RequestMethod.POST)
	public String doActionPost(board board){
		
		boardDao.UpdateData(board);
		
		return "redirect:/list.bo";
	}		
	
	
	/**
		상세글
	*/	
	@Autowired
	@Qualifier("myBoardDao")
	private boardDao baordDao;
	
	@RequestMapping(value="/detail.bo")
	public String detailboard(@RequestParam(value="num",required=true) int num,Model model){
		
		board board = baordDao.GetData(num);
		
		model.addAttribute("board",board);
		
		return "BoardDetail";
	}
	
	
	
	
	
	
	
}
