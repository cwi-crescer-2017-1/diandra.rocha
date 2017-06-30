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
import javax.validation.constraints.Size;

/**
 *
 * @author diandra.rocha
 */
@Entity
@Table(name = "AMIZADE")
@NamedQueries({
    @NamedQuery(name = "Amizade.findAll", query = "SELECT a FROM Amizade a"),
    @NamedQuery(name = "Amizade.findByIdamizade", query = "SELECT a FROM Amizade a WHERE a.idamizade = :idamizade"),
    @NamedQuery(name = "Amizade.findByStatus", query = "SELECT a FROM Amizade a WHERE a.status = :status")})
public class Amizade implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDAMIZADE")
    private BigDecimal idamizade;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STATUS")
    private String status;
    
    @JoinColumn(name = "IDUSUARIOENVIOU", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario idusuarioenviou;
    
    @JoinColumn(name = "IDUSUARIORECEBEU", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario idusuariorecebeu;

    public Amizade() {
    }

    public Amizade(BigDecimal idamizade) {
        this.idamizade = idamizade;
    }

    public Amizade(BigDecimal idamizade, String status) {
        this.idamizade = idamizade;
        this.status = status;
    }

    public BigDecimal getIdamizade() {
        return idamizade;
    }

    public void setIdamizade(BigDecimal idamizade) {
        this.idamizade = idamizade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getIdusuarioenviou() {
        return idusuarioenviou;
    }

    public void setIdusuarioenviou(Usuario idusuarioenviou) {
        this.idusuarioenviou = idusuarioenviou;
    }

    public Usuario getIdusuariorecebeu() {
        return idusuariorecebeu;
    }

    public void setIdusuariorecebeu(Usuario idusuariorecebeu) {
        this.idusuariorecebeu = idusuariorecebeu;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amizade)) {
            return false;
        }
        Amizade other = (Amizade) object;
        if ((this.idamizade == null && other.idamizade != null) || (this.idamizade != null && !this.idamizade.equals(other.idamizade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.imovie.entidade.Amizade[ idamizade=" + idamizade + " ]";
    }
    
}
