package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1 findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
				
		System.out.println("=== TESTE 2 findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> listSeller = sellerDao.findByDepartment(department);

		for (Seller obj : listSeller){
			System.out.println(obj);
		}
		System.out.println("=== TESTE 3 findAll ===");
		List<Seller> listSellerAll = sellerDao.findAll();

		for (Seller obj : listSellerAll){
			System.out.println(obj);
		}

		System.out.println("=== TESTE 4 INSERT ===");
		Department departmentInsert = new Department(2, null);
		Seller newSeller = new Seller(null, "Darci Jorge", "aquarius.cd@gmail.com", new Date(), 3200.0, departmentInsert);
		sellerDao.insert(newSeller);

		System.out.println("Inserted newSeller Id " + newSeller.getId());
	

		System.out.println("=== TESTE 5 UPDATE ===");
		Seller sellerupd = sellerDao.findById(1);

		sellerupd.setName("Nome Alterado");
		sellerDao.update(sellerupd);

		System.out.println("Update completed");
}

	




}
