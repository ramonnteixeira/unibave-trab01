package com.unibave.trab01;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.unibave.trab01.entity.Funcionario;
import com.unibave.trab01.entity.Projeto;
import com.unibave.trab01.entity.Tarefa;

public class Main {

	public static void main(String[] args) {
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unibave-jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();;
		EntityTransaction tx = entityManager.getTransaction();
		
        Funcionario ramon = new Funcionario();
        ramon.setNome("Ramon");
        
        Funcionario fulano = new Funcionario();
        fulano.setNome("Fulano");
        
		Funcionario ciclano = new Funcionario();
		ciclano.setNome("ciclano");
		ciclano.setPoguero(false);
		
        Projeto projeto1 = new Projeto();
        projeto1.setNome("Projeto TOP");
        projeto1.addFuncionario(ramon);
        projeto1.addFuncionario(fulano);
        projeto1.addTarefa(new Tarefa("criar crud 01", "Mandar o programador pensar em como fazer isso"));
        projeto1.addTarefa(new Tarefa("documentar crud 01", "Chamar o estagiario"));
        
        Projeto projeto2 = new Projeto();
        projeto2.setNome("Projeto Mais ou Menos");
        projeto2.addFuncionario(ciclano);
        projeto2.addFuncionario(fulano);
        projeto2.addTarefa(new Tarefa("criar crud 12", "Mandar o programador pensar em como fazer isso"));
        projeto2.addTarefa(new Tarefa("documentar crud 12", "Chamar o estagiario"));
        
		
		tx.begin();
		entityManager.persist(ramon);
        entityManager.persist(fulano);
		entityManager.persist(ciclano);
		
        entityManager.persist(projeto1);
        entityManager.persist(projeto2);
		tx.commit();
		entityManager.close();
		entityManager = entityManagerFactory.createEntityManager();

		List<Projeto> projetos = entityManager.createQuery("SELECT a FROM Projeto a", Projeto.class).getResultList();
		projetos.forEach(Main::print);
		
	}

    private static void print(Projeto projeto) {
        System.out.println(projeto);
        projeto.getEquipe().forEach(System.out::println);
        projeto.getTarefas().forEach(System.out::println);
    }
	
}
