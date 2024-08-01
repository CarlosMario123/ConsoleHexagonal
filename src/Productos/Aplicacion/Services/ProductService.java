package Productos.Aplicacion.Services;

import java.util.List;

import Productos.Domain.Model.Producto;
import Productos.Domain.Puertos.ProductRepository;

public class ProductService implements ProductRepository{
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
     @Override
    public void create(Producto producto){

        repository.create(producto);

    }
    @Override
    public Producto readOne(Integer id){
        return repository.readOne(id);
    }

    @Override
    public List<Producto> readAll() {
        return repository.readAll();
    }
}
