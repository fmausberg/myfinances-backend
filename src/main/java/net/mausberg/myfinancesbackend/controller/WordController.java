package net.mausberg.myfinancesbackend.controller;

import net.mausberg.myfinancesbackend.model.Word;
import net.mausberg.myfinancesbackend.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping
    public ResponseEntity<Word> createWord(@RequestBody Word word) {
        Word createdWord = wordService.createWord(word);
        return ResponseEntity.ok(createdWord);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Word> getWordById(@PathVariable Long id) {
        Optional<Word> word = wordService.getWordById(id);
        return word.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Word>> getAllWords() {
        List<Word> words = wordService.getAllWords();
        return ResponseEntity.ok(words);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Word> updateWord(@PathVariable Long id, @RequestBody Word updatedWord) {
        try {
            Word word = wordService.updateWord(id, updatedWord);
            return ResponseEntity.ok(word);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWord(@PathVariable Long id) {
        wordService.deleteWord(id);
        return ResponseEntity.noContent().build();
    }
}