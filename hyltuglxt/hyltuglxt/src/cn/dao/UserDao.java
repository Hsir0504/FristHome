package cn.dao;
//实现增删改查

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import com.mysql.jdbc.PreparedStatement;

import cn.dome.Books;
import cn.dome.User;
import cn.opinion.Opinion;



	/*
	 * 该类实现对用户信息的操作，主要是用于用户信息在数据库中的增删改查
	 * 
	 */

	public class UserDao {
		/*
		 * 添加用户
		 */
		public int insert(java.sql.Connection con, User user) throws Exception {

			/*
			 * 首先需要对数据库进行查询操作，如果数据库中已经存在该用户，则该用户无法被添加到数据库中
			 * 这里是查询操作，故需要用executeQuery(),对于怎删改的操作可以用executeUpdate()
			 */
			String sql1 = "select * from user where Id = ?";//sql语句
			PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
			pstmt1.setString(1, user.getId());//这里的1即为第一个问号
			ResultSet rs = pstmt1.executeQuery();
			if (rs.next()) {
				return 0;
			}
			String sql = "insert into user values(?,?,?,?,?,?)";
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getRoom());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getPasswords());
			pstmt.setString(6, user.getState());
			System.out.println(user.getId());
			System.out.println(user.getName());
			System.out.println(user.getRoom());
			System.out.println(user.getPassword());

			return pstmt.executeUpdate();
			
		}

		/*
		 * 登录账户
		 */
		public boolean login(java.sql.Connection con, User user) throws Exception {
//			String sql1 = "select *from user where Id = ? and state = 1";
//			PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
//			pstmt1.setString(1, user.getId());
//			ResultSet resultSet1 = pstmt1.executeQuery();
//			if(resultSet1.next() == false)
//			{
				String sql = "select *from user where Id = ? and password = ?";
				PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
				pstmt.setString(1, user.getId());
				pstmt.setString(2, user.getPassword());
				ResultSet resultSet = pstmt.executeQuery();
				return resultSet.next();
//			}
//			else 
//				return true;
		}
		//判断是否冻结
		public boolean  ustate(Connection con, User user) throws Exception {
			String sql1 = "select *from user where Id = ? and state = 1";
			PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
			pstmt1.setString(1, user.getId());
			ResultSet resultSet1 = pstmt1.executeQuery();
			return resultSet1.next();
		}
		//删除语句
		public int delete(Connection con, String id) throws Exception {
			String sql1 = "select * from user where  id = ? ";
			PreparedStatement prepar = (PreparedStatement) con.prepareStatement(sql1);
			User b =new User();
			prepar.setString(1,b.getId());
			ResultSet rs = prepar.executeQuery();
			if(rs.next())
			{
				return 0;
			}
			String sql = "delete from user where id = ?";
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		}
		
		//查询用户
	
		public Vector inquire(Connection con, User u)throws Exception {
			String sql = "select * from user where id=id";
			Vector rowData = new Vector();
			StringBuffer sb = new StringBuffer(sql);
			if(Opinion.low(u.getId()))
			{
				sb.append(" and user.id like '%" + u.getId() + "%'");
			}
			if(Opinion.low(u.getName()))
			{
				sb.append(" and user.name like '%" + u.getName() + "%'");
			}
			if(Opinion.low(u.getRoom()))
			{
				sb.append(" and user.room like '%" + u.getRoom() + "%'");
			}
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sb.toString());
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
//				String id=resultSet.getString("id");
//				String name=resultSet.getString("name"); 
//				String room=resultSet.getString("room"); 
//				String	password=resultSet.getString("password");
//				System.out.println("ID:"+id+" 姓名："+name+" 班级："+room+ " 密码:" + password);
				Vector hang = new Vector();
				hang.add(resultSet.getString("id"));
				hang.add(resultSet.getString("name"));
				hang.add(resultSet.getString("room"));
				hang.add(resultSet.getString("password"));
				hang.add(resultSet.getString("passwords"));
				rowData.add(hang);
			}
			return rowData;
		}
		//修改语句
		public int update(Connection con, User u)throws Exception {
			int f=0;
			String sql1 = "select * from user where id = ?";//sql语句
			PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
			pstmt1.setString(1, u.getId());//这里的1即为第一个问号
			ResultSet rs = pstmt1.executeQuery();
			if (rs.next()) {
				f=1;
			}
			if(f==1){
			String sql = "UPDATE user SET name = ?,room = ?,password = ? WHERE id = ?";
			PreparedStatement pstmt3 = (PreparedStatement) con.prepareStatement(sql);
			pstmt3.setString(1,u.getName() );
			pstmt3.setString(2, u.getRoom());
			pstmt3.setString(3,u.getPassword());
			pstmt3.setString(4, u.getId());
			return pstmt3.executeUpdate();
			}
			else {
				return 0;
			}
		}
		//账号冻结
		public int dongjie(Connection con, User u) throws Exception{
			int f=0;
			String sql1 = "select * from user where id = ?";//sql语句
			PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
			pstmt1.setString(1, u.getId());//这里的1即为第一个问号
			ResultSet rs = pstmt1.executeQuery();
			if (rs.next()) {
				f=1;
			}
			if(f==1)
			{
			String sql = "UPDATE user SET state = ? WHERE id = ?";
			PreparedStatement pstmt3 = (PreparedStatement) con.prepareStatement(sql);
			pstmt3.setString(1,u.getState());
			pstmt3.setString(2,u.getId());
			return pstmt3.executeUpdate();
			}
			else {
				return 0;
			}
		}


}