package com.skillstorm.project3;



	import static org.assertj.core.api.Assertions.assertThat;
	import static org.junit.jupiter.api.Assertions.assertThrows;
	import static org.mockito.ArgumentMatchers.any;
	import static org.mockito.ArgumentMatchers.anyInt;
	import static org.mockito.Mockito.never;
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;

	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.junit.jupiter.MockitoExtension;

import com.skillstorm.project3.models.CustomException;
import com.skillstorm.project3.models.Product;
import com.skillstorm.project3.repositories.ProductRepository;
import com.skillstorm.project3.services.ProductServiceImpl;


	// @WebMockMvc // let's not turn this layer on bc we don't need the client request
	// @SpringBootTest // let's not load the whole context just the parts of the application under test
	@ExtendWith(MockitoExtension.class) // UNIT TEST just the service layer
	class ProductServiceTests {
		
		private static Product product;
		
		@BeforeAll
		static void setup() {
			product = new Product(1, "Piston Engine","Contiental Motors", 10, 1, "$3,000", "P001");
		}
		
		@Mock
		private ProductRepository repo; // this is an empty object! 
		
		@InjectMocks
		private ProductServiceImpl service; // this is the object we are testing the behavior of!
		
		// Positive test of update
		@Test
		void testUpdateSuccess() throws CustomException {
			
			when(repo.existsById(anyInt())).thenReturn(true);
			when(repo.save(product)).thenReturn(product);
			
			// perform the method call
			Product updatedProduct = service.update(product, 1);
			
			
			// assert 
			assertThat(updatedProduct).isNotNull(); // is it handing something back to the controller who is going to be the actual caller
			
			verify(repo, times(1)).existsById(anyInt());
			verify(repo, times(1)).save(any());
		}
		
		// Negative test
		@Test
		void testUpdateFailure() throws CustomException {
			when(repo.existsById(anyInt())).thenReturn(false);
//			when(repo.save(product)).thenReturn(product); // This will cause Mockito to get annoyed I'm wasting time mocking something that doesn't get called
			
			int id = 1;
			
			// perform the method call
			CustomException e = assertThrows(CustomException.class, () -> service.update(product, id));
			
			
			// assert 
			assertThat(e.getMessage()).isEqualTo("Update didn't work bc there is no existing record with the given id " + id +".");
			
			verify(repo, times(1)).existsById(anyInt());
			verify(repo, never()).save(any());
		}
		
		// TODO write a service layer test for .save and .delete
		
	}
