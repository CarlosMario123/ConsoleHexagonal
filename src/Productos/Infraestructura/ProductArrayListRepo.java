package Productos.Infraestructura;

import java.util.ArrayList;
import java.util.List;

import Productos.Domain.Model.Producto;
import Productos.Domain.Puertos.ProductRepository;

public class ProductArrayListRepo implements ProductRepository {
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    static private int  incremental = 1;
    @Override
    public void create(Producto producto) {
           producto.setId(incremental);
           productos.add(producto);
           incremental++;
           System.out.println("Producto agregado correctamente");
        
    }

    @Override
    public List<Producto> readAll() {
        return  productos;
    }

    @Override
    public Producto readOne(Integer id) {
        Producto producto = productos.get(id);
        return producto;
    }
    
}
