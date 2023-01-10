package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.persistence.Contrato;

/**
 * Interfaz Servicios de Contrtato
 * @author Ignacio Charlo Millan
 */

public interface ContratoManagementServiceI {
    /**
     * Crea un nuevo Contrato
     * @param newContrato
     */
    public void insertContrato(final Contrato newContrato);

    /**
     * Actualiza un Contrato
     * @param updatedContrato
     */
    public void updateContrato(final Contrato updatedContrato);

    /**
     * Elimina un Contrato
     * @param deletedContrato
     */
    public void deleteContrato(final Contrato deletedContrato);

    /**
     * Busca un Contrato por su ID
     * @param contratoId
     * @return
     */
    public Contrato searchById(final Long contratoId);


    /**
     * Busca todos los Contratos
     * @return
     */
    public List<Contrato> searchAll();


    /**
     * Busca clientes con contratos caducados
     * @return List<Cliente>
     */
    public List<Cliente> searchByClienteConContratosCaducados(String fechaActual);
}
