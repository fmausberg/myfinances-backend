package net.mausberg.myfinancesbackend.service;

import net.mausberg.myfinancesbackend.model.Word;
import net.mausberg.myfinancesbackend.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordService {

    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    // Create a new word
    public Word createWord(Word word) {
        return wordRepository.save(word);
    }

    // Retrieve a word by ID
    public Optional<Word> getWordById(Long id) {
        return wordRepository.findById(id);
    }

    // Retrieve all words
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    // Update an existing word
    public Word updateWord(Long id, Word updatedWord) {
        return wordRepository.findById(id)
                .map(word -> {
                    word.setAccount(updatedWord.getAccount());
                    word.setTransaction(updatedWord.getTransaction());
                    word.setValue(updatedWord.getValue());
                    word.setPerson(updatedWord.getPerson());
                    word.setCompany(updatedWord.getCompany());
                    return wordRepository.save(word);
                })
                .orElseThrow(() -> new IllegalArgumentException("Word not found with id: " + id));
    }

    // Delete a word by ID
    public void deleteWord(Long id) {
        wordRepository.deleteById(id);
    }
}