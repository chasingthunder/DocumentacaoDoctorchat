package main.java.br.com.fiap.doctorchat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import main.java.br.com.fiap.doctorchat.models.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    // @Query("SELECT d FROM Cadastro d WHERE d.descricao LIKE %?1%") //JPQL
    Page<Cadastro> findByDescricaoContaining(String busca, Pageable pageable);

    // @Query("SELECT d FROM Cadastro d ORDER BY d.id LIMIT ?1 OFFSET ?2")
    // List<Cadastro> buscarPaginado(int tamanho, int offset);
    
}