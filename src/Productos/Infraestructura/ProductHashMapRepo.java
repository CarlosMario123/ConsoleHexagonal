package Productos.Infraestructura;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Productos.Domain.Model.Producto;
import Productos.Domain.Puertos.ProductRepository;

public class ProductHashMapRepo implements ProductRepository{
    private final Map<Integer, Producto> productos = new HashMap<>();
    private static Integer id = 1;
    @Override
    public void create(Producto producto) {
        producto.setId(id);
        productos.put(producto.getId(), producto);
        System.out.println("producto creado correctamente");
        id++;
        
    }

    @Override
    public List<Producto> readAll() {
       return productos.values().stream().collect(Collectors.toList());
    }

    @Override
    public Producto readOne(Integer id) {
        Producto producto = productos.get(id);
        return producto;
    }
    
}
