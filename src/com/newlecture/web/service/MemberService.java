package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Member;

public class MemberService {


	public List<Member> getList() {
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER WHERE PWD='111'";

		List<Member> list = new ArrayList<>();

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
				String nicname = rs.getNString("NICNAME");
				String pwd = rs.getNString("PWD");
				String name = rs.getNString("NAME");

				Member m = new Member();
				m.setId(id);
				m.setNicname(nicname);
				m.setPwd(pwd);
				m.setName(name);

				list.add(m);
					

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
