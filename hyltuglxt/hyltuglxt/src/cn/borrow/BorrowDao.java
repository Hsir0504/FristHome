package cn.borrow;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import cn.dome.Books;
import cn.dome.User;

public class BorrowDao {
	//借书
	public int borrow(Connection con, Books b)throws Exception {
		int f=0;
		String sql1 = "select * from books where number = ?";//sql语句
		PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
		pstmt1.setInt(1, b.getNumber());//这里的1即为第一个问号
		ResultSet rs = pstmt1.executeQuery();
		if (rs.next()) {
			f=1;
		}
		if(f==1){
		String sql = "UPDATE books SET borrow = ? , people = ? WHERE number = ?"; 
		PreparedStatement pstmt3 = (PreparedStatement) con.prepareStatement(sql);    
		pstmt3.setString(1, b.getBorrow());
		pstmt3.setString(2, b.getPeople());
		pstmt3.setInt(3, b.getNumber());
		return pstmt3.executeUpdate();
		}
		else {
			return 0;
		}
	}
	//查询是否已经借走
	public boolean  ustate(Connection con, Books b) throws Exception {
		String sql1 =  "select *from books where number = ? and borrow = '已借出' " ;
		PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
		pstmt1.setInt(1, b.getNumber());
		ResultSet resultSet1 = pstmt1.executeQuery();
		return resultSet1.next();
	}
	//还书
	public int imback(Connection con, Books b)throws Exception {
		int f=0;
		String sql1 = "select * from books where number = ?";//sql语句
		PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
		pstmt1.setInt(1, b.getNumber());//这里的1即为第一个问号
		ResultSet rs = pstmt1.executeQuery();
		if (rs.next()) {
			f=1;
		}
		if(f==1){
		String sql = "UPDATE books SET borrow = ? WHERE number = ?"; 
		PreparedStatement pstmt3 = (PreparedStatement) con.prepareStatement(sql);    
		pstmt3.setString(1, b.getBorrow());
		pstmt3.setInt(2, b.getNumber());
		return pstmt3.executeUpdate();
		}
		else {
			return 0;
		}
	}
	public boolean  Aimback(Connection con, Books b) throws Exception {
		String sql1 =  "select *from books where number = ? and borrow = '已借出'  and people =? " ;
		PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
		pstmt1.setInt(1, b.getNumber());
		pstmt1.setString(2, b.getPeople());
		ResultSet resultSet1 = pstmt1.executeQuery();
		return resultSet1.next();
	}
	
	
}
