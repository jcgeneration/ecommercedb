package org.generation.ecommercedb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.generation.ecommercedb.model.Producto;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
@SpringBootTest
@AutoConfigureMockMvc
class EcommercedbApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGet() throws Exception {
		this.mockMvc.perform(get("/api/productos/7")	)
		.andDo(print())
		.andExpect(status().isOk()).andExpect(content().string(containsString("tinta") ));
	} // testGet

	@Test
public void testPost() throws Exception {
		Producto p = new Producto();
		p.setNombre("Plumón tinta fugaz Pequeño 1");
		p.setDescripcion("Plumón tinta fugaz pequeño color azul para pintarrón");
		p.setURL_Imagen("plumonVerde.jpg");
		p.setPrecio(21.0);
		
	this.mockMvc.perform( post("/api/productos/").header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYyIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNjQ2MjQxNzQyLCJleHAiOjE2NDYyNzc3NDJ9.mtwIriAFIusN87G-Pm3id7KsMcJGE0bk24IYhOTkeGk")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(p))).andExpect(status().isOk());
	} // testPost
	
	//Serializar
	  public static String asJsonString(final Object obj) {
		    try {
		      return new ObjectMapper().writeValueAsString(obj);
		    } catch (Exception e) {
		      throw new RuntimeException(e);
		    }//catch
	 } // asJsonString
	
	
}//class


