package com.example.server;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AppController {
    private BoardRepository boardRepository;

    public AppController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/home")
    public String home() {
        return "home Action";
    }
    
    @GetMapping("/boards")
    public ResponseEntity<List<Board>> getBoards() {
        Board board = new Board("agent 제목", "agent 내용");
        boardRepository.save(board);

        List<Board> boards = boardRepository.findAll();

        return ResponseEntity.ok().body(boards);
    }
    
    
}
