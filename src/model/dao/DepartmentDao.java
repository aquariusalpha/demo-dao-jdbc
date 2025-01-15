package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	void insert(Deprecated obj);
	void update(Deprecated obj);
	void deleteById(Integer id);
	Department findById(Integer id);
	List<Department> findAll();
}
