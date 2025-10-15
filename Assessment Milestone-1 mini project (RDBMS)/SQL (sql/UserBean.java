package com.example.jdbc.model;


public class UserBean {
private String userId;
private String password;
private String name;
private int incorrectAttempts;
private int lockStatus;
private String userType;


// getters and setters
public String getUserId() { return userId; }
public void setUserId(String userId) { this.userId = userId; }


public String getPassword() { return password; }
public void setPassword(String password) { this.password = password; }


public String getName() { return name; }
public void setName(String name) { this.name = name; }


public int getIncorrectAttempts() { return incorrectAttempts; }
public void setIncorrectAttempts(int incorrectAttempts) { this.incorrectAttempts = incorrectAttempts; }


public int getLockStatus() { return lockStatus; }
public void setLockStatus(int lockStatus) { this.lockStatus = lockStatus; }


public String getUserType() { return userType; }
public void setUserType(String userType) { this.userType = userType; }
}