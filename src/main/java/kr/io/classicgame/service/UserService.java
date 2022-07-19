package kr.io.classicgame.service;

import kr.io.classicgame.domain.Usertable;

public interface UserService {
	
	boolean insertUser(Usertable user);
	
	Usertable getUser(Usertable user);
	
	void updateUser(Usertable user);
	
	void deleteUser(Usertable user);
	
}
