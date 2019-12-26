package cn.dao;
//瀹炵幇澧炲垹鏀规煡

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import com.mysql.jdbc.PreparedStatement;

import cn.dome.Books;
import cn.dome.User;
import cn.opinion.Opinion;



	/*
	 * 璇ョ被瀹炵幇瀵圭敤鎴蜂俊鎭殑鎿嶄綔锛屼富瑕佹槸鐢ㄤ簬鐢ㄦ埛淇℃伅鍦ㄦ暟鎹簱涓殑澧炲垹鏀规煡
	 * 
	 */

	public class UserDao {
		/*
		 * 娣诲姞鐢ㄦ埛
		 */
		public int insert(java.sql.Connection con, User user) throws Exception {

			/*
			 * 棣栧厛闇�瑕佸鏁版嵁搴撹繘琛屾煡璇㈡搷浣滐紝濡傛灉鏁版嵁搴撲腑宸茬粡瀛樺湪璇ョ敤鎴凤紝鍒欒鐢ㄦ埛鏃犳硶琚坊鍔犲埌鏁版嵁搴撲腑
			 * 杩欓噷鏄煡璇㈡搷浣滐紝鏁呴渶瑕佺敤executeQuery(),瀵逛簬鎬庡垹鏀圭殑鎿嶄綔鍙互鐢╡xecuteUpdate()
			 */
			String sql1 = "select * from user where Id = ?";//sql璇彞
			PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
			pstmt1.setString(1, user.getId());//杩欓噷鐨�1鍗充负绗竴涓棶鍙�
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


			return pstmt.executeUpdate();
			
		}

		/*
		 * 鐧诲綍璐︽埛
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
		//鍒ゆ柇鏄惁鍐荤粨
		public boolean  ustate(Connection con, User user) throws Exception {
			String sql1 = "select *from user where Id = ? and state = 1";
			PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
			pstmt1.setString(1, user.getId());
			ResultSet resultSet1 = pstmt1.executeQuery();
			return resultSet1.next();
		}
		//鍒犻櫎璇彞
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
		
		//鏌ヨ鐢ㄦ埛
	
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
//				System.out.println("ID:"+id+" 濮撳悕锛�"+name+" 鐝骇锛�"+room+ " 瀵嗙爜:" + password);
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
		//淇敼璇彞
		public int update(Connection con, User u)throws Exception {
			int f=0;
			String sql1 = "select * from user where id = ?";//sql璇彞
			PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
			pstmt1.setString(1, u.getId());//杩欓噷鐨�1鍗充负绗竴涓棶鍙�
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
		//璐﹀彿鍐荤粨
		public int dongjie(Connection con, User u) throws Exception{
			int f=0;
			String sql1 = "select * from user where id = ?";//sql璇彞
			PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql1);
			pstmt1.setString(1, u.getId());//杩欓噷鐨�1鍗充负绗竴涓棶鍙�
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