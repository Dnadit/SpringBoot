package edu.pnu.log;

public interface LogDao {
	
	public void add(String method, String sqlstring, boolean success);
}
