package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Implementacion DAO Contrato
 * @author Ignacio Charlo Millan
 */
public class ContratoDaoImpl extends CommonDaoImpl<Contrato> implements ContratoDaoI {

    private Session session;

    private CriteriaBuilder cb;

    // Constructor
    public ContratoDaoImpl(Session session) {
        super(session);
        this.session = session;
        this.cb = session.getCriteriaBuilder();
    }

    @Override
    public List<Cliente> searchByContratosVencidos(String fechaActual) {
        // Consulta
        final CriteriaQuery<Cliente> cquery = cb.createQuery(Cliente.class);
        final Root<Cliente> rootCliente = cquery.from(Cliente.class);
        final Join<Cliente, Contrato> clienteJoinContrato = rootCliente.join("contratos");

        // Condicion
        final Predicate pr1 = cb.lessThan(clienteJoinContrato.<Comparable>get("fechaCaducidad"), fechaActual);

        // Consulta
        cquery.select(rootCliente).where(pr1);

        return session.createQuery(cquery).getResultList();

    }




}
