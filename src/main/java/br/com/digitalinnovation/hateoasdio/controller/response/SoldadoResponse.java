package br.com.digitalinnovation.hateoasdio.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SoldadoResponse extends RepresentationModel {

    private Long id;
    private String cpf;
    private String nome;
    private String raca;
    private String arma;
    private String status;

    @JsonProperty("id")
    public Long getResourceId() { return id; }

    @JsonProperty("id")
    public void setId(Long id) { this.id = id; }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
