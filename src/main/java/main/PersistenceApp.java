package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;

public class PersistenceApp {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
        EntityManager em = emf.createEntityManager();


        try {
            em.getTransaction().begin();

            /*Factura factura1 = new Factura();

            factura1.setNumero(12);
            factura1.setFecha("10/09/2021");

            Domicilio dom = Domicilio.builder().nombreCalle("San Martin").numero(3456).build();
            Cliente cliente = Cliente.builder().nombre("Marta").apellido("Rosales").dni(15674987).build();
            cliente.setDomicilio(dom);
            dom.setCliente(cliente);

            Categoria perecederos = Categoria.builder().denominacion("Perecederos").build();
            Categoria lacteos = Categoria.builder().denominacion("Lacteos").build();
            Categoria limpieza = Categoria.builder().denominacion("Limpieza").build();

            Articulo art1 = Articulo.builder().cantidad(200).denominacion("Yogurth Ser sabor frutilla").precio(20).build();
            Articulo art2 = Articulo.builder().cantidad(300).denominacion("Detergente Magistral").precio(80).build();

            art1.getCategoria().add(perecederos);
            art1.getCategoria().add(lacteos);
            lacteos.getArticulos().add(art1);
            perecederos.getArticulos().add(art1);

            art2.getCategoria().add(limpieza);
            limpieza.getArticulos().add(art2);

            DetalleFactura det1 = new DetalleFactura();
            det1.setArticulo(art1);
            det1.setCantidad(2);
            det1.setSubtotal(40);

            art1.getDetalles().add(det1);
            factura1.getDetalles().add(det1);
            det1.setFactura(factura1);

            DetalleFactura det2 = new DetalleFactura();

            det2.setArticulo(art2);
            det2.setCantidad(1);
            det2.setSubtotal(80);

            art2.getDetalles().add(det2);
            factura1.getDetalles().add(det2);
            det2.setFactura(factura1);

            factura1.setTotal(120);

             */

            Factura factura1 = em.find(Factura.class, 1L);
            factura1.setNumero(85);

            em.remove(factura1);

            //em.merge(factura1);

            em.flush();

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        emf.close();
    }
}
