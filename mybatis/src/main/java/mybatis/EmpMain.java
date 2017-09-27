package mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMain {
	public static void main(String args[]) throws Exception{
		//1. xml 파일 읽어와서
		//SqlSesssion:Connection
		//SqlSessionFactory : connection pool
		SqlSessionFactoryBuilder  builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/configuration.xml"));
		SqlSession session = factory.openSession(true); //자동 commit 시킬려면 true로 써야됨!
		//======================================================
		//2. bean 조회
		//test1 : 테이블 전체 레코드 조회
		List<EmpVO> list = session.selectList("emp.all");//mapper.xml id
		for(EmpVO vo : list){
			System.out.println
			(vo.getEmployee_id()+vo.getFirst_name()+vo.getPhone());
		}
		//test2 : 파라미터 입력 해당 레코드 1개 조회
		EmpVO vo2 = session.selectOne("emp.one", 100); //뒤에는 파라미터 값을 주면 됨.
		System.out.println(vo2.getEmployee_id()+":"+vo2.getFirst_name()+":"+vo2.getHire_date());
		
		//test3 : 파라미터 입력 해당 레코드 1개 조회
		EmpVO vo3 = session.selectOne("emp.oneVO", new EmpVO(100, "", "", "", "", "", 0)); 
		System.out.println(vo3.getEmployee_id()+":"+vo3.getFirst_name()+":"+vo3.getHire_date());		
		
		//crud : create read update delete
		//		  insert select update delete
		
		//test4: insert:parameterType 필요, resultType 필요
		/*EmpVO vo4 = new EmpVO();
		vo4.setEmployee_id(1002);
		vo4.setFirst_name("first_name");
		vo4.setLast_name("last_name");
		vo4.setEmail("email2@kitri.com");
		vo4.setPhone("010.222.3333");
		vo4.setJob_id("IT_PROG");
		System.out.println("1");
		System.out.println(session.insert("emp.create", vo4));*/
		
		//test4-2: insert:parameterType 필요, resultType 필요
		EmpVO vo4 = new EmpVO();
		//vo4.setEmployee_id(1002);
		vo4.setFirst_name("first_name");
		vo4.setLast_name("last_name");
		vo4.setEmail("email3@kitri.com");
		vo4.setPhone("010.222.3333");
		vo4.setJob_id("IT_PROG");
		System.out.println("1");
		System.out.println(session.insert("emp.createWithSelectKey", vo4));		
		
		//test5: udapte:resultType 필요없는 sql
		//emp.update 매핑 sql 실행
		/*EmpVO vo5 = session.selectOne("emp.one", 1000);
		vo5.setFirst_name("자바");
		vo5.setLast_name("이");
		vo5.setSalary(50000.00);
		vo5.setDepartment_id(80);
		System.out.println(session.update("emp.update", vo5));*/
		
		/*Map<String, String> map = new HashMap<String, String>();
		map.put("e_id", "1001");
		map.put("f_name", "자바");
		map.put("l_name", "이");
		map.put("salary", "50000");
		map.put("d_id", "80");
		session.update("emp.update", map);*/
		
				
		
		//test6: delete:resultType 필요없는 sql
		//emp.delete매핑 sql 실행(사번 1000)
		//session.delete("emp.delete", 1002);
	}
}