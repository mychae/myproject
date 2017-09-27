package mybatis.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {
	public static void main(String args[]) throws Exception{
		ApplicationContext factory = new ClassPathXmlApplicationContext("mybatis/spring/spring-mybatis.xml");
		//@, <bean 모든 객체 다 조회
		// dataSource, sqlSessionFactory, sqlSession
		// empDAO, service
		EmpServiceImpl service = factory.getBean("service", mybatis.spring.EmpServiceImpl.class);
		
		//2. bean 조회
		//test1 : 테이블 전체 레코드 조회
		List<EmpVO> list = service.getAllEmp();
		for(EmpVO vo : list){
			System.out.println
			(vo.getEmployee_id()+vo.getFirst_name()+vo.getPhone());
		}
		//test2 : 파라미터 입력 해당 레코드 1개 조회
		/*EmpVO vo2 = service.getOneEmp(1000);
		System.out.println(vo2.getEmployee_id()+":"+vo2.getFirst_name()+":"+vo2.getHire_date());*/
				
		//test4-2: insert:parameterType 필요, resultType 필요
		/*EmpVO vo4 = new EmpVO();
		//vo4.setEmployee_id(1002);
		vo4.setFirst_name("first_name");
		vo4.setLast_name("last_name");
		vo4.setEmail("email33@kitri.com");
		vo4.setPhone("010.222.3333");
		vo4.setJob_id("IT_PROG");
		System.out.println("1");
		System.out.println("삽입행 = " + service.insertEmp(vo4));*/		
		
		//test5: udapte:resultType 필요없는 sql
		//emp.update 매핑 sql 실행
		/*EmpVO vo5 = new EmpVO();
		vo5.setEmployee_id(1118);
		vo5.setFirst_name("자바");
		vo5.setLast_name("이");
		vo5.setSalary(60000);
		vo5.setDepartment_id(80);
		System.out.println("수정행 = " + service.updateEmp(vo5));*/
		
		//test6: delete:resultType 필요없는 sql
		//System.out.println("삭제행 = " + service.deleteEmp(1117));
	}
}