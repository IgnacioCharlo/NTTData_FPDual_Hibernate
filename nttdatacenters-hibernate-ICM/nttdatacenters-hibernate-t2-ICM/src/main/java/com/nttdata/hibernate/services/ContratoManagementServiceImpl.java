package com.nttdata.hibernate.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.persistence.Contrato;
import com.nttdata.hibernate.persistence.ContratoDaoI;
import com.nttdata.hibernate.persistence.ContratoDaoImpl;

/**
 * Implementacion Servicios de Contrato
 * @author Ignacio Charlo Millan
 */
public class ContratoManagementServiceImpl implements ContratoManagementServiceI{

	private ContratoDaoI contratoDao;
	
	// Constructor
	public ContratoManagementServiceImpl(final Session session) {
		this.contratoDao = new ContratoDaoImpl(session);
	}
	
	/**
	 * Inserta un nuevo Contrato
	 * @param newContrato
	 */
	@Override
	public void insertContrato(Contrato newContrato) {
		// Verificaci�n de nulidad e inexistencia.
				if (newContrato != null && newContrato.getId() == null) {
					// Inserta al contrato
					contratoDao.insert(newContrato);
				}		
	}

	/**
	 * Actualiza un Contrato
	 * 
	 * @param updatedContrato
	 */
	@Override
	public void updateContrato(Contrato updatedContrato) {
		// Verificacion de nulidad e inexistencia
		if (updatedContrato != null && updatedContrato.getId() != 0) {
			// Actualiza al contrato
			contratoDao.update(updatedContrato);
		}		
	}

	/**
	 * Elimina un Contrato
	 * @param deletedContrato
	 */
	@Override
	public void deleteContrato(Contrato deletedContrato) {
		// Verificacion de nulidad e inexistencia
		if (deletedContrato != null && deletedContrato.getId() != 0) {
			// Elimina al contrato
			contratoDao.delete(deletedContrato);
		}		
	}

	/**
	 * Busca un Contrato por su ID
	 * @param contratoId
	 * @return
	 */
	@Override
	public Contrato searchById(Long contratoId) {
		Contrato contrato = null;
		if (contratoId != 0) {
			// Contrato con ese ID
			contrato = contratoDao.searchById(contratoId);
		}
		return contrato;
	}

	/**
	 * Busca todos los contratos
	 * @return
	 */
	@Override
	public List<Contrato> searchAll() {
		return contratoDao.searchAll();
	}
	
	/**
	 * Busca todos los clientes con contratos caducados
	 * @return List<Cliente>
	 */
	@Override
	public List<Cliente> searchByClienteConContratosCaducados(String ActualDate){
		return contratoDao.searchByContratosVencidos(ActualDate);
	}

}
