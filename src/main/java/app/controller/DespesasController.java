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
import app.entity.Despesas;
import app.service.DespesasService;


@RestController
@RequestMapping("/api/despesa")
public class DespesasController {
	@Autowired
	DespesasService despesasService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Despesas despesa) {
		try {
			String mensagem = this.despesasService.save(despesa);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{idDespesa}")
	public ResponseEntity<String> update(@RequestBody Despesas despesa, @PathVariable Long idDespesa) {
		try { 
			String mensagem = this.despesasService.update(despesa, idDespesa);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{idDespesa}")
	public ResponseEntity<String> delete(@PathVariable Long idDespesa) {
		try {
			String mensagem = this.despesasService.delete(idDespesa);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Despesas>> findAll() {
		try {
			List<Despesas> despesas = this.despesasService.findAll();
			return new ResponseEntity<>(despesas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{idDespesa}")
	public ResponseEntity<Despesas> findById(@PathVariable Long idDespesa) {
		try {
			Despesas despesa = this.despesasService.findById(idDespesa);
			return new ResponseEntity<>(despesa, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}
	}
}
