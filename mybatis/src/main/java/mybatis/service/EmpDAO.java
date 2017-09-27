package mybatis.service;
//DAO - 매핑 파일 실행,
//SERVICE
//MAIN - 출력, 파라미터 전송
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpDAO {
	SqlSession session;
	public void setSession(SqlSession ss){
		this.session = ss;
	}
	//test1 : 테이블 전체 레코드 조회
	List<EmpVO> getAllEmp(){
		List<EmpVO> list = session.selectList("emp.all");//mapper.xml id
		return list;
	}
	//test2 : 파라미터 입력 해당 레코드 1개 조회
	EmpVO getOneEmp(int id){
		EmpVO vo2 = session.selectOne("emp.one", 100); //뒤에는 파라미터 값을 주면 됨.
		return vo2;
	}
	
	//test4-2: insert:parameterType 필요, resultType 필요
	public int insertEmp(EmpVO vo){
		return session.insert("emp.createWithSelectKey", vo);
	}
	
	//test5: udapte:resultType 필요없는 sql
	//emp.update 매핑 sql 실행
	public int updateEmp(EmpVO vo){
		return session.update("emp.update", vo);
	}

	//test6: delete:resultType 필요없는 sql
	//emp.delete매핑 sql 실행(사번 1000)
	public int deleteEmp(int id){
		return session.delete("emp.delete", id);
	}
	
}