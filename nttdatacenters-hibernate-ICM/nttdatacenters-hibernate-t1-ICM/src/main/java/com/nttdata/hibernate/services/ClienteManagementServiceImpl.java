package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.persistence.ClienteDaoI;
import com.nttdata.hibernate.persistence.ClienteDaoImpl;

/**
 * Implementacion Servicios de Cliente
 * @author Ignacio Charlo Millan
 */
public class ClienteManagementServiceImpl implements ClienteManagementServiceI {

	private ClienteDaoI clienteDao;

	// Constructor
	public ClienteManagementServiceImpl(final Session session) {
		this.clienteDao = new ClienteDaoImpl(session);
	}

	public void insertCliente(final Cliente insertCliente) {
		// Verificación de nulidad e inexistencia.
		if (insertCliente != null && insertCliente.getId() == null) {
			// Inserta al cliente
			clienteDao.insert(insertCliente);
		}
	}

	public void updateCliente(final Cliente updatedCliente) {
		// Verificación de nulidad e inexistencia.
		if (updatedCliente != null && updatedCliente.getId() != 0) {
			// Actualiza al cliente
			clienteDao.update(updatedCliente);
		}
	}

	public void deleteCliente(final Cliente deletedCliente) {
		// Verificación de nulidad e inexistencia.
		if (deletedCliente != null && deletedCliente.getId() != 0) {
			// Elimina al cliente
			clienteDao.delete(deletedCliente);
		}
	}

	public Cliente searchById(final Long clienteId) {
		Cliente cliente = null;
		// Verificación de nulidad
		if (clienteId != 0) {
			// Cliente con ese ID
			cliente = clienteDao.searchById(clienteId);
		}
		return cliente;
	}

	public List<Cliente> searchAll() {
		return clienteDao.searchAll();
	}

	public List<Cliente> searchByDNI(final String dni) {
		List<Cliente> cliente = new ArrayList<>();
		// Si el dni tiene 9 digitos
		if (dni.length() == 9) {
			// Clientes con ese DNI
			cliente = clienteDao.searchByDNI(dni);
		}
		return cliente;
	}

	public List<Cliente> searchByLetraDNI(final String letraDNI) {
		List<Cliente> clientes = new ArrayList<>();
		// Verificacion de nulidad y unica letra
		if (letraDNI != null && letraDNI.length() == 1) {
			// Clientes con esa letra en el DNI
			clientes = clienteDao.searchByLetraDNI(letraDNI);
		}
		return clientes;
	}

	public List<Cliente> searchByApellidos(final String primerApellido, final String segundoApellido) {
		List<Cliente> clientes = new ArrayList<>();
		// Verificacion de nulidad
		if (primerApellido != null && !primerApellido.equals(""))
			// Clientes con esa letra en el DNI
			clientes = clienteDao.searchByApellidos(primerApellido, segundoApellido);

		return clientes;

	}

}
