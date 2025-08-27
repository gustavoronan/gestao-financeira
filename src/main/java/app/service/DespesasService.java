package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Despesas;
import app.repository.DespesasRepository;

@Service
public class DespesasService {
	
	@Autowired
	DespesasRepository despesasRepository;
	
	public String save(Despesas despesa) {
		this.despesasRepository.save(despesa);
		return "Despesa salva com sucesso";
	}
	
	public String update(Despesas despesa, Long idDespesa) {
		despesa.setIdDespesa(idDespesa);
		this.despesasRepository.save(despesa);
		return "Despesa atualizada";
	}
	
	public String delete(Long idDespesa) {
		this.despesasRepository.deleteById(idDespesa);
		return "Deletado com sucesso";
	}
	
	public List<Despesas> findAll() {
		List<Despesas> lista = this.despesasRepository.findAll();
		return lista;
	}
	
	public Despesas findById(Long idDespesa) {
		Despesas despesa = this.despesasRepository.findById(idDespesa).get();
		return despesa;
	}
}
