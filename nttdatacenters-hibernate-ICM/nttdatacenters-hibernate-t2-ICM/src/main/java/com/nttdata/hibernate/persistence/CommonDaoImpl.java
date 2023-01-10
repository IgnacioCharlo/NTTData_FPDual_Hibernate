package com.nttdata.hibernate.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * Implementacion DAO generico
 * @author Ignacio Charlo Millan
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	// Tipo de clase
	private Class<T> entityClass;

	// Sesion de conexion a BD
	private Session session;

	/**
	 * Metodo constructor
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	protected CommonDaoImpl(Session session) {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(final T paramT) {

		// Verificacion de sesion abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercion
		session.save(paramT);
		session.flush();

		// Commit
		session.getTransaction().commit();
	}

	public void update(final T paramT) {

		// Verificacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercion
		session.save(paramT);
		session.flush();

		// Commit
		session.getTransaction().commit();
	}

	public void delete(final T paramT) {

		// Verificacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercion
		session.delete(paramT);

		// Commit
		session.getTransaction().commit();
	}

	public T searchById(final Long id) {

		// Verificacion de sesion abiertao
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Busqueda por PK
		return session.get(this.entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> searchAll() {

		// Verificacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Busqueda de todos los registros
		return session.createQuery("FROM " + this.entityClass.getName()).list();

	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass
	 *            the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
