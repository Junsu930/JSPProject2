package edu.kh.jsp.student.model.service;

import static edu.kh.jsp.common.JDBCTemplate.close;
import static edu.kh.jsp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import edu.kh.jsp.student.model.dao.SelectDepartmentDAO;
import edu.kh.jsp.student.model.vo.Student;

public class SelectDepartmentService {

		private SelectDepartmentDAO dao = new SelectDepartmentDAO();
		
		
		public List<Student> selectDepartment(String department) throws Exception {
			
			// Connection 생성
			Connection conn = getConnection();
			
			// DAO 메서드 호출 후 결과 반환 받기
			List<Student> stdList = dao.selectDepartment(conn, department);
			
			// 트랜잭션 처리(DML인 경우에만 진행)
			
			// Connection 객체 반환
			close(conn);
			
			// 결과 반환
			return stdList;
			
		}
	

}
