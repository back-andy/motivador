package br.com.motivador.controller;

import br.com.motivador.model.HabitoModel;
import br.com.motivador.service.HabitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("motivador/api/habitos")
public class HabitoController {
    @Autowired
    private HabitoService habitoService;

    @GetMapping("/")
    public List<HabitoModel> getAll(){
        return habitoService.getAllHabitos();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/registrar")
    public HabitoModel registerHabito(@RequestBody HabitoModel model){
        return habitoService.createHabito(model);
    }
}
