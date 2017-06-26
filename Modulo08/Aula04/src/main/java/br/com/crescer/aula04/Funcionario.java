package br.com.crescer.aula04;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diandra Rocha
 */

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FUNCIONARIO")
    @SequenceGenerator(name = "SEQ_FUNCIONARIO", sequenceName = "SEQ_FUNCIONARIO", allocationSize = 1)    
    @Basic(optional = false)
    @Column(name = "ID")
    private long id;
    
    @Basic(optional = false) //modifica a nível de objeto
    @Column(name="NOME", nullable=false, length=60) //modifica a nível de banco
    private String nome;
    
    @Basic(optional = true)
    @Column(name="CIDADE", nullable=true, length=60)
    private String cidade;
    
    @Basic(optional = true)
    @Column(name="BAIRRO", nullable=true, length=60)
    private String bairro;
    
    @Basic(optional = true)
    @Column(name="NUMERO_CASA", nullable=true, length=10)
    private String numero_casa;
    
    @Basic(optional = true)
    @Column(name="RUA", nullable=true, length=80)
    private String rua;
   
    @Basic(optional = false)
    @Column(name="CPF", nullable=false, length=11)
    private String CPF;
    
    @Basic(optional = false)
    @Column(name="RG", nullable=false, length=15)
    private String RG;
    
    @Basic(optional = true)
    @Column(name="EMAIL", nullable=true, length=100)
    private String email;
    
    @Basic(optional = true)
    @Column(name="TELEFONE", nullable=true, length=50)
    private String telefone;
    
    @Basic(optional = true)
    @Column(name="CELULAR", nullable=true, length=50)
    private String celular;
    
    @Basic(optional = true)
    @Column(name="SALARIO", nullable=true, precision=10, scale=2)
    private double salario;
    
    @Basic(optional = true)
    @Column(name="FUNCAO", nullable=true, length=50)
    private String funcao;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = true)
    @Column(name="NASCIMENTO", nullable=true)
    private Date nascimento;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getBairro() {
        return bairro;
    }

    public String getNumero_casa() {
        return numero_casa;
    }

    public String getRua() {
        return rua;
    }

    public String getCPF() {
        return CPF;
    }

    public String getRG() {
        return RG;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public double getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}