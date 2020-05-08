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
	
	//모든 목록
	public List<TestDTO> test(){	//기본경로 + ".mapper에서 만든, 실행할 쿼리문의 아이디"
		return sqlSession.selectList(namespace+".listAll");	//여러 데이터 받아오기 위한 selectList.. 데이터 하나는 selectOne 으로 받아온다
	}
	
	
	//검색
	public TestDTO list(String num) {//기본경로 + ".mapper에서 만든, 실행할 쿼리문의 아이디", 입력받아서 넘겨줄값..(받는쪽은num = #{num}으로 받음)
		return sqlSession.selectOne(namespace+".list",num);
	}
	
	//추가
	public void savedata(TestDTO dto) {		   // . <-- 입력 잊지 말것
		int result = sqlSession.insert(namespace+".savedata",dto);
		System.out.println("추가 결과값: "+result);
	}
	
	//수정
	public void updatedata(TestDTO dto) {
		int result = sqlSession.update(namespace+".updatedata", dto);
		System.out.println("수정 결과값: "+result);
	}
	
	//내가 만든 삭제 기능
	public void deletedata(TestDTO dto) {
		int result = sqlSession.delete(namespace+".deletedata", dto);
		System.out.println("삭제 결과값: "+result);
		
	}
	
	//선생님 삭제 코드
	public void delete(String num) {
		sqlSession.delete(namespace+".delete", num);
	}
}
