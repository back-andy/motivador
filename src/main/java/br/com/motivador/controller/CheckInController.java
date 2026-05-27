package br.com.motivador.controller;

import br.com.motivador.model.CheckInModel;
import br.com.motivador.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("motivador/api/checkin")
public class CheckInController {
    @Autowired
    CheckInService checkInService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/check/{id}")
    public CheckInModel checarHabito(@PathVariable Long id){
        return checkInService.realizarCheckIn(id);
    }
}
