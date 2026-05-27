package br.com.motivador.service;

import br.com.motivador.dto.UsuarioCadastroDTO;
import br.com.motivador.dto.UsuarioListagemDTO;
import br.com.motivador.model.UsuarioModel;
import br.com.motivador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioListagemDTO> buscaUsuarios(){
        return usuarioRepository.findAll().stream()
                .map(UsuarioListagemDTO::new)// "Cada usuário da lista é passado para o construtor do Record"
                .toList();
    }

    //usando DTOs
    public void criarUsuario (UsuarioCadastroDTO dados){
        UsuarioModel usuarioNovo = new UsuarioModel(); //instancia de novo usuariio

        if (usuarioRepository.existsByEmail(dados.email())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Este email já existe, tente um novo");
        }

        //o usuario instanciado recebe os dados do DTO
        usuarioNovo.setEmail(dados.email());
        usuarioNovo.setNome(dados.nome());
        usuarioNovo.setSenha(dados.senha()); //todo: refatorar futuramente para hashear senha
        usuarioNovo.setTokensPausa(3);

        usuarioRepository.save(usuarioNovo);
    }

    //TODO: CRIAR LOGIN
}
