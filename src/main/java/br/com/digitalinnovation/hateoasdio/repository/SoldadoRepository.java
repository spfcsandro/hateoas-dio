package br.com.digitalinnovation.hateoasdio.repository;

import br.com.digitalinnovation.hateoasdio.model.Soldado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldadoRepository extends JpaRepository<Soldado, Long> {
}
