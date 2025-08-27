package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Usuario;
import app.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public String save(Usuario usuario) {
		this.usuarioRepository.save(usuario);
		return "O usuario foi salvo com sucesso"; 
	}
	
	public String update(Usuario usuario, Long idUser) {
		usuario.setIdUser(idUser);
		this.usuarioRepository.save(usuario);
		return "O usuario foi alterado com sucesso"; 
	}
	
	public String delete(Long idUser) {
		this.usuarioRepository.deleteById(idUser);
		return "O usuario foi deletado com sucesso"; 
	}
	
	public Usuario findById(Long idUser) {
		Usuario usuario = this.usuarioRepository.findById(idUser).get();
		return usuario; 
	}
	
	public List<Usuario> findAll() {
		List<Usuario> usuarios = this.usuarioRepository.findAll();
		return usuarios; 
	}
	

}
