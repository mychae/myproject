package mybatis.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpDAO empDAO;
		
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
