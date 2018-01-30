package board.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import board.service.BoardVO;
import utility.Paging;

public class BoardDao {

	private final String namespace="board.model.board";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate; 
	
	public BoardDao(){}
		
	
	public int GetTotalCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		int cnt = -1;
		cnt=sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}
	
	public List<BoardVO> GetDataList(Paging pageInfo, Map<String, String> map) {
		// TODO Auto-generated method stub		
		List<BoardVO> lists = new ArrayList<BoardVO>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit() );
		lists = sqlSessionTemplate.selectList(namespace + ".GetDataList", map, rowBounds);
		return lists;
	}
	
	
	
	
}
