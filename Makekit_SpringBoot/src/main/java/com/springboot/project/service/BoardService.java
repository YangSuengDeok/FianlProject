package com.springboot.project.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.project.exception.ResourceNotFoundException;
import com.springboot.project.model.Board;
import com.springboot.project.repository.BoardRepository;

@Service
public class BoardService {

   @Autowired
   private BoardRepository boardRepository;
   
   // get boards data
   public List<Board> getAllBoard() {
      return boardRepository.findAll();
   }

   // create board
   public Board createBoard(Board board) {
      board.setRegdate(new Date());
      return boardRepository.save(board);
   }

   // get board one by id
   public ResponseEntity<Board> getBoard(Integer bno) {
      Board board = boardRepository.findById(bno)
            .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : [" + bno + "]"));
      return ResponseEntity.ok(board);
   }

   // update board
   public ResponseEntity<Board> updateBoard(Integer bno, Board updatedBoard) {
      Board board = boardRepository.findById(bno)
            .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by bno : [" + bno + "]"));
      board.setTitle(updatedBoard.getTitle());
      board.setContent(updatedBoard.getContent());
      board.setUpdatedate(new Date());

      Board endUpdatedBoard = boardRepository.save(board);
      return ResponseEntity.ok(endUpdatedBoard);
   }
   // delete board
      public ResponseEntity<Map<String, Boolean>> deleteBoard(
            Integer bno) {
         Board board = boardRepository.findById(bno)
               .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by bno : ["+bno+"]"));
         
         boardRepository.delete(board);
         Map<String, Boolean> response = new HashMap<>();
         response.put("Deleted Board Data by id : ["+bno+"]", Boolean.TRUE);
         return ResponseEntity.ok(response);
      }

}