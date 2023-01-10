package com.nttdata.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase de configuracion
 * @author Ignacio Charlo Millan
 */
public class NTTDataHibernateUtil {

	// Factoria de sesiones
	private static final SessionFactory SESSION_FACTORY;

	// Constructor privado
	private NTTDataHibernateUtil() {}

	// Generacion de factoria de sesiones
	static {
		try {
			// Generacion de configuracion
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
		} catch (final Exception ex) {
			// Error de inicializacion
			System.err.println("[ERROR] Configuración de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}
	}

	/**
	 * Retorna la factoria de sesiones
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
