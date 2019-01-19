package com.github.cruzmatheus.urlshortener.resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class StatisticsResourceTest {

    @Autowired
    private MockMvc mockMvc;

    private final String originalUrl = "https://www.google.com";

    @Test
    public void shouldRetrieveStatistics() throws Exception {
        final String url = this.mockMvc.perform(get("/doShort").param("url", originalUrl))
                .andReturn().getResponse().getContentAsString();

        this.mockMvc.perform(get("/redirect").param("shortenedUrl", url))
                .andExpect(status().is(HttpServletResponse.SC_MOVED_TEMPORARILY));

        this.mockMvc.perform(get("/statistics"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].url").value(originalUrl))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].timesAccessed").value(1));
    }

}
