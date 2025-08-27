package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Categoria;
import app.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping("/save")
	public ResponseEntity<String> save (@RequestBody Categoria categoria) {
		try {
			String mensagem = this.categoriaService.save(categoria);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{idCategoria}")
	public ResponseEntity<String> update (@RequestBody Categoria categoria, @PathVariable Long idCategoria) {

		try {
			String mensagem = this.categoriaService.update(categoria, idCategoria);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{idCategoria}")
	public ResponseEntity<String> delete ( @PathVariable Long idCategoria) {
		try {
			String mensagem = this.categoriaService.delete(idCategoria);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findAll")
	public ResponseEntity <List<Categoria>> findAll(){
		try {
			List<Categoria> categorias = this.categoriaService.findAll();
			return new ResponseEntity<>(categorias, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("findById/{idCategoria}")
	public ResponseEntity<Categoria> FindById(@PathVariable Long idCategoria) {

		try {
			Categoria categoria = this.categoriaService.findById(idCategoria);
			return new ResponseEntity<>(categoria, HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}
}


