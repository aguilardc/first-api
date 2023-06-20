package com.first.api.service;

import com.first.api.model.Producto;
import com.first.api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    /**
     * @param producto
     * @return
     */
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    /**
     * @return
     */
    public List<Producto> getAll() {
        return productoRepository.getAllProducts();
    }

    /**
     * @param id
     * @return
     */
    public Producto getById(int id) {
        return productoRepository.findById(id);
    }

    /**
     * @param producto
     * @return
     */
    public Producto update(Producto producto) {
        return productoRepository.update(producto);
    }

    /**
     * @param id
     * @return
     */
    public String delete(int id) {
        productoRepository.delete(id);
        return "Producto eliminado!!" + id;
    }
}
