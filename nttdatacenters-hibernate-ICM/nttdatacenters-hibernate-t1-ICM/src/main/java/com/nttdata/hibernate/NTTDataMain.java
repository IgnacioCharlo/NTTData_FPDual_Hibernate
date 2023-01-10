package com.nttdata.hibernate;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

		// Auditoria
		final String updatedUser = "IgnacioCharlo";
		
		// Creacion e Insercion de clientes en la BD
		Cliente c1 = new Cliente();
		c1.setNombre("Jose");
		c1.setPrimerApellido("Naranja");
		c1.setSegundoApellido("Limon");
		c1.setDni("11111111A");
		c1.setUpdatedUser(updatedUser);
		clienteService.insertCliente(c1);
		
		Cliente c2 = new Cliente();
		c2.setNombre("Juan");
		c2.setPrimerApellido("Borruel");
		c2.setSegundoApellido("Arcauce");
		c2.setDni("22222222B");
		c2.setUpdatedUser(updatedUser);
		clienteService.insertCliente(c2);

		
		Cliente c3 = new Cliente();
		c3.setNombre("Ignacio");
		c3.setPrimerApellido("Charlo");
		c3.setSegundoApellido("Millan");
		c3.setDni("33333333C");
		c3.setUpdatedUser(updatedUser);
		clienteService.insertCliente(c3);

		// Consultas (JPA Criteria)
		List<Cliente> lista = null;

		// SearchByLetraDNI
		lista = clienteService.searchByLetraDNI("A");
		for(final Cliente c : lista) {
			System.out.println(c.toString());
		}
		lista.clear();
		System.out.println();
		
		// SearchByDNI
		lista = clienteService.searchByDNI("22222222B");
		for(Cliente c : lista) {
			System.out.println(c.toString());
		}
		lista.clear();
		System.out.println();
		

		// SearchByApellidos
		lista = clienteService.searchByApellidos("Charlo", "Millan");
		for(Cliente c : lista) {
			System.out.println(c.toString());
		}
		lista.clear();
		System.out.println();

		// SearchAll
		lista = clienteService.searchAll();
		for(Cliente c : lista) {
			System.out.println(c.toString());
		}
		lista.clear();

		// Cierre de sesión.
		session.close();
	}

}
