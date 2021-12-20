package com.diego.senai;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.repositories.ClienteRepository;

@SpringBootTest
public class ClienteTest {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Test
	void Cliente() {
		Cliente cli = new Cliente();
		cli.setIdCliente(null);
		cli.setNome("Giorno");
		cli.setCpfOuCnpj("12345678900");
		cli.setEmail("giorno@email.com");
		clienteRepo(cli);
	}
	@Test
	public void listaCliente() {
		List<Cliente> List = clienteRepo.findAll();
		assertThat(List).size().isGreaterThan(0);
	}
	@Test
	public void idCliente() {
		Cliente cliente = clienteRepo.findById(1).get();
		assertEquals("Jotaro", cliente.getNome());
	}
	@Test
	public void updateCliente() {
		Cliente cliente = clienteRepo.findById(1).get();
		cliente.setNome("Jotaro Kujo");
		clienteRepo.save(cliente);
		assertNotEquals("Jotaro", cliente.getNome());
	}
	@Test
	public void deleteCliente() {
		clienteRepo.deleteById(2);
		assertThat(clienteRepo.existById(2));
	}
	@Test
	public void somar() {
		double num1 = 5.0;
		double num2 = 10.0;
		Cliente clinte = new Cliente();
		double soma = cliente.somar(num1 + num2);
		assertEquals(15, soma);
	}
	@Test
    public void subtrair() {
        double num1 = 20.0;
        double num2 = 1.0;
        Cliente cliente = new Cliente();
        double subtração = cliente.subtrair(num1, num2);
        assertEquals(19, subtração);
    }

    @Test
    public void multiplicar() {
        double num1 = 10.0;
        double num2 = 20.0;
        Cliente cliente = new Cliente();
        double multiplicação = cliente.multiplicar(num1, num2);
        assertEquals(200, multiplicação);
    }

    @Test
    public void dividir() {
        double num1 = 20.0;
        double num2 = 5.0;
        Cliente cliente = new Cliente();
        double divisão = cliente.dividir(num1, num2);
        assertEquals(4, divisão);
    }

}