package com.first.api.repository;

import com.first.api.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductoRepository {
    private List<Producto> productos = new ArrayList<>();

    public void create() {
        productos = List.of(
                new Producto(1, "Produto 01", 10, 1000),
                new Producto(2, "Produto 02", 11, 9000),
                new Producto(3, "Produto 03", 12, 8000),
                new Producto(4, "Produto 04", 13, 7000),
                new Producto(5, "Produto 05", 14, 6000),
                new Producto(6, "Produto 06", 15, 5000),
                new Producto(7, "Produto 07", 16, 4000),
                new Producto(8, "Produto 08", 17, 3000),
                new Producto(9, "Produto 09", 18, 2000)
        );
    }

    public List<Producto> getAllProducts() {
        return productos;
    }

    /**
     * @param id
     * @return
     */
    public Producto findById(int id) {
        return productos
                .stream()
                .filter(product -> product.getId() == id)
                .findAny()
                .orElse(null);

//        for (int i = 0; i < productos.size(); i++) {
//            if (productos.get(i).getId() == id) {
//                return productos.get(i);
//            }
//        }
//        return null;
    }

    /**
     * @param nombre
     * @return
     */
    public List<Producto> search(String nombre) {
        return productos
                .stream()
                .filter(x -> x.getNombre().startsWith(nombre))
                .collect(Collectors.toList());
    }

    /**
     * @param product
     * @return
     */
    public Producto save(Producto product) {
        Producto producto = new Producto();
        producto.setId(product.getId());
        producto.setNombre(product.getNombre());
        producto.setCantidad(product.getCantidad());
        producto.setPrecio(product.getPrecio());

        productos.add(producto);
        return producto;
    }

    /**
     * @param producto
     * @return
     */
    public Producto update(Producto producto) {

        return (Producto) productos
                .stream()
                .map(producto1 -> {
                    if (producto1.getId() == producto.getId()) {
                        producto1.setId(producto.getId());
                        producto1.setNombre(producto.getNombre());
                        producto1.setCantidad(producto.getCantidad());
                        producto1.setPrecio(producto.getPrecio());
                        return producto1;
                    }
                    return null;
                });

//        Producto producto1 = new Producto();
//        for (int i = 0; i < productos.size(); i++) {
//            if (productos.get(i).getId() == producto.getId()) {
//                producto1.setId(producto.getId());
//                producto1.setNombre(producto.getNombre());
//                producto1.setCantidad(producto.getCantidad());
//                producto1.setPrecio(producto.getPrecio());
//                productos.set(i, producto);
//                break;
//            }
//        }
//
//        return producto1;
    }

    /**
     * @param id
     * @return
     */
    public String delete(int id) {
        productos.removeIf(producto -> producto.getId() == id);
        return null;
    }
}
