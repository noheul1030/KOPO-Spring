package kr.ac.kopo.ctc.kopo11.board.web;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/sample1")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("title")));
	}
	
	@Test
	public void list() throws Exception {
		this.mockMvc.perform(get("/sample1")).andExpect(status().isOk());
	}
	@Test
	public void list2() throws Exception {
		this.mockMvc.perform(get("/sample2")).andExpect(status().isOk());
	}
	@Test
	public void list3() throws Exception {
		this.mockMvc.perform(get("/sample3")).andExpect(status().isOk());
	}
	@Test
	public void mapper() throws Exception {
		this.mockMvc.perform(get("/mapper")).andExpect(status().isOk());
	}
	@Test
	public void findAllByCondition() throws Exception {
		this.mockMvc.perform(get("/findAllByCondition")).andExpect(status().isOk());
	}
}
