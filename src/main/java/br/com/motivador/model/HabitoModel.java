package br.com.motivador.model;

import br.com.motivador.enums.Frequencia;
import jakarta.persistence.*;

@Entity
@Table(name="habito")
public class HabitoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "frequencia", nullable = false)
    private Frequencia frequencia;

    @Column(name = "sequencia_dias", nullable = false)
    private Integer sequenciaDias = 0;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuarioModel;

    public HabitoModel() {
    }

    public HabitoModel(Long id, String nome, String descricao, Frequencia frequencia, UsuarioModel usuarioModel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.frequencia = frequencia;
        this.usuarioModel = usuarioModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }

    public Integer getSequenciaDias() {
        return sequenciaDias;
    }

    public void setSequenciaDias(Integer sequenciaDias) {
        this.sequenciaDias = sequenciaDias;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    @Override
    public String toString() {
        return "HabitoModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", frequencia=" + frequencia +
                ", sequenciaDias=" + sequenciaDias +
                '}';
    }
}
