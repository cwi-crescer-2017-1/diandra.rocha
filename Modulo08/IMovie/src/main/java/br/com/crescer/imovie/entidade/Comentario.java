package br.com.crescer.imovie.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "COMENTARIO")
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findByIdcomentario", query = "SELECT c FROM Comentario c WHERE c.idcomentario = :idcomentario"),
    @NamedQuery(name = "Comentario.findByConteudo", query = "SELECT c FROM Comentario c WHERE c.conteudo = :conteudo"),
    @NamedQuery(name = "Comentario.findByDatacomentario", query = "SELECT c FROM Comentario c WHERE c.datacomentario = :datacomentario")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCOMENTARIO")
    private BigDecimal idcomentario;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "CONTEUDO")
    private String conteudo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATACOMENTARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacomentario;
    
    @JoinColumn(name = "IDPOST", referencedColumnName = "IDPOST")
    @ManyToOne(optional = false)
    private Post idpost;
    
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Comentario() {
    }

    public Comentario(BigDecimal idcomentario) {
        this.idcomentario = idcomentario;
    }

    public Comentario(BigDecimal idcomentario, String conteudo, Date datacomentario) {
        this.idcomentario = idcomentario;
        this.conteudo = conteudo;
        this.datacomentario = datacomentario;
    }

    public BigDecimal getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(BigDecimal idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDatacomentario() {
        return datacomentario;
    }

    public void setDatacomentario(Date datacomentario) {
        this.datacomentario = datacomentario;
    }
    
    public Post getIdpost() {
        return idpost;
    }

    public void setIdpost(Post idpost) {
        this.idpost = idpost;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.idcomentario == null && other.idcomentario != null) || (this.idcomentario != null && !this.idcomentario.equals(other.idcomentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.imovie.entidade.Comentario[ idcomentario=" + idcomentario + " ]";
    }
    
}
