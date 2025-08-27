package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Despesas;

public interface DespesasRepository extends JpaRepository<Despesas, Long>{

}
