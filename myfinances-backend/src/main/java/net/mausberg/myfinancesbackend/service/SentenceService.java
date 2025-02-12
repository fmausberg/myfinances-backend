package net.mausberg.myfinancesbackend.service;

import net.mausberg.myfinancesbackend.model.Sentence;
import net.mausberg.myfinancesbackend.repository.SentenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SentenceService {

    private final SentenceRepository sentenceRepository;

    @Autowired
    public SentenceService(SentenceRepository sentenceRepository) {
        this.sentenceRepository = sentenceRepository;
    }

    // Create a new sentence
    public Sentence createSentence(Sentence sentence) {
        return sentenceRepository.save(sentence);
    }

    // Retrieve a sentence by ID
    public Optional<Sentence> getSentenceById(Long id) {
        return sentenceRepository.findById(id);
    }

    // Retrieve all sentences
    public List<Sentence> getAllSentences() {
        return sentenceRepository.findAll();
    }

    // Update an existing sentence
    public Sentence updateSentence(Long id, Sentence updatedSentence) {
        return sentenceRepository.findById(id)
                .map(sentence -> {
                    sentence.setDescription(updatedSentence.getDescription());
                    sentence.setTransactions(updatedSentence.getTransactions());
                    sentence.setTimestamp(updatedSentence.getTimestamp());
                    return sentenceRepository.save(sentence);
                })
                .orElseThrow(() -> new IllegalArgumentException("Sentence not found with id: " + id));
    }

    // Delete a sentence by ID
    public void deleteSentence(Long id) {
        sentenceRepository.deleteById(id);
    }
}