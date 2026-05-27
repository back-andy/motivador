package br.com.motivador.service;

import br.com.motivador.model.HabitoModel;
import br.com.motivador.repository.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HabitoService {
    @Autowired
    private HabitoRepository habitoRepository;

    public List<HabitoModel> getAllHabitos(){
        return habitoRepository.findAll();
    }

    public HabitoModel getHabitoById(Long id){
        return habitoRepository.findById(id).orElseThrow();
    }

    public HabitoModel createHabito(HabitoModel habitoModel){
        habitoModel.setSequenciaDias(0);
        return habitoRepository.save(habitoModel);
    }

    public void aumentaStreak(HabitoModel habito){
        //HabitoModel habito = getHabitoById(id);
        habito.setSequenciaDias(habito.getSequenciaDias()+1);
    }
}
