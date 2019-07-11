package com.coches.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Car")

public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_CABALLOS = 70;
	public static final long PLATE_LENGTH = 7;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modelo;

	@Column(nullable = false)
	private String matricula;

	private int caballos;

	public Car() {
	}

	public Car(String modelo, String matricula, int caballos) {
		setCaballos(caballos);
		setMatricula(matricula);
		setModelo(modelo);
	}

	public Long getId() {
		return id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;

	}

	public static boolean isCorrect(String matricula2) {
		char[] sequence = matricula2.toCharArray();
		boolean correct = true;
		char c;

		for (int i = 0; i <= 3; i++) {
			c = sequence[i];
			if (!Character.isDigit(c))
				correct &= false;
		}

		for (int i = 4; i < PLATE_LENGTH; i++) {
			c = sequence[i];
			if (!Character.isLetter(c))
				correct &= false;
		}

		return correct;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		if(caballos != 0)
			if(caballos > 0)
				this.caballos = caballos;
		else
			this.caballos= DEFAULT_CABALLOS;
	}

	public void setId(Long id) {
		this.id = id;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", modelo=" + modelo + ", matricula=" + matricula + ", caballos=" + caballos + "]";
	}

}
