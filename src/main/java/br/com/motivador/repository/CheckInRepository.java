package br.com.motivador.repository;

import br.com.motivador.model.CheckInModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CheckInRepository extends JpaRepository<CheckInModel,Long> {
    boolean existsByHabitoModelIdAndData(Long habitoId, LocalDate data);
}
