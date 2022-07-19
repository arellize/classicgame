package kr.io.classicgame.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.io.classicgame.dao.UserRepository;
import kr.io.classicgame.domain.Usertable;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	public Usertable getUser(Usertable user) {
		Optional<Usertable> findUser = userRepo.findById(user.getId());
		if (findUser.isPresent()) {
			return findUser.get();
		} else {
			return null;
		}
	}
	
	@Transactional
	public boolean insertUser(Usertable user) {
		// null인 경우 @ExceptionHandler를 통해 예외처리 필요. 닉네임, mail도 검증 필요.
		boolean result = false;
		
		if (getUser(user) == null) {
			userRepo.save(user);
			result = true;
		}
		return result;
	}


	public void updateUserName(Usertable user) {
		Usertable findUser = userRepo.findById(user.getId()).get();
		findUser.setName(user.getName());
		userRepo.save(findUser);
	}

	public void updateUserPw(Usertable user) {
		Usertable findUser = userRepo.findById(user.getId()).get();
		findUser.setPw(user.getPw());
		userRepo.save(findUser);
	}

	public void updateUserMail(Usertable user) {
		Usertable findUser = userRepo.findById(user.getId()).get();
		findUser.setMail(user.getMail());
		userRepo.save(findUser);
	}

	public void updateUserNickname(Usertable user) {
		Usertable findUser = userRepo.findById(user.getId()).get();
		findUser.setNickname(user.getNickname());
		userRepo.save(findUser);
	}
	
	public void deleteUser(Usertable user) {
		userRepo.deleteById(user.getId());
	}

}
