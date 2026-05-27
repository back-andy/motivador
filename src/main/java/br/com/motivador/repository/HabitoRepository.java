package br.com.motivador.repository;

import br.com.motivador.model.HabitoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitoRepository extends JpaRepository<HabitoModel, Long> {
}