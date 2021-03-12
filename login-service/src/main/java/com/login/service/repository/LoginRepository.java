package com.login.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.service.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

	LoginEntity findByUserIdAndPassword(String userId, String password);

}
