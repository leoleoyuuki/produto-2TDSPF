package br.com.fiap;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class    Main {

    public static void main(String[] args) {

            String dia = LocalDate.now().getDayOfWeek().equals(DayOfWeek.MONDAY) ? "fiap" : "casa";



            EntityManagerFactory factory = Persistence.createEntityManagerFactory( dia );
            EntityManager manager = factory.createEntityManager();

            Sabor sabor1 = new Sabor();
            sabor1.setNome("Frango");
            sabor1.setDescricao("Gosotosao");

            Sabor calabresa = Sabor.builder().nome("Calabresa").descricao("A mais Saaborosa Calabresa").build();


        Sabor.SaborBuilder manjericao = Sabor.builder().nome("Manjericao").descricao("Mais deliciosa pizza de majericao");


        Opcional bordaDeCatupiri = new Opcional(null, "Borda de Catupiri", 9.99);

            Opcional bordaPaozinho = new Opcional(null, "Borda paozinho", 19.99);

            Opcional cocaCola = new Opcional(null, "Coca Cola", 19.99);


            Set<Opcional> opcionals = Stream.of(cocaCola, bordaPaozinho, bordaDeCatupiri).collect(Collectors.toSet());

            Produto pizzaDeFrango = new Produto();
            pizzaDeFrango.setNome( "Pizza" );
            pizzaDeFrango.setPreco(69.99);
            pizzaDeFrango.setSabor(sabor1);
            pizzaDeFrango.setOpcionais(opcionals);

        Produto pizzaDeCalabresa = Produto.builder().nome("Pizza de Calabresa").sabor(calabresa).preco(39.90).opcionais(opcionals).build();

        Produto pizzaDeManjericao = Produto.builder().sabor(manjericao.build()).nome("Pizza de manjericao").preco(69.99).opcionais(opcionals).build();

        Set<Produto> cardapio = Stream.of(pizzaDeFrango).collect(Collectors.toSet());

            Pizzaria pizzaria = new Pizzaria();
            pizzaria.setNome("Leozinho's Pizza");
            pizzaria.setCardapio(cardapio);

        Pizzaria damaEDomino = Pizzaria.builder().nome("Dama e Dominó").cardapio(cardapio).build();


        manager.getTransaction().begin();

//            manager.persist( pizzaDeFrango );
//            manager.persist(sabor1);
//            manager.getTransaction().commit();

        manager.persist(pizzaria);
        manager.persist(damaEDomino);
        manager.getTransaction().commit();


            factory.close();
            manager.close();

    }
}