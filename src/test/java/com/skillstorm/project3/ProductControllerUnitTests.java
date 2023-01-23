package com.skillstorm.project3;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.project3.controllers.ProductController;
import com.skillstorm.project3.models.CustomException;
import com.skillstorm.project3.models.Product;
import com.skillstorm.project3.services.ProductService;

@WebMvcTest(ProductController.class) // This is prevents the full application from loading and only test the controller layer
// @SpringBootTest // this would set up the entire context (all the beans including the service and repo layer which we don't need)
// @SpringBootTest(webEnvironment = WebEnvironment.MOCK) ofr WebEnvironment.DEFINED_PORT, WebEnvironment.RANDOM_PORT, WebEnvironment.NONE
@AutoConfigureMockMvc // This disables spring security if you decide to use that for your project (not needed here)
class ProductControllerUnitTests {
	
	// object that has methods to make "http requests"
	@Autowired
	private MockMvc mockMvc;
	
	// mock of our service layer
	@MockBean
	ProductService service;
	
	//object mapper to convert between Java objects and json
	@Autowired
	ObjectMapper mapper;

	@Test
	void testFindByIdSuccessful() throws JsonProcessingException, Exception {
		// set up a product our mock service will return
		Product product = new Product(1, "Piston Engine","Contiental Motors", 10, 1, "$3,000", "P001");
		
		// mock the method we expect our controller to need to call
		Mockito.when(service.findById(anyInt())).thenReturn(product);

		
		// perform the HTTP Get request
		mockMvc.perform( MockMvcRequestBuilders
							.get("http://localhost:8080/product/") // Don't need the full URL localhost:8080 bc it is not spinning up our embedded server
							.accept(MediaType.APPLICATION_JSON) )
				.andExpect(status().isOk())
				.andExpect(content().string(mapper.writeValueAsString(product)));
		
		verify(service, times(1)).findById(anyInt());
	}
//	
//	
//	@Test
//	void testFindByIdFails() throws JsonProcessingException, Exception {
//
//		// set up a product our mock service will return
////		Product product = new Product("invisiblity", "the superpower of invisiblilty"); // don't need this!
//		
//		int id = 522;
//		
//		String msg = "No product exists with id of " + id + ".";
//		
//		// mock the method we expect our controller to need to call
//		Mockito.when(service.findById(anyInt())).thenThrow(new CustomException(msg));
//		
//		// perform the HTTP Get request
//		mockMvc.perform( MockMvcRequestBuilders
//							.get("/products/" + id)
//							.accept(MediaType.APPLICATION_JSON) )
//				.andExpect(status().is4xxClientError()) // TODO match this exactly find a matcher to do so!
//				.andExpect(content().string(msg));
//		
//		verify(service, times(1)).findById(anyInt());
//	}
//	
//	@Test
//	void testSaveSuccessful() throws JsonProcessingException, Exception {
//		// set up a product for the mock service layer to return to us
//		Product product = new Product("Piston", "Contienta", 2, 30, 5, 0);
//		Mockito.when(service.save(any())).thenReturn(product);
//		
//		// perform the POST http request
//		mockMvc.perform( MockMvcRequestBuilders
//				.post("/products" )
//				.content(mapper.writeValueAsString(product))
//			    .contentType(MediaType.APPLICATION_JSON) )// make sure you set the contentType header on your mock HTTP POST request
////				.accept(MediaType.APPLICATION_JSON) ) // isn't necessary for this test HTTP POST request to work
//		.andExpect(status().isCreated()) 
//		.andExpect(content().string(mapper.writeValueAsString(product)));
//		
//		verify(service, times(1)).save(any());
//	}
//	
//	@Test
//	void testSaveFailure() throws JsonProcessingException, Exception {
//		// set up a product for the mock service layer to return to us
//		Product product = new Product("Piston", "Contienta", 2, 30, 5, 0);
//		Mockito.when(service.save(any())).thenThrow(new CustomException("A product already exists with id of " + product.getId() + "."));
//		
//		// perform the POST http request
//		mockMvc.perform( MockMvcRequestBuilders
//				.post("/products" )
//				.content(mapper.writeValueAsString(product))
//			    .contentType(MediaType.APPLICATION_JSON) )// make sure you set the contentType header on your mock HTTP POST request
////				.accept(MediaType.APPLICATION_JSON) ) // isn't necessary for this test HTTP POST request to work
//		.andExpect(status().isBadRequest()) 
//		.andExpect(content().string("A product already exists with id of " + product.getId() + "."));
//		
//		verify(service, times(1)).save(any());
//	}
//	
//	@Test
//	void testUpdateSuccessful() {
//		// TODO 
//	}
//	
//	@Test
//	void testUpdateFailure() {
//		// TODO
//	}
}