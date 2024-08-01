import java.util.Scanner;

import Productos.Aplicacion.Services.ProductService;
import Productos.Domain.Model.Producto;
import Productos.Infraestructura.ProductArrayListRepo;
import Productos.Infraestructura.ProductColaRepo;
import Productos.Infraestructura.ProductHashMapRepo;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = null;//Servicio a usar para los repositorios de productos
        ProductArrayListRepo repoArrayList = new ProductArrayListRepo();//Repository usando arrayList
        ProductColaRepo repoColaList = new ProductColaRepo();//Repository usando Colas
        ProductHashMapRepo repoHash = new ProductHashMapRepo();//Repositorio usando hashMap
        
        int opcion = 0;
        while (opcion < 1 || opcion > 3 ){
        System.out.println("-------------------------------------------");
        System.out.println("Escoje algun repositorio");
        System.out.println("-------------------------------------------");
        System.out.println("1)Repositorio usando ArrayList");
        System.out.println("2)Repositorio usando Cola");
        System.out.println("3)Repositorio usando HashMap");
        opcion = scanner.nextInt();

        }
          switch (opcion) {
            case 1:
                productService = new ProductService(repoArrayList);
                break;
            
            case 2:
                productService = new ProductService(repoColaList);
                 break;

            case 3:
                productService = new ProductService(repoHash);
            default:
                break;
          }
        
        //Realizando los test dependiendo del repositorio escojido
        createProduct(productService);
        showProduct(productService);

         
        


    }


    public static void createProduct(ProductService productService){
        productService.create(new Producto(null, "Pepsi",(double)18));
        productService.create(new Producto(null, "Coca cola",(double)20));
        productService.create(new Producto(null, "Fanta",(double)17));
        productService.create(new Producto(null, "Mamut",(double)10));
    }


    public static void showProduct(ProductService productService){
        System.out.println("---------------------------------------------------------------");
        System.out.println("Listar nombre producto usando ProductArrayListRepo");
        System.out.println("---------------------------------------------------------------");
        for(Producto producto : productService.readAll()){
             System.out.println(producto.getNombre());
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("          Un producto selecionado por id");
        System.out.println("-------------------------------------------------------------------");
        System.out.println(productService.readOne(2));
    }

}
