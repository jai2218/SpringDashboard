package com.jai.SpringDashboard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jai.SpringDashboard.beans.UserDetails;

@Repository
public class UserDetailsDao {  
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(UserDetails user) {
		//String sql = "insert into test" + "values('"+user.getName()+"',"+user.getEmail()+"',"+user.getAddress()+"')";
		String sql = "INSERT INTO user(NAME,EMAIL,ADDRESS) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getAddress()+"')";
		System.out.println("sql save : " + sql);
		return template.update(sql);		
	}
	
	public int update(UserDetails user){    
	    String sql = "update user set name='"+user.getName()+"', email='"+user.getEmail()+"',address='"+user.getAddress()+"' where id='"+user.getId()+"'";    
	    return template.update(sql);    
	}    
	
	public int delete(int id){    
	    String sql = "delete from user where id="+id+"";    
	    return template.update(sql);    
	}    
	
	public UserDetails getUserById(int id) {
		String sql = "select * from user where id = ?";
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<UserDetails>(UserDetails.class));
	}
	
	public List<UserDetails> getUserDetails(){
		
		return template.query("select * from user", new RowMapper<UserDetails>() {

			@Override
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				UserDetails user = new UserDetails();
				
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setAddress(rs.getString(4));
				return user;
			}
			
		});
		
	}
	

}