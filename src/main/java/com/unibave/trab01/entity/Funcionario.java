package com.unibave.trab01.entity;

import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Funcionario {

    @Id
    @Column(name="funcionario_id")
    @GeneratedValue
    private Long id;
    
    @Column(length=150, nullable=false)
    private String nome;
    
    @Column(nullable=false)
    private boolean poguero = true;
    
    @ManyToMany
    @JoinTable(joinColumns=@JoinColumn(name="funcionario_id"), inverseJoinColumns=@JoinColumn(name="projeto_id"))
    private List<Projeto> projetos;
    
    public Long getId() {
        return id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public boolean isPoguero() {
        return poguero;
    }
    
    public void setPoguero(boolean poguero) {
        this.poguero = poguero;
    }

    public List<Projeto> getProjetos() {
        return Collections.unmodifiableList( projetos );
    }
    
    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", nome=" + nome + ", poguero=" + poguero + "]";
    }

}
