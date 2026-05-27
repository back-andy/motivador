package br.com.motivador.service;

import br.com.motivador.model.CheckInModel;
import br.com.motivador.model.HabitoModel;
import br.com.motivador.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CheckInService {

    @Autowired
    private CheckInRepository checkInRepository;
    @Autowired
    private HabitoService habitoService;

    public CheckInModel realizarCheckIn(Long habitoId) {
        HabitoModel habitoModel = habitoService.getHabitoById(habitoId);

        boolean jaFezCheckInHoje = checkInRepository.existsByHabitoModelIdAndData(habitoId, LocalDate.now());
        if (jaFezCheckInHoje) {
            throw new RuntimeException("Você já realizou o check-in deste hábito hoje!");
        }

        CheckInModel checkInModel = new CheckInModel();
        checkInModel.setData(LocalDate.now());
        checkInModel.setHabitoModel(habitoModel);

        habitoService.aumentaStreak(habitoModel);
        return checkInRepository.save(checkInModel);
    }
}
