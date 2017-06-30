package br.com.crescer.imovie.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author diandra.rocha
 */
@Entity
@Table(name = "CURTIDA")
@NamedQueries({
    @NamedQuery(name = "Curtida.findAll", query = "SELECT c FROM Curtida c"),
    @NamedQuery(name = "Curtida.findByIdcurtida", query = "SELECT c FROM Curtida c WHERE c.idcurtida = :idcurtida")})
public class Curtida implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCURTIDA")
    private BigDecimal idcurtida;
    
    @JoinColumn(name = "IDPOST", referencedColumnName = "IDPOST")
    @ManyToOne(optional = false)
    private Post idpost;
    
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Curtida() {
    }

    public Curtida(BigDecimal idcurtida) {
        this.idcurtida = idcurtida;
    }

    public BigDecimal getIdcurtida() {
        return idcurtida;
    }

    public void setIdcurtida(BigDecimal idcurtida) {
        this.idcurtida = idcurtida;
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
        if (!(object instanceof Curtida)) {
            return false;
        }
        Curtida other = (Curtida) object;
        if ((this.idcurtida == null && other.idcurtida != null) || (this.idcurtida != null && !this.idcurtida.equals(other.idcurtida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.imovie.entidade.Curtida[ idcurtida=" + idcurtida + " ]";
    }
    
}
