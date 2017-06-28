package br.com.crescer.aula07;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Diandra Rocha
 */
@Entity
@Table(name="GENERO")
public class Genero implements Serializable {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_GENERO")
    @SequenceGenerator(name = "SEQ_GENERO", sequenceName = "SEQ_GENERO", allocationSize = 1)    
    @Basic(optional = false)
    @Column(name = "ID")
    private long id;
    
    @Basic(optional = false)
    @Column(name="DESCRICAO", nullable=false, length=60)
    private String descricao;

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }  
}