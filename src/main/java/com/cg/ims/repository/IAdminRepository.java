package com.cg.ims.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.ims.dto.AdminDTO;

public interface IAdminRepository extends JpaRepository<AdminDTO, Integer> {
	@Query("select admin from AdminDTO admin where admin.id=:id and admin.password=:pwd")
	AdminDTO validateUser(@Param("id") int id, @Param("pwd") String pwd);

	public AdminDTO findByUserNameAndPassword(String userName, String password);

	Optional<AdminDTO> findUserByUserName(String userName);

}
