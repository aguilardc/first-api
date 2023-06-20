package com.first.api.controller;

import com.first.api.model.Producto;
import com.first.api.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
    private ProductoService productoService;

    @PostMapping
    public Producto agregar(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @GetMapping
    public List<Producto> listar() {
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable int id) {
        return productoService.getById(id);
    }

    @PutMapping
    public Producto actualizar(@RequestBody Producto producto) {
        return productoService.update(producto);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return productoService.delete(id);
    }
}
