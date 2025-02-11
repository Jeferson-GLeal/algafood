package com.algaworks.algafood.domain.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exeption.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exeption.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
	
	
	@Autowired
	private CozinhaRepository cozinhaRespository;
	public Cozinha salvar(Cozinha cozinha) {
		
		return cozinhaRespository.salvar(cozinha);
	}

	
	public void excluir(Long cozinhaId) {
		try {
			
			cozinhaRespository.remover(cozinhaId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Nao existe um cadastro de cozinha com codigo %d", cozinhaId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Cozinha de codigo %d nao pode ser removida, pois esta em uso", cozinhaId)); 
		}		
	}
}
