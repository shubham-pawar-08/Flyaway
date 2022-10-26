package com.flyaway.Dao;

import java.util.List;

import com.flyaway.entities.Airlines;

public interface AirlinesDao {
	void insert(Airlines airline);
	void update(int ano,Airlines airline);
	List<Airlines> getAll();
	void delete(int ano);
}
