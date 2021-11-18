package br.com.bruno.resources;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.domain.Categoria;
import br.com.bruno.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Optional<Categoria> obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
