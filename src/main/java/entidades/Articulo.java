package entidades;

import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Articulo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Audited
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Cantidad")
    private int cantidad;

    @Column(name = "Denominacion")
    private String denominacion;

    @Column(name = "Precio")
    private int precio;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
    @Builder.Default
    @NotAudited
    private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categoria = new ArrayList<Categoria>();


    public Articulo(int cantidad, String denominacion, int precio) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public String getDenominacion() {
        return denominacion;
    }


    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }


    public int getPrecio() {
        return precio;
    }


    public void setPrecio(int precio) {
        this.precio = precio;
    }


    public List<DetalleFactura> getDetalles() {
        return detalles;
    }


    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }


    public List<Categoria> getCategoria() {
        return categoria;
    }


    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }


}
