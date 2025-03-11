package net.mausberg.myfinancesbackend.controller;

import net.mausberg.myfinancesbackend.model.Sentence;
import net.mausberg.myfinancesbackend.service.SentenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class SentenceControllerTest {

    @Mock
    private SentenceService sentenceService;

    @InjectMocks
    private SentenceController sentenceController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(sentenceController).build();
    }

    @Test
    void testGetSentenceById() throws Exception {
        Sentence sentence = new Sentence();
        sentence.setId(1L);
        sentence.setDescription("Test description");

        when(sentenceService.getSentenceById(1L)).thenReturn(Optional.of(sentence));

        mockMvc.perform(get("/sentences/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.description").value("Test description"));
    }
}