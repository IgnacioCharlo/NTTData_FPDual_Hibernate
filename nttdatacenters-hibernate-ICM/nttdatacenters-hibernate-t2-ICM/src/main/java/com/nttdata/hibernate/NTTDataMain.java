package com.nttdata.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nttdata.hibernate.persistence.Contrato;
import com.nttdata.hibernate.services.ContratoManagementServiceI;
import com.nttdata.hibernate.services.ContratoManagementServiceImpl;
import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.services.ClienteManagementServiceI;
import com.nttdata.hibernate.services.ClienteManagementServiceImpl;


public class NTTDataMain {
	public static void main(String[] args) {
		//Quitamos los LOGs de hibernate
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		// Abrimos sesion
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicializamos servicios
		final ClienteManagementServiceI clienteService = new ClienteManagementServiceImpl(session);
		final ContratoManagementServiceI contratoService = new ContratoManagementServiceImpl(session);

		// Auditoria
		final String updatedUser = "IgnacioCharlo";

		// Creacion e Insercion de clientes en la BD
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Jose");
		cliente1.setPrimerApellido("Naranja");
		cliente1.setSegundoApellido("Limon");
		cliente1.setDni("11111111A");
		cliente1.setUpdatedUser(updatedUser);
		clienteService.insertCliente(cliente1);

		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Juan");
		cliente2.setPrimerApellido("Borruel");
		cliente2.setSegundoApellido("Arcauce");
		cliente2.setDni("22222222B");
		cliente2.setUpdatedUser(updatedUser);
		clienteService.insertCliente(cliente2);

		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Ignacio");
		cliente3.setPrimerApellido("Charlo");
		cliente3.setSegundoApellido("Millan");
		cliente3.setDni("33333333C");
		cliente3.setUpdatedUser(updatedUser);
		clienteService.insertCliente(cliente3);

		// Creacion e Insercion de contratos en la BD
		Contrato contrato1 = new Contrato();
		contrato1.setFechaVigencia("2013-05-22");
		contrato1.setFechaCaducidad("2016-12-21");
		contrato1.setPrecioMensual(1000.00);
		contrato1.setCliente(cliente1);
		contrato1.setUpdatedUser(updatedUser);
		contratoService.insertContrato(contrato1);

		Contrato contrato2 = new Contrato();
		contrato2.setFechaVigencia("2018-05-22");
		contrato2.setFechaCaducidad("2025-12-21");
		contrato2.setPrecioMensual(1000.00);
		contrato2.setCliente(cliente1);
		contrato2.setUpdatedUser(updatedUser);
		contratoService.insertContrato(contrato2);

		Contrato contrato3 = new Contrato();
		contrato3.setFechaVigencia("2018-05-22");
		contrato3.setFechaCaducidad("2021-08-21");
		contrato3.setPrecioMensual(1000.00);
		contrato3.setCliente(cliente2);
		contrato3.setUpdatedUser(updatedUser);
		contratoService.insertContrato(contrato3);

		Contrato contrato4 = new Contrato();
		contrato4.setFechaVigencia("2018-05-22");
		contrato4.setFechaCaducidad("2023-08-21");
		contrato4.setPrecioMensual(1000.00);
		contrato4.setCliente(cliente2);
		contrato4.setUpdatedUser(updatedUser);
		contratoService.insertContrato(contrato4);

		Contrato contrato5 = new Contrato();
		contrato5.setFechaVigencia("2018-05-22");
		contrato5.setFechaCaducidad("2023-12-21");
		contrato5.setPrecioMensual(1000.00);
		contrato5.setCliente(cliente3);
		contrato5.setUpdatedUser(updatedUser);
		contratoService.insertContrato(contrato4);

		Contrato contrato6 = new Contrato();
		contrato6.setFechaVigencia("2018-05-22");
		contrato6.setFechaCaducidad("2029-12-21");
		contrato6.setPrecioMensual(1000.00);
		contrato6.setCliente(cliente3);
		contrato6.setUpdatedUser(updatedUser);
		contratoService.insertContrato(contrato4);


		// El contrato 1 y 2, corresponden al Cliente 1
		final List<Contrato> listaContratosC1 = new ArrayList<>();
		listaContratosC1.add(contrato1);
		listaContratosC1.add(contrato2);

		// El contrato 3 y 4, corresponden al Cliente 2
		final List<Contrato> listaContratosC2 = new ArrayList<>();
		listaContratosC2.add(contrato3);
		listaContratosC2.add(contrato4);

		// El contrato 5 y 6, corresponden al Cliente 3
		final List<Contrato> listaContratosC3 = new ArrayList<>();
		listaContratosC3.add(contrato5);
		listaContratosC3.add(contrato6);

		// Asignamos a los Clientes su lista de contratos
		cliente1.setContratos(listaContratosC1);
		cliente2.setContratos(listaContratosC2);
		cliente3.setContratos(listaContratosC3);

		// Por �ltimo, con todos los campos definidos, agregamos los Clientes
		clienteService.insertCliente(cliente1);
		clienteService.insertCliente(cliente2);
		clienteService.insertCliente(cliente3);



		// Consultas Contratos (JPA Criteria)
		List<Cliente> lista = null;
		lista = contratoService.searchByClienteConContratosCaducados("2022-12-29");

		System.out.println("\nClientes con contratos vencidos:");

		for(Cliente c : lista) {
			System.out.println(c);
		}
	}

}
