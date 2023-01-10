package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Cliente;

/**
 * Interfaz Servicios de Cliente
 * @author Ignacio Charlo Millan
 */
public interface ClienteManagementServiceI {
	/**
	 * Inserta un nuevo Cliente
	 * @param newCliente
	 */
	public void insertCliente(final Cliente newCliente);

	/**
	 * Actualiza un Cliente
	 * @param updatedCliente
	 */
	public void updateCliente(final Cliente updatedCliente);

	/**
	 * Elimina un Cliente
	 * @param deletedCliente
	 */
	public void deleteCliente(final Cliente deletedCliente);

	/**
	 * Busca un Cliente por su ID
	 * @param clienteId ID del cliente que queremos sacar
	 *
	 * @return Cliente
	 */
	public Cliente searchById(final Long clienteId);


	/**
	 * Busca todos los Clientes
	 * @return List<Cliente>
	 */
	public List<Cliente> searchAll();
	
	/**
	 * Busca todos los clientes con ese DNI
	 * @param dni
	 *
	 * @return List<Cliente>
	 */
	public List<Cliente> searchByDNI(final String dni);
	
	/**
	 * Busca todos los clientes con esa letra en su DNI
	 * @param letraDNI
	 *
	 * @return List<Cliente>
	 */
	public List<Cliente> searchByLetraDNI(final String letraDNI);

	
	/**
	 * Busca los clientes por sus apellidos
	 * @param primerApellido
	 * @param segundoApellido
	 * 
	 * @return List<Cliente>
	 */
	public List<Cliente> searchByApellidos(final String primerApellido, final String segundoApellido);

}