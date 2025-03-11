package net.mausberg.myfinancesbackend.service;

import net.mausberg.myfinancesbackend.model.Sentence;
import net.mausberg.myfinancesbackend.repository.SentenceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SentenceServiceTest {

    @Mock
    private SentenceRepository sentenceRepository;

    @InjectMocks
    private SentenceService sentenceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateSentence() {
        Sentence sentence = new Sentence();
        sentence.setDescription("Test description");

        when(sentenceRepository.save(sentence)).thenReturn(sentence);

        Sentence createdSentence = sentenceService.createSentence(sentence);

        assertNotNull(createdSentence);
        assertEquals("Test description", createdSentence.getDescription());
    }

    @Test
    void testGetSentenceById() {
        Sentence sentence = new Sentence();
        sentence.setId(1L);

        when(sentenceRepository.findById(1L)).thenReturn(Optional.of(sentence));

        Optional<Sentence> foundSentence = sentenceService.getSentenceById(1L);

        assertTrue(foundSentence.isPresent());
        assertEquals(1L, foundSentence.get().getId());
    }
}