package com.diego.senai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.repositories.EnderecoRepository;

@SpringBootTest
public class EnderecoTest {
	@Autowired
	EnderecoRepository enderecoRepo;
	
	@Test
	void Endereco() {
		Endereco en = new Endereco();
		en.setIdEndereco(1);
		en.setBairro("Jardins");
		en.setLogradouro("Alameda das Rosas");
		en.setNumero("12");
		en.setComplemento("");
		en.setCep("0001112");
		
		enderecoRepo.save(en);
	}
	@Test
	public void listaEndereco() {
		List<Endereco> List = enderecoRepo.findAll();
		assertThat(List).size().isGreaterThan(0);
	}
	@Test
	public void idEndereco() {
		Endereco en = enderecoRepo.findById(1).get();
		assertEquals(1, en.getIdEndereco());
	}
	@Test
	public void updateCliente() {
		Endereco en = enderecoRepo.findById(1).get();
		en.setBairro("Jotaro Kujo");
		enderecoRepo.save(en);
		assertNotEquals("Jotaro", en.getBairro());
	}
	@Test
	public void deleteEndereco() {
		enderecoRepo.deleteById(2);
		assertThat(enderecoRepo.existById(2));
	}

}
