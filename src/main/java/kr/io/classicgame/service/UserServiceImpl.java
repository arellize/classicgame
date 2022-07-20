package kr.io.classicgame.service;

import java.util.Optional;

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

	public boolean insertUser(Usertable user) {
		// null인 경우 @ExceptionHandler를 통해 예외처리 필요. 닉네임, mail도 검증 필요.
		boolean result = false;

		if (getUser(user) == null) {
			userRepo.save(user);
			result = true;
		}
		return result;
	}

	public boolean deleteUser(Usertable user) {

		boolean result = false;

		if (getUser(user) != null) {
			userRepo.deleteById(user.getId());
			result = true;
		}
		return result;
	}

	public boolean updateUser(Usertable user) {

		boolean result = false;

		if (getUser(user) != null) {
			Usertable findUser = userRepo.findById(user.getId()).get();
			findUser.setNickname(user.getNickname());
			findUser.setName(user.getName());
			findUser.setPw(user.getPw());
			findUser.setMail(user.getMail());
			userRepo.save(findUser);
			result = true;
		}
		return result;
	}
}