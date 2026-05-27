package br.com.motivador.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "check_in")
public class CheckInModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @ManyToOne(optional = false)
    @JoinColumn(name = "habito_id", nullable = false)
    private HabitoModel habitoModel;

    public CheckInModel() {
    }

    public CheckInModel(Long id, LocalDate data, HabitoModel habitoModel) {
        this.id = id;
        this.data = data;
        this.habitoModel = habitoModel;
    }

    public HabitoModel getHabitoModel() {
        return habitoModel;
    }

    public void setHabitoModel(HabitoModel habitoModel) {
        this.habitoModel = habitoModel;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CheckInModel{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}
