package Productos.Domain.Puertos;

import java.util.List;

import Productos.Domain.Model.Producto;

public interface ProductRepository {
    void create(Producto producto);
    Producto readOne(Integer id);
    List<Producto> readAll();
}
