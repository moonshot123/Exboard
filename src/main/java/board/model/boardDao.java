package board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import utility.Paging;


@Component("myBoardDao")//而⑦듃濡ㅻ윭�뿉�꽌 �삤瑜섍� �엳�뼱�꽌 洹몃젃�떎.... �뼱�끂�뀒�씠�뀡�뿉 �씠由꾩씠 �떎瑜닿쾶 �꽔�뼱�졇�엳�뼱�꽌洹몃옱�쓬 �뀥�뀥
public class boardDao {

	private final String namespace="board.model.board";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate; 
	
	public boardDao(){}
	
	
	public int GetTotalCount(Map<String, String> map) {
		int cnt = -1;
		cnt=sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}

	
	public List<board> GetDataList(Paging pageInfo, Map<String, String> map) {
		List<board> lists = new ArrayList<board>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit() );
		lists = sqlSessionTemplate.selectList(namespace + ".GetDataList", map, rowBounds);
		return lists;
	}
	
	
	public int insertBoard(board board) {
		int cnt = -1;
		System.out.println("board.getPasswd()"+board.getPasswd());
		cnt=sqlSessionTemplate.insert(namespace+".InsertBoard",board);
		return cnt;
	}

	
	public board GetData(int num) {
		
		sqlSessionTemplate.update(namespace+".UpdateReadcount",num);
		board board = sqlSessionTemplate.selectOne(namespace+".GetData",num);
		
		return board;
	}


	public void UpdateData(board board) {
		
		sqlSessionTemplate.update(namespace+".UpdateData",board);
		
	}
	
	
	
	
	
}
