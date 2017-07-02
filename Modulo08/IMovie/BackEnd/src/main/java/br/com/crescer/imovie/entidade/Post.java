package br.com.crescer.imovie.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
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
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findByIdpost", query = "SELECT p FROM Post p WHERE p.idpost = :idpost"),
    @NamedQuery(name = "Post.findByConteudo", query = "SELECT p FROM Post p WHERE p.conteudo = :conteudo"),
    @NamedQuery(name = "Post.findByDatapost", query = "SELECT p FROM Post p WHERE p.datapost = :datapost"),
    @NamedQuery(name = "Post.findByUrlfoto", query = "SELECT p FROM Post p WHERE p.urlfoto = :urlfoto")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPOST")
    private BigDecimal idpost;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpost")
    private Set<Comentario> comentarioSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpost")
    private Set<Curtida> curtidaSet;

    public Post() {
    }

    public Post(BigDecimal idpost) {
        this.idpost = idpost;
    }

    public Post(BigDecimal idpost, String conteudo, Date datapost, String urlfoto) {
        this.idpost = idpost;
        this.conteudo = conteudo;
        this.datapost = datapost;
        this.urlfoto = urlfoto;
    }

    public BigDecimal getIdpost() {
        return idpost;
    }

    public void setIdpost(BigDecimal idpost) {
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

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.idpost == null && other.idpost != null) || (this.idpost != null && !this.idpost.equals(other.idpost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.imovie.entidade.Post[ idpost=" + idpost + " ]";
    }
    
}
