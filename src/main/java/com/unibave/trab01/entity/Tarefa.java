package com.unibave.trab01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tarefa {

    @Id
    @Column(name="tarefa_id")
    @GeneratedValue
    private Long id;
    
    @Column(length=255, nullable=false)
    private String titulo;
    
    @Column(length=500, nullable=false)
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name="projeto_id", nullable=false)
    private Projeto projeto;
    
    public Tarefa() {
    }
    
    public Tarefa(String titulo, String descricao) {
        super();
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    
    public Projeto getProjeto() {
        return projeto;
    }

    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + "]";
    }
    
}
