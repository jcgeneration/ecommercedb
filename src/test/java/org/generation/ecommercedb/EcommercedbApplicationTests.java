package org.generation.ecommercedb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
@SpringBootTest
@AutoConfigureMockMvc
class EcommercedbApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGet() throws Exception {
		this.mockMvc.perform(get("/api/productos/6")	)
		.andDo(print())
		.andExpect(status().isOk()).andExpect(content().string(containsString("tinta") ));
	
	} // testGet
	
	
}//class


