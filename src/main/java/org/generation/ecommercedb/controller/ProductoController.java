package org.generation.ecommercedb.controller;

import java.util.List;

import org.generation.ecommercedb.model.Producto;
import org.generation.ecommercedb.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/productos/")
public class ProductoController {
	private final ProductoService prodService;
	@Autowired
	public ProductoController(ProductoService prodService) {
		this.prodService = prodService;
	} //constructor
	
	@GetMapping
	public List<Producto> getProductos(){
		return prodService.getProductos();
	}// getProductos
	
	@GetMapping(path="{prodId}")
	public Producto getProducto(@PathVariable("prodId") Long prodId){
		return prodService.getProducto(prodId);
	}// getProducto
	
	@DeleteMapping(path="{prodId}")
	public void deleteProducto(@PathVariable("prodId") Long prodId) {
		prodService.deleteProducto(prodId);
	}//deleteProducto
	
	@PostMapping
	public void addProducto(@RequestBody Producto prod) {
		prodService.addProducto(prod);
	}//addProducto
	
	@PutMapping(path="{prodId}")
    public void updateProducto(@PathVariable("prodId") Long prodId,
    		@RequestParam(required=false) String nombre, 
    		@RequestParam(required=false) String descripcion,
    		@RequestParam(required=false) double precio,
    		@RequestParam(required=false) String url_Imagen) {
		prodService.updateProducto (prodId, nombre, descripcion,
				precio, url_Imagen);
	}// updateProducto
	
	
	
}//class ProductoController
