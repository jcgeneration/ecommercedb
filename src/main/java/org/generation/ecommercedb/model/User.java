package org.generation.ecommercedb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable = false)
	private Long id;
	private String username;
	private String password;
	public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }//constructor

    public User(){}//default constructor

    public Long getId() {
        return id;
    }//getId

    public void setId(Long id) {
        this.id = id;
    }//setId

    public String getUsername() {
        return username;
    }//getUserName

    public void setUsername(String username) {
        this.username = username;
    }//setUserName

    public String getPassword() {
        return password;
    }//getPassword

    public void setPassword(String password) {
        this.password = password;
    }//setPassword

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }//toString
	
} //class User
