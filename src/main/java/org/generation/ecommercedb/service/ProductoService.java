package org.generation.ecommercedb.service;
import java.util.List;
import java.util.Optional;

import org.generation.ecommercedb.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductoService {

	private final ProductosRepository productosRepository;
	
	@Autowired
	public ProductoService(ProductosRepository productosRepository) {
		this.productosRepository = productosRepository;
	}//constructor
	
	public List<Producto> getProductos() {
		return productosRepository.findAll();
	}//getProductos

	public Producto getProducto(Long prodId) {
		return productosRepository.findById(prodId).
				orElseThrow(()-> new IllegalStateException("El Producto "
						+ "con el id " + prodId + " no existe.") );
	}//getProducto

	public void deleteProducto(Long prodId) {
		if (productosRepository.existsById(prodId)) {
			productosRepository.deleteById(prodId);	
		}// if exist
	} // deleteProducto

	public void addProducto(Producto prod) {
		Optional<Producto> prodByName = 
				productosRepository.findByNombre(prod.getNombre());
		if (prodByName.isPresent()) {
			throw new IllegalStateException("El producto con el nombre "
					+ "[" + prod.getNombre() + "] ya existe.");
		} else {
			productosRepository.save(prod);
		}//else //if 
	}//addProducto
 
	public void updateProducto(Long prodId, String nombre, String descripcion, double precio, String url_Imagen) {
		if (productosRepository.existsById(prodId)) { 
			Producto p = productosRepository.getById(prodId);
			if (nombre != null) p.setNombre(nombre); 
			if (descripcion != null) p.setDescripcion(descripcion);
			if (precio != 0) p.setPrecio(precio);
			System.out.println("getPrecio: " + p.getPrecio());
			if (url_Imagen !=null) p.setURL_Imagen(url_Imagen);
			productosRepository.save(p);
		}else {
			System.out.println("No existe el id "+prodId);
			System.err.println("*No existe el id "+prodId);
		}// if 		
	} // updateProducto

}//class ProductoService