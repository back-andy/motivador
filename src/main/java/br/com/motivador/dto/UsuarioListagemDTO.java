package br.com.motivador.dto;

import br.com.motivador.model.UsuarioModel;

public record UsuarioListagemDTO(Long id, String nome, String email){
    // construtor que recebe a Entity inteira
    public UsuarioListagemDTO(UsuarioModel usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());// construtor padrão do Record passando os dados extraídos
    }
}
