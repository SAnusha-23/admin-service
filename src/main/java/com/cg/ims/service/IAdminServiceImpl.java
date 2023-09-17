package com.cg.ims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ims.dto.AdminDTO;
import com.cg.ims.exception.AdminException;
import com.cg.ims.exception.UserNotFoundException;
import com.cg.ims.repository.IAdminRepository;

@Service
public class IAdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminRepository adminRepository;

	public static final String ADMIN = "ADMIN";

	public List<AdminDTO> getAllAdmins() {
		List<AdminDTO> list = adminRepository.findAll();
		return list;
	}

	@Override
	public void saveUser(AdminDTO user) {
		adminRepository.save(user);
	}

	@Override
	public AdminDTO getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
		AdminDTO user = adminRepository.findByUserNameAndPassword(name, password);
		if (user == null) {
			throw new UserNotFoundException("Invalid id and password");
		}
		return user;
	}

	public AdminDTO validateUser(int id, String pwd) throws AdminException {
		AdminDTO credentials = adminRepository.validateUser(id, pwd);
		if (credentials == null) {
			throw new AdminException("Login credentials mismatched");
		} else {
			return credentials;

		}

	}

	public AdminDTO viewUser(int userId) {
		return adminRepository.findById(userId).get();
	}

	@Override
	public AdminDTO changePassword(AdminDTO user) throws UserNotFoundException {
		String userName = user.getUserName();
		Optional<AdminDTO> repUsers = adminRepository.findUserByUserName(userName);
		AdminDTO u = repUsers.orElseThrow(() -> new UserNotFoundException("User Not Found"));
		u.setPassword(user.getPassword());
		adminRepository.save(u);
		return u;
	}

}
