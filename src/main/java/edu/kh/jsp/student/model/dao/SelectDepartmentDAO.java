package edu.kh.jsp.student.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static edu.kh.jsp.common.JDBCTemplate.*;

import edu.kh.jsp.student.model.vo.Student;

public class SelectDepartmentDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;

	public SelectDepartmentDAO(){
		try {
			String filePath = SelectDepartmentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();
			
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	public List<Student> selectDepartment(Connection conn, String department) throws Exception{
		
		List<Student> stdList = new ArrayList<>();
		
		try {
		String sql = prop.getProperty("selectDepartment");
		
		
		pstmt= conn.prepareStatement(sql);
		String dep = "%" +department +"%";
		pstmt.setString(1,dep);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String studentNo = rs.getString("STUDENT_NO");
			String studentName = rs.getString("STUDENT_NAME");
			String studentAddress = rs.getString("STUDENT_ADDRESS");
			String departmentName = rs.getString("DEPARTMENT_NAME");
			
			stdList.add(new Student(studentNo, studentName, studentAddress, departmentName));
			
		}
		
		}finally {
			
			close(rs);
			close(pstmt);
		}
		
		return stdList;

	}

}
