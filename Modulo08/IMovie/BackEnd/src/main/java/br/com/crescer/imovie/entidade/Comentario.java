package br.com.crescer.imovie.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "COMENTARIO")
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findByIdcomentario", query = "SELECT c FROM Comentario c WHERE c.idcomentario = :idcomentario"),
    @NamedQuery(name = "Comentario.findByConteudo", query = "SELECT c FROM Comentario c WHERE c.conteudo = :conteudo"),
    @NamedQuery(name = "Comentario.findByDatacomentario", query = "SELECT c FROM Comentario c WHERE c.datacomentario = :datacomentario")})
public class Comentario implements Serializable {

    private static final String SEQ_NAME = "SEQ_COMENTARIO";
    
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "IDCOMENTARIO")
    private long idcomentario;
    
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

    public Comentario(String conteudo){
        this.conteudo = conteudo;
    }

    public long getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(long idcomentario) {
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
}