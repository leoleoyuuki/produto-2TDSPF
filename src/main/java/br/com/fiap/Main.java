package br.com.fiap;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "fiap" );
        EntityManager manager = factory.createEntityManager();

        Produto produto = new Produto();
        produto.setNome( "Notebook HP" );
        produto.setPreco(6999.99);

        manager.getTransaction().begin();
        manager.persist( produto );
        manager.getTransaction().commit();

        factory.close();
        manager.close();

    }
}