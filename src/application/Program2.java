package application;

import java.util.Date;
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
		
		System.out.println("\n=== TEST 3: insert =======");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());	
		
		System.out.println("\n=== TEST 4: update =======");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");

		System.out.println("=== TESTE 5 DELETE ===");
		System.out.print("Enter Id for deletion test: ");
		Integer idDelete = sc.nextInt();
		departmentDao.deleteById(idDelete);
		System.out.println("Delete completed");
		

		
		
		sc.close();
	}

}
