package mybatis.spring;

import java.util.List;

//main, controller 요청 1개 기능 - 1개 메소드
//주문 기능 - bakery테이블 수량 업데이트, 1개 레코드 리턴
public interface EmpService {
	//전체 employee 조회
	List<EmpVO> getAllEmp();
	//사번 employee 조회
	EmpVO getOneEmp(int id);
	//저장
	int insertEmp(EmpVO vo);
	//수정
	int updateEmp(EmpVO vo);
	//삭제
	int deleteEmp(int id);
}
