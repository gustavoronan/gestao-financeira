package app.entity;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Despesas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDespesa;
	private double valor;
	private String descricao;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@ManyToOne
    @JoinColumn(name = "usuario_id")
	@JsonIgnoreProperties("despesas") 
    private Usuario usuario;
	@ManyToOne
    @JoinColumn(name = "categoria_id")
	@JsonIgnoreProperties({"despesas", "usuario"})
    private Categoria categoria;
	
	public Long getIdDespesa() {
		return idDespesa;
	}
	public void setIdDespesa(Long idDespesa) {
		this.idDespesa = idDespesa;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
