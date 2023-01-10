package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TABLA_CONTRATOS")
public class Contrato extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long contratoId;
	private String fechaVigencia;
	private String fechaCaducidad;
	private double precioMensual;
	private Cliente cliente;

	@Transient
	@Override
	public Long getId() {
		return getContratoId();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTRATO_ID", unique = true)
	public Long getContratoId() {
		return contratoId;
	}

	public void setContratoId(Long contratoId) {
		this.contratoId = contratoId;
	}

	@Column(name = "FECHA_VIGENCIA")
	public String getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(String fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	@Column(name = "FECHA_CADUCIDAD")
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	@Column(name = "PRECIO_MENSUAL")
	public double getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(double precioMensual) {
		this.precioMensual = precioMensual;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENTE_ID")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
