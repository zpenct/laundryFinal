package com.example.demo;

import com.example.demo.controller.LaundryController;
import com.example.demo.controller.UserController;
import com.example.demo.dto.FasilitasRequestDTO;
import com.example.demo.dto.LaundryRequestDTO;
import com.example.demo.dto.LaundryResponseDTO;
import com.example.demo.dto.login.LoginRequestDTO;
import com.example.demo.dto.regsitration.RegistrationRequestDTO;
import com.example.demo.model.User;
import com.example.demo.repository.FasilitasRepos;
import com.example.demo.repository.LaundryRepos;
import com.example.demo.service.LaundryService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LaundryController.class)
class LaundryfinalApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LaundryService laundryService;

	@Test
	void itShouldCreateLaundry() throws Exception {

		LaundryRequestDTO dto = new LaundryRequestDTO("NAMA", "LOKASI", "07", "09", "123",
				Arrays.asList(
						new FasilitasRequestDTO("fasilitas 1", 1000),
						new FasilitasRequestDTO("fasilitas 2", 2000)
				)
		);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson=ow.writeValueAsString(dto);

		mockMvc
				.perform(
						post("/v1/laundry")
								.contentType(APPLICATION_JSON_UTF8)
								.content(requestJson)
				)
				.andExpect(status().isOk())
		;
	}

	@Test
	void itShouldGetListOfLaundry() throws Exception {
		mockMvc
				.perform(
						get("/v1/laundry")
				)
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
	}

	@Test
	void itShouldGetListOfLaundryBaseOnLocationQuery() throws Exception {
		mockMvc
				.perform(
						get("/v1/laundry?lokasi=ma")
				)
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
	}
	@Test
	void itShouldGetLaundry_id1() throws Exception {
		mockMvc
				.perform(
						get("/v1/laundry/1")
				)
				.andExpect(status().isOk());
	}


}