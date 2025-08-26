package app.entity;
import java.time.LocalDateTime;

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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Despesas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDespesa;
	private double valor;
	private String descricao;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
	@ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
