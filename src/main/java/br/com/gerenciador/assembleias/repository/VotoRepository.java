package br.com.gerenciador.assembleias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador.assembleias.model.Pauta;
import br.com.gerenciador.assembleias.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {

}
