package com.flyaway.Dao;

import java.util.List;

import com.flyaway.entities.Flights;

public interface FlightsDao {
	void insert(Flights flight);
	void update(int id,Flights flight);
	void delete (int id);
	List<Flights> getAll();
	List<Flights> getFlight(String source, String Destination);
	Flights getById(int id);
	
}
