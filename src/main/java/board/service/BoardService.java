package board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;


public interface BoardService {
	/**
	 * �Խ��� ����Ʈ
	 * @param BoardVO - ��ȸ�� ������ ��� VO
	 * @return ����Ʈ���
	 * @exception Exception
	 */
		
	public String boardList(HttpServletRequest req, ModelAndView mav)throws Exception;
	
}
