package com.example.jdbc.dao;
try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setString(1, user.getUserId());
ps.setString(2, user.getPassword());
ps.setString(3, user.getName());
ps.setInt(4, user.getIncorrectAttempts());
ps.setInt(5, user.getLockStatus());
ps.setString(6, user.getUserType());
int inserted = ps.executeUpdate();
return inserted > 0 ? "Success" : "Fail";
} catch (SQLException e) {
e.printStackTrace();
return "Fail";
}
}


// 8. addUser_2 (insert only if lockStatus is 0)
public String addUser_2(UserBean user) {
if (user.getLockStatus() != 0) return "Fail";
return addUser_1(user);
}


// 9. getUsersByType -> return list of UserBean
public List<UserBean> getUsersByType(String userType) {
List<UserBean> list = new ArrayList<>();
String sql = "SELECT * FROM USERS WHERE USERTYPE = ?";
try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setString(1, userType);
try (ResultSet rs = ps.executeQuery()) {
while (rs.next()) {
UserBean u = new UserBean();
u.setUserId(rs.getString("USERID"));
u.setPassword(rs.getString("PASSWORD"));
u.setName(rs.getString("NAME"));
u.setIncorrectAttempts(rs.getInt("INCORRECTATTEMPTS"));
u.setLockStatus(rs.getInt("LOCKSTATUS"));
u.setUserType(rs.getString("USERTYPE"));
list.add(u);
}
}
} catch (SQLException e) {
e.printStackTrace();
}
return list;
}


// 10. storeAllRecords -> return list of all users
public List<UserBean> storeAllRecords() {
List<UserBean> list = new ArrayList<>();