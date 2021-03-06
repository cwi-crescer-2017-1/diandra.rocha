package br.com.crescer.imovie.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author diandra.rocha
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    private static final String SEQ_NAME = "SEQ_USER";
    
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "IDUSUARIO")
    private long idusuario;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL")
    private String email;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "SENHA")
    private String senha;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOME")
    private String nome;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SEXO")
    private String sexo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DATANASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datanascimento;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Set<Post> postSet;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> amizades;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> amizadesPendentes;

    public Usuario() {
    }

    public Usuario(String email, String senha, String nome, String sexo, Date datanascimento) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.sexo = sexo;
        this.datanascimento = datanascimento;
    }

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }

    public Set<Usuario> getAmizades() {
        return amizades;
    }

    public void setAmizades(Set<Usuario> amizades) {
        this.amizades = amizades;
    }

    public Set<Usuario> getAmizadesPendentes() {
        return amizadesPendentes;
    }

    public void setAmizadesPendentes(Set<Usuario> amizadesPendentes) {
        this.amizadesPendentes = amizadesPendentes;
    }
}
