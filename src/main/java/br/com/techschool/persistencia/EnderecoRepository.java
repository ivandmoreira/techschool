package br.com.techschool.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.techschool.modelo.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
