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

import app.entity.Usuario;
import app.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Usuario usuario) {
		try {
			String mensagem = this.usuarioService.save(usuario);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			String mensagem = e.getMessage();
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_GATEWAY);
		}

	}
	@PutMapping("/update/{idUser}")
	public ResponseEntity<String> update(@RequestBody Usuario usuario, @PathVariable Long idUser) {
		try {
			String mensagem = this.usuarioService.update(usuario, idUser);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			String mensagem = e.getMessage();
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_GATEWAY);
		}
		

	}
	
	@DeleteMapping("/delete/{idUser}")
	public ResponseEntity<String> delete(@PathVariable Long idUser) {
		try {
			String mensagem = this.usuarioService.delete(idUser);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			String mensagem = e.getMessage();
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_GATEWAY);
		}

	}

	@GetMapping ("/findById/{idUser}")
	public ResponseEntity<Usuario> findById(@PathVariable Long idUser) {
		try {
			Usuario usuario = this.usuarioService.findById(idUser);
			return new ResponseEntity<>(usuario, HttpStatus.OK);

		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}
		
	}
	
	@GetMapping ("/findAll")
	public ResponseEntity <List<Usuario>> findAll() {
		try {
			List<Usuario> usuarios = this.usuarioService.findAll();
			return new ResponseEntity<>(usuarios, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}
		
	}
	
	
}
