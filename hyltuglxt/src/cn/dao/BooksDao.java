package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


import cn.dome.Books;
import cn.dome.User;
import cn.opinion.Opinion;

public class BooksDao {
	//添加图书
	public int ition(java.sql.Connection con, Books books) throws Exception {

		/*
		 * 锟斤拷锟斤拷锟斤拷要锟斤拷锟斤拷锟捷匡拷锟斤拷胁锟窖拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟捷匡拷锟斤拷锟窖撅拷锟斤拷锟节革拷锟矫伙拷锟斤拷锟斤拷锟斤拷没锟斤拷薹锟斤拷锟斤拷锟接碉拷锟斤拷锟捷匡拷锟斤拷
		 * 锟斤拷锟斤拷锟角诧拷询锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷要锟斤拷executeQuery(),锟斤拷锟斤拷锟斤拷删锟侥的诧拷锟斤拷锟斤拷锟斤拷锟斤拷executeUpdate()
		 */
		String a = "";
		String sql1 = "select * from books where number = ?";//
		java.sql.PreparedStatement pstmt1 = (java.sql.PreparedStatement) con.prepareStatement(sql1);
		pstmt1.setInt(1, books.getNumber());
		ResultSet rs = pstmt1.executeQuery();
		if (rs.next()) {
			return 0;
						}
		String sql = "insert into books values(?,?,?,?,?,?)";
		java.sql.PreparedStatement pstmt = (java.sql.PreparedStatement) con.prepareStatement(sql);
		pstmt.setInt(1, books.getNumber());
		pstmt.setString(2, books.getBookname());
		pstmt.setString(3, books.getWriter());
		pstmt.setInt(4, books.getMath());
		pstmt.setString(5, a );
		pstmt.setString(6, a);

		return pstmt.executeUpdate();
	}
	
	
	//查找图书
	public Vector inquire(Connection con, Books b)throws Exception {
		Vector rowData = new Vector();
		String sql = "select * from books where number=number";
		StringBuffer sb = new StringBuffer(sql);
		//if(Opinion.low(b.getNumber()))
		if(b.getNumber()>0)
		{
			sb.append(" and books.number like '%" + b.getNumber() + "%'");
		}
		if(Opinion.low(b.getBookname()))
		{
			sb.append(" and books.bookname like '%" + b.getBookname() + "%'");
		}
		if(Opinion.low(b.getWriter()))
		{
			sb.append(" and books.writer like '%" + b.getWriter() + "%'");
		}
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sb.toString());
		ResultSet resultSet = pstmt.executeQuery();
//		System.out.println("####"+resultSet.next());
		while(resultSet.next())
		{
			Vector hang = new Vector();
			hang.add(resultSet.getInt("number"));
			hang.add(resultSet.getString("bookname"));
			hang.add(resultSet.getString("writer"));
			hang.add(resultSet.getInt("math"));
			hang.add(resultSet.getString("borrow"));
			rowData.add(hang);
		}

		return rowData;
//		String sql = "select * from books where number=number";
//		Vector rowData = new Vector();
//		StringBuffer sb = new StringBuffer(sql);
//		if(Opinion.low(b.getNumber()))
//		{
//			sb.append(" and books.number like '%" + b.getNumber() + "%'");
//		}
//		if(Opinion.low(b.getBookname()))
//		{
//			sb.append(" and books.writer like '%" + b.getBookname() + "%'");
//		}
//		if(Opinion.low(b.getWriter()))
//		{
//			sb.append(" and books.math like '%" + b.getWriter() + "%'");
//		}
//		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sb.toString());
//		ResultSet resultSet = pstmt.executeQuery();
//		while(resultSet.next()) {
////			String id=resultSet.getString("id");
////			String name=resultSet.getString("name"); 
////			String room=resultSet.getString("room"); 
////			String	password=resultSet.getString("password");
////			System.out.println("ID:"+id+" 锟斤拷锟斤拷锟斤拷"+name+" 锟洁级锟斤拷"+room+ " 锟斤拷锟斤拷:" + password);
//			Vector hang = new Vector();
//			hang.add(resultSet.getInt(1));
//			hang.add(resultSet.getString(2));
//			hang.add(resultSet.getString(3));
//			hang.add(resultSet.getInt(4));
//			rowData.add(hang);
//		}
//		return rowData;
	}

	//删除图书
	public int delete(Connection con, int number) throws Exception {
		String sql1 = "select * from books where number = ? ";
		PreparedStatement prepar = (PreparedStatement) con.prepareStatement(sql1);
		Books b =new Books();
		prepar.setInt(1,b.getNumber());
		ResultSet rs = prepar.executeQuery();
		if(rs.next())
		{
			return 0;
		}
		String sql = "delete from books where  number = ?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setInt(1,number);
		return pstmt.executeUpdate();
}
	//修改
	public int update(Connection con, Books b)throws Exception {
		int f=0;
		String sql1 = "select * from books where number = ?";//sql锟斤拷锟�
		PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
		pstmt1.setInt(1, b.getNumber());//锟斤拷锟斤拷锟�1锟斤拷为锟斤拷一锟斤拷锟绞猴拷
		ResultSet rs = pstmt1.executeQuery();
		if (rs.next()) {
			f=1;
		}
		if(f==1){
		String sql = "UPDATE books SET bookname = ?,writer = ?,math = ? WHERE number = ?"; 
		PreparedStatement pstmt3 = (PreparedStatement) con.prepareStatement(sql);
		pstmt3.setString(1, b.getBookname());
		pstmt3.setString(2, b.getWriter());
		pstmt3.setInt(3,b.getMath());
		pstmt3.setInt(4, b.getNumber());
		return pstmt3.executeUpdate();
		}
		else {
			return 0;
		}
	}
}
