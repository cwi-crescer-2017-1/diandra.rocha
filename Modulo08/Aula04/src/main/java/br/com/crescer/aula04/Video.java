package br.com.crescer.aula04;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diandra Rocha
 */
@Entity
@Table(name="VIDEO")
public class Video implements Serializable{
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_VIDEO")
    @SequenceGenerator(name = "SEQ_VIDEO", sequenceName = "SEQ_VIDEO")    
    @Basic(optional = false)
    @Column(name = "ID")
    private long id;
    
    @Basic(optional = false)
    @Column(name="DURACAO", nullable=false, length=50)
    private String duracao;
    
    @Basic(optional = true)
    @Column(name="VALOR", nullable=true, precision=6, scale=2)
    private double valor;
    
    @Basic(optional = true)
    @Column(name="NOME", nullable=true, length=50)
    private String nome;
    
    @Basic(optional = true)
    @Column(name="QUANTIDADE_ESTOQUE", nullable=true)
    private int quantidade_estoque;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = true)
    @Column(name="DATA_LANCAMENTO", nullable=true)
    private Date data_lancamento;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_GENERO")
    private Genero genero;

    public long getId() {
        return id;
    }

    public String getDuracao() {
        return duracao;
    }

    public double getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}