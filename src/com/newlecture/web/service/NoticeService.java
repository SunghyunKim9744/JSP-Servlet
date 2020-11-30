package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {


	public List<Notice> getList() {
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE";

		List<Notice> list = new ArrayList<>();

		try
		{
			// Driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DB 연결
			Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");

			// DB 실행
			Statement st = con.createStatement();

			// DB 결과
			ResultSet rs = st.executeQuery(sql);

//			String[] nicnames= new String[2];

			while (rs.next()) {
	
				int id = rs.getInt("ID");
				String title = rs.getNString("TITLE");
				String writerId = rs.getNString("WRITER_ID");
				String content = rs.getNString("CONTENT");
				Date regdate = rs.getDate("REGDATE");
				int hit = rs.getInt("HIT");
				String files  = rs.getNString("FILES");

				Notice n = new Notice(
						id,
						title,
						writerId,
						content,
						regdate,
						hit,
						files
				);
			
				list.add(n);
			}

			rs.close();
			st.close();
			con.close();
		}catch(
		SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
