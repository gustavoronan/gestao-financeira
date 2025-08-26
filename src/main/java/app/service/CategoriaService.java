package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Categoria;
import app.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public String save (Categoria categoria) {
		this.categoriaRepository.save(categoria);
		return "categoria salva: " + categoria.getNome();
	}
	
	public String update (Categoria categoria, long idCategoria) {
		categoria.setIdCategoria(idCategoria);
		this.categoriaRepository.save(categoria);
		return "Categoria atualizada com sucesso: " + categoria;
	}
	
	public String delete ( long idCategoria) {
		this.categoriaRepository.deleteById(idCategoria);
		return "Categoria deletada com sucesso";
	}
	
	public List<Categoria> findAll (){
		List<Categoria> lista = this.categoriaRepository.findAll();
		return lista;
	}
	
	public Categoria findById(long idCategoria) {
		Categoria categoria = this.categoriaRepository.findById(idCategoria).get();
		return  categoria;
	}
}
