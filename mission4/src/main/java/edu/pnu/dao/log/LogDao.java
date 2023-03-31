package edu.pnu.dao.log;

public interface LogDao {
	void addReq(String method, String sqlstring, boolean success);
}
