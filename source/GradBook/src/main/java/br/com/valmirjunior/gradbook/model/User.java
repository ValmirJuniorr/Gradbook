package br.com.valmirjunior.gradbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = Consts.SCHEMA, name = Consts.TABLE_USER, uniqueConstraints = {
		@UniqueConstraint(name = Consts.UNIQUE_CONSTRAINT_USER, columnNames = { Consts.COLUMN_LOGIN_USER }) })
@SequenceGenerator(schema = Consts.SCHEMA, name = Consts.SEQUENCE_USER, sequenceName = Consts.SEQUENCE_NAME_USER, allocationSize = Consts.ALLOCATION_SIZE)

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Consts.SEQUENCE_USER)
	@Column(name = Consts.COLUMN_ID_USER)
	private int id;

	@NotNull
	@Size(max = Consts.MAX_SIZE_NORMAL_TEXT)
	@Column(name = Consts.COLUMN_LOGIN_USER)
	private String login;

	@NotNull
	@Size(max = Consts.MAX_SIZE_NORMAL_TEXT)
	@Column(name = Consts.COLUMN_PASSWORD_USER)
	private String password;
	
	
	@Column(name=Consts.COLUMN_ROLE_USER)
	@Enumerated(EnumType.STRING)
	private Role role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", role=" + role + "]";
	}
	
	

}
