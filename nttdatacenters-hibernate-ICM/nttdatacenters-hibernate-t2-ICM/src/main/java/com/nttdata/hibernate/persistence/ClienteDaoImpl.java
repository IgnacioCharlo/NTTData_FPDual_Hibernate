package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Implementacion DAO Cliente
 * @author Ignacio Charlo Millan
 */
public class ClienteDaoImpl extends CommonDaoImpl<Cliente> implements ClienteDaoI {

	// La session de la BBDD
	private Session session;

	/**
	 * Constructor
	 * @param session
	 */
	public ClienteDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> searchByDNI(final String dni) {
		// Verificacion de sesion abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}		
		return session.createQuery("FROM Cliente WHERE dni = '" + dni + "'").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> searchByLetraDNI(final String letraDNI) {
		// Verificacion de sesion abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM Cliente WHERE dni LIKE '%" + letraDNI + "'").list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> searchByApellidos(final String primerApellido, final String segundoApellido) {
		// Verificacion de sesion abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM Cliente WHERE primerApellido = '"+primerApellido+"' AND segundoApellido = '"+segundoApellido+"'").list();
	}
}
