package br.com.gerenciador.assembleias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador.assembleias.model.Pauta;

public interface PautaRepository extends JpaRepository<Pauta, Long> {

}
