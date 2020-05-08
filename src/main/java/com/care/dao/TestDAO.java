package com.care.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.dto.TestDTO;

@Repository
public class TestDAO {
	private static final String namespace = "com.care.mybatis.myMapper";	//mapper.xml에서 설정한 그 경로.
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<TestDTO> test(){	//기본경로 + ".mapper에서 만든, 실행할 쿼리문의 아이디"
		return sqlSession.selectList(namespace+".listAll");	//여러 데이터 받아오기 위한 selectList.. 데이터 하나는 selectOne 으로 받아온다
	}
	
	public TestDTO list(String num) {//기본경로 + ".mapper에서 만든, 실행할 쿼리문의 아이디", 입력받아서 넘겨줄값..(받는쪽은num = #{num}으로 받음)
		return sqlSession.selectOne(namespace+".list",num);
	}
}
