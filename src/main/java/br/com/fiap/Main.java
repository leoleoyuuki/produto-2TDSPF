package br.com.fiap;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class    Main {

    public static void main(String[] args) {

        String dia = LocalDate.now().getDayOfWeek().equals(DayOfWeek.THURSDAY) ? "casa" : "fiap";



        EntityManagerFactory factory = Persistence.createEntityManagerFactory( dia );
        EntityManager manager = factory.createEntityManager();

        Sabor sabor1 = new Sabor();
        sabor1.setNome("Frango");
        sabor1.setDescricao("Gosotosao");


        Produto produto = new Produto();
        produto.setNome( "Pizza" );
        produto.setPreco(69.99);
        produto.setSabor(sabor1);


        manager.getTransaction().begin();
        manager.persist( produto );
        manager.persist(sabor1);
        manager.getTransaction().commit();

        factory.close();
        manager.close();

    }
}