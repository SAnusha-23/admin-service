package com.cg.ims.service;

import java.util.List;

import com.cg.ims.dto.AdminDTO;
import com.cg.ims.exception.UserNotFoundException;

public interface IAdminService {
	public void saveUser(AdminDTO user);
    public AdminDTO getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
    public List<AdminDTO> getAllAdmins() ;
	public AdminDTO changePassword(AdminDTO user) throws UserNotFoundException;

}
