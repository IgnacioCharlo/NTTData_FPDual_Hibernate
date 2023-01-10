package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Interfaz DAO Contrato
 * @author Ignacio Charlo Millan
 */
public interface ContratoDaoI extends CommonDaoI<Contrato> {
		
	/**
	 * Obtiene los contratos que ya han vencido
	 *
	 * @param fechaActual
	 * @return List<Contrato>
	 */
	public List<Cliente> searchByContratosVencidos(String fechaActual);
}
