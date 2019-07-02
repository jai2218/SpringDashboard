package com.jai.SpringDashboard.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jai.SpringDashboard.model.UserRegistrationDTO;

@Repository
public class UserRegistrationDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationDao.class);
	
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int registerUser( UserRegistrationDTO userReg) {
		
		String sql = "INSERT INTO USER_DTLS(NAME,EMAIL_ID,PASSWORD,CNFRM_PASSWORD,DOB,MOBILE,USER_NAME,GENDER) values('"+userReg.getName()+"','"+userReg.getEmail()+"','"+userReg.getPassword()+"','"+userReg.getCnfrmPassword()+"','"+userReg.getDob()+"','"+userReg.getMobileNumber()+"','"+userReg.getUserName()+"','"+userReg.getGender()+"')";
		System.out.println("sql save : ========================================================================================" + sql);
		logger.info("sql info : " + sql);
		logger.debug("sql debug : " + sql);
		
		return template.update(sql);
		
	}

}
