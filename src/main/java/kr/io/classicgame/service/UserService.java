package kr.io.classicgame.service;

import kr.io.classicgame.domain.Usertable;

public interface UserService {
	
	boolean insertUser(Usertable user);
	
	Usertable getUser(Usertable user);
	
	boolean updateUser(Usertable user);
	
	boolean deleteUser(Usertable user);
	
}
