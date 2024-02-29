package br.com.fiap;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TB_2TDSPF_PIZZARIA")
public class Pizzaria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PIZZARIA")
    @SequenceGenerator(name = "SQ_PIZZRIA" , sequenceName = "SQ_PIZZAARIA", initialValue = 1, allocationSize = 1)
    @Column(name = "ID_PIZZARIA")
    private Long id;

    @Column(name = "NM_PIZZARIA")
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_2TDSPF_CARDAPIO",
            joinColumns = {
                    @JoinColumn(
                            name = "PIZZARIA",
                            referencedColumnName = "ID_PIZZARIA",
                            foreignKey = @ForeignKey(name = "FK_CARDAPIO_PIZZARIA")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(name = "FK_PIZZARIA_CARDAPIO")
                    )
            }
    )
    private List<Produto> cardapio;

}
