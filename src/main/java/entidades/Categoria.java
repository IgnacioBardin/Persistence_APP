package entidades;

import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categoria")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Audited
public class Categoria implements Serializable{


    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name= "denominacion")
    private String denominacion;

    @ManyToMany(mappedBy = "categoria")
    private List<Articulo> articulos = new ArrayList<Articulo>();
    
    public Categoria(String denominacion) {
        this.denominacion = denominacion;
    }


    public String getDenominacion() {
		return denominacion;
	}



	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}



	public List<Articulo> getArticulos() {
		return articulos;
	}



	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}


    



}
