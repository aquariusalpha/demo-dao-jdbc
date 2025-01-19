package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

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
	

		System.out.println("=== TESTE 2 findAll ===");
		List<Department> listDepartmentAll = departmentDao.findAll();

		for (Department obj : listDepartmentAll){
			System.out.println(obj);
		}
		
		
		
		sc.close();
	}

}
