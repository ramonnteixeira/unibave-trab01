package com.unibave.trab01.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Projeto {

    @Id
    @Column(name="projeto_id")
    @GeneratedValue
    private Long id;
    
    @Column(length=150, nullable=false)
    private String nome;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn
    private List<Tarefa> tarefas = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(joinColumns=@JoinColumn(name="projeto_id"), inverseJoinColumns=@JoinColumn(name="funcionario_id"))
    private List<Funcionario> equipe = new ArrayList<>();
    
    public Long getId() {
        return id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public List<Tarefa> getTarefas() {
        return Collections.unmodifiableList( tarefas );
    }
    
    public void addTarefa(Tarefa tarefa) {
        tarefa.setProjeto(this);
        tarefas.add(tarefa);
    }
    
    public void removeTarefa(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }
    
    public List<Funcionario> getEquipe() {
        return Collections.unmodifiableList(equipe);
    }
    
    public void addFuncionario(Funcionario funcionario) {
        equipe.add(funcionario);
    }
    
    public void removeFuncionario(Funcionario funcionario) {
        equipe.remove(funcionario);
    }

    @Override
    public String toString() {
        return "Projeto [id=" + id + ", nome=" + nome + "]";
    }
    
}
