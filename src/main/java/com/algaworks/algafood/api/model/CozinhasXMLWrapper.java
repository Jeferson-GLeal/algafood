package com.algaworks.algafood.api.model;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;

import lombok.Data;
import lombok.NonNull;

@Data
public class CozinhasXMLWrapper {
	
	@NonNull
	private List<Cozinha> cozinhas;

}
