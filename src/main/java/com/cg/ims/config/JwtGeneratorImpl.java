package com.cg.ims.config;




import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cg.ims.dto.AdminDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtGeneratorImpl implements JwtGeneratorInterface{
	//@Value("${jwt.secret}")
	  private String secret;
	  //@Value("${app.jwttoken.message}")
	  private String message;
	  
	  @Override
	  public Map<String, String> generateToken(AdminDTO user) {
	    String jwtToken="";
	    jwtToken = Jwts.builder().setSubject(user.getUserName()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secret").compact();
	    Map<String, String> jwtTokenGen = new HashMap<>();
	    jwtTokenGen.put("token", jwtToken);
	    jwtTokenGen.put("message", message);
	    return jwtTokenGen;
	  }
	

}
