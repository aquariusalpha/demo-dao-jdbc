package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1 findById ===");
		Integer depId = 3;
		Department department = departmentDao.findById(depId);
		
		if (department == null){
			System.out.println("Departmet " + depId + " not found");		
			
		}else{
			System.out.println(department);		
		}	
	
		sc.close();
	}

}
