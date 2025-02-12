package net.mausberg.myfinancesbackend.controller;

import net.mausberg.myfinancesbackend.model.Sentence;
import net.mausberg.myfinancesbackend.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sentences")
public class SentenceController {

    private final SentenceService sentenceService;

    @Autowired
    public SentenceController(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }

    @PostMapping
    public ResponseEntity<Sentence> createSentence(@RequestBody Sentence sentence) {
        Sentence createdSentence = sentenceService.createSentence(sentence);
        return ResponseEntity.ok(createdSentence);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sentence> getSentenceById(@PathVariable Long id) {
        Optional<Sentence> sentence = sentenceService.getSentenceById(id);
        return sentence.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Sentence>> getAllSentences() {
        List<Sentence> sentences = sentenceService.getAllSentences();
        return ResponseEntity.ok(sentences);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sentence> updateSentence(@PathVariable Long id, @RequestBody Sentence updatedSentence) {
        try {
            Sentence sentence = sentenceService.updateSentence(id, updatedSentence);
            return ResponseEntity.ok(sentence);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSentence(@PathVariable Long id) {
        sentenceService.deleteSentence(id);
        return ResponseEntity.noContent().build();
    }
}