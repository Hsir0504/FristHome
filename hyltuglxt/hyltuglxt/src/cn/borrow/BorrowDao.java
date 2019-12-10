package cn.borrow;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import cn.dome.Books;
import cn.dome.User;

public class BorrowDao {
	//����
	public int borrow(Connection con, Books b)throws Exception {
		int f=0;
		String sql1 = "select * from books where number = ?";//sql���
		PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
		pstmt1.setInt(1, b.getNumber());//�����1��Ϊ��һ���ʺ�
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
	//��ѯ�Ƿ��Ѿ�����
	public boolean  ustate(Connection con, Books b) throws Exception {
		String sql1 =  "select *from books where number = ? and borrow = '�ѽ��' " ;
		PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
		pstmt1.setInt(1, b.getNumber());
		ResultSet resultSet1 = pstmt1.executeQuery();
		return resultSet1.next();
	}
	//����
	public int imback(Connection con, Books b)throws Exception {
		int f=0;
		String sql1 = "select * from books where number = ?";//sql���
		PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
		pstmt1.setInt(1, b.getNumber());//�����1��Ϊ��һ���ʺ�
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
		String sql1 =  "select *from books where number = ? and borrow = '�ѽ��'  and people =? " ;
		PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
		pstmt1.setInt(1, b.getNumber());
		pstmt1.setString(2, b.getPeople());
		ResultSet resultSet1 = pstmt1.executeQuery();
		return resultSet1.next();
	}
	
	
}
