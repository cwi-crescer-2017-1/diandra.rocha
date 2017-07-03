package br.com.crescer.imovie.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "POST")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPOST")
    private long idpost;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CONTEUDO")
    private String conteudo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATAPOST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datapost;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "URLFOTO")
    private String urlfoto;
    
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario idusuario;
    
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Comentario> comentarioSet;
    
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Curtida> curtidaSet;

    public Post() {
    }

    public Post(String conteudo, Date datapost, String urlfoto, Usuario idusuario) {
        this.conteudo = conteudo;
        this.datapost = datapost;
        this.urlfoto = urlfoto;
        this.idusuario = idusuario;
    }

    public long getIdpost() {
        return idpost;
    }

    public void setIdpost(long idpost) {
        this.idpost = idpost;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDatapost() {
        return datapost;
    }

    public void setDatapost(Date datapost) {
        this.datapost = datapost;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Set<Comentario> getComentarioSet() {
        return comentarioSet;
    }

    public void setComentarioSet(Set<Comentario> comentarioSet) {
        this.comentarioSet = comentarioSet;
    }

    public Set<Curtida> getCurtidaSet() {
        return curtidaSet;
    }

    public void setCurtidaSet(Set<Curtida> curtidaSet) {
        this.curtidaSet = curtidaSet;
    }
    
}