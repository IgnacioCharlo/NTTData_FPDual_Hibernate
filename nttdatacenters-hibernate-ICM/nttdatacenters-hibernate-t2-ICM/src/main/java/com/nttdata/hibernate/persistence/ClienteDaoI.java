package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Interfaz DAO Cliente
 * @author Ignacio Charlo Millan
 */
public interface ClienteDaoI extends CommonDaoI<Cliente> {

	/**
	 * Busca todos los clientes con ese DNI
	 * @param dni
	 * @return List<Cliente>
	 */
	public List<Cliente> searchByDNI(final String dni);

	/**
	 * Busca todos los clientes con esa letra en su DNI
	 * @param letraDNI
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
