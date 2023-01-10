package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TABLA_CLIENTES")
public class Cliente extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long clienteId;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String dni;
	private List<Contrato> contratos;

	@Transient
	@Override
	public Long getId() {
		return this.clienteId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENTE_ID")
	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	@Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "PRIMER_APELLIDO")
	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String apellido) {
		this.primerApellido = apellido;
	}

	@Column(name = "SEGUNDO_APELLIDO")
	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	@Column(name = "DNI", nullable = false, unique = true)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Column(name = "CONTRATOS")
	@OneToMany(mappedBy = "cliente")
	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	@Override
	public String toString() {
		return "Cliente [Id = " + clienteId + ", nombre = " + nombre + ", primerApellido = " + primerApellido
				+ ", segundoApellido = " + segundoApellido + ", DNI = " + dni + ", contratos = " + contratos +"]";
	}

}
