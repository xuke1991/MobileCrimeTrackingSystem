package com.amaker.dao;
import com.amaker.entity.People;
/**
 * @author KeXu
 * Crinmals Wanted
 */
public interface PeopleDao {
	
	public String getString(String idno);
	
	public People get(String idno);
}
