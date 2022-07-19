package kr.io.classicgame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.io.classicgame.domain.Usertable;

public interface UserRepository extends JpaRepository<Usertable, String>{

}
