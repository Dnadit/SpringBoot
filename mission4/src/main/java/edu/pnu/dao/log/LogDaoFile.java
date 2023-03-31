package edu.pnu.dao.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class LogDaoFile implements LogDao {
	private File file = new File("D:\\Yuhyun\\SpringBootQuickStart\\output\\log.txt");

	@Override
	public void addReq(String method, String sqlstring, boolean success) {
		try {
			if (!file.exists())
				file.createNewFile();
	
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);
	
			writer.write("method : " + method + ", sqlstring : " + sqlstring + ", regidate : " + new Date(System.currentTimeMillis()) + ", success : " + success);
			
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
