package com.flyaway.Dao;

import java.util.List;

import com.flyaway.entities.Places;

public interface PlacesDao {
	void insert(Places place);
	List<Places> getAll();
	void update (Places place, int id);
	void delete (int id);
	Places get(String placename);
}
