package br.com.fiap;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_2TDSPF_SABOR")
public class Sabor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SABOR")
    @SequenceGenerator(name = "SQ_SABOR" , sequenceName = "SQ_SABOR", initialValue = 1, allocationSize = 50)
    @Column(name = "ID_SABOR")
    private Long id;

    @Column(name = "NM_SABOR")
    private String nome;

    @Column(name = "DS_SABOR")
    private String descricao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Sabor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
