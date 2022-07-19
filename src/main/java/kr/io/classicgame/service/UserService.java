package kr.io.classicgame.service;

import kr.io.classicgame.domain.Usertable;

public interface UserService {
	
	boolean insertUser(Usertable user);
	
	Usertable getUser(Usertable user);
	
	void updateUserName(Usertable user);
	
	void updateUserMail(Usertable user);
	
	void updateUserPw(Usertable user);
	
	void updateUserNickname(Usertable user);
	
	void deleteUser(Usertable user);
	
}
