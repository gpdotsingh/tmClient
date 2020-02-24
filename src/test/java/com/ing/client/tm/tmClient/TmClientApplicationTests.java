package com.ing.client.tm.tmClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)

public class TmClientApplicationTests {
	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext context;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void getTransactionList() throws Exception {

		mockMvc.perform(get("/client/tm" ).param("startDate","2010-10-11 21:09:09").param("endtDate","2010-10-11 21:09:09")).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getUserList() throws Exception {
		mockMvc.perform(get("/client/name" ).param("nameChar","a")).andExpect(status().isOk());
	}
}
