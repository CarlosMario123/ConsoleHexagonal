package Productos.Infraestructura;

import java.util.LinkedList;
import java.util.List;

import Productos.Domain.Model.Producto;
import Productos.Domain.Puertos.ProductRepository;

public class ProductColaRepo implements ProductRepository {
    private LinkedList<Producto> productos = new LinkedList<Producto>();
    private static int index = 1;
    @Override
    public void create(Producto producto) {
          producto.setId(index);
          productos.add(producto);
          index++;
          System.out.println("producto creado correctamente");
        
    }

    @Override
    public List<Producto> readAll() {
        
        return productos;
    }

    @Override
    public Producto readOne(Integer id) {
         Producto producto = productos.get(id);
         
        return producto;
    }
    
}
