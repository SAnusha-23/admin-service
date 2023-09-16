package com.cg.ims.config;

import java.util.Map;

import com.cg.ims.dto.AdminDTO;

public interface JwtGeneratorInterface {
	Map<String, String> generateToken(AdminDTO user);

}
