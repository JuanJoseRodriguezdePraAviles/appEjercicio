package com.sinensia.model;

import java.time.LocalDate;

public class UserAccount {
	private int userAccountId;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String email;
	private LocalDate fechaRegistro;
	
	public int getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(int userAccountId) {
		this.userAccountId = userAccountId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public UserAccount() {
	}
	public UserAccount(int userAccountId, String nombre, String apellidos, LocalDate fechaNacimiento, String email, LocalDate fechaRegistro) {
		super();
		this.userAccountId=userAccountId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.fechaRegistro = fechaRegistro;
	}
}
