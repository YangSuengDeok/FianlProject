package com.springboot.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.model.Board;
import com.springboot.project.service.BoardService;

@CrossOrigin(origins = "http://192.168.0.126:3000")
@RestController
@RequestMapping("/api")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// get all board
	@GetMapping("/board")
	public List<Board> getAllBoards() {
		return boardService.getAllBoard();
	}

	// create board
	@PostMapping("/board")
	public Board createBoard(@RequestBody Board board) {
		return boardService.createBoard(board);
	}

	// get board
	@GetMapping("/board/{bno}")
	public ResponseEntity<Board> getBoardByBno(@PathVariable Integer bno) {

		return boardService.getBoard(bno);
	}

	// update board
	@PutMapping("/board/{bno}")
	public ResponseEntity<Board> updateBoardByBno(@PathVariable Integer bno, @RequestBody Board board) {

		return boardService.updateBoard(bno, board);
	}

	// delete board
	@DeleteMapping("/board/{bno}")
	public ResponseEntity<Map<String, Boolean>> deleteBoardByBno(@PathVariable Integer bno) {

		return boardService.deleteBoard(bno);
	}

}
