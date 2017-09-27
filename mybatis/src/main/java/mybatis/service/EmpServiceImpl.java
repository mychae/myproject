package mybatis.service;

import java.util.List;

public class EmpServiceImpl implements EmpService {
	EmpDAO empDAO;
	
	public void setEmpDAO(EmpDAO dao){
		empDAO = dao;
	}
	
	public List<EmpVO> getAllEmp() {
		//emp.all 매핑 sql 실행
		return empDAO.getAllEmp();
	}

	public EmpVO getOneEmp(int id) {
		return empDAO.getOneEmp(id);
	}

	public int insertEmp(EmpVO vo) {
		return empDAO.insertEmp(vo);
	}

	public int updateEmp(EmpVO vo) {
		return empDAO.updateEmp(vo);
	}

	@Override
	public int deleteEmp(int id) {
		return empDAO.deleteEmp(id);
	}
	

}
