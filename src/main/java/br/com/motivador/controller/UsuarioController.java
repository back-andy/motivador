package br.com.motivador.controller;

import br.com.motivador.dto.UsuarioCadastroDTO;
import br.com.motivador.dto.UsuarioListagemDTO;
import br.com.motivador.model.UsuarioModel;
import br.com.motivador.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motivador/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public List<UsuarioListagemDTO> getAll(){
        return usuarioService.buscaUsuarios();
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrarUsuario(@RequestBody @Valid UsuarioCadastroDTO dados){
        usuarioService.criarUsuario(dados);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //TODO: CRIAR LOGIN
}
