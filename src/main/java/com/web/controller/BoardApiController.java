package com.web.controller;

import com.web.domain.Board;
import com.web.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KimYJ on 2017-07-18.
 */
@RestController
@RequestMapping("/api/board")
public class BoardApiController {

    @Autowired
    BoardService boardService;

    @PostMapping
    public void save(@RequestBody Board board) {
        boardService.saveAndUpdateBoard(board);
    }

    @PutMapping
    public void update() {

    }

    @DeleteMapping
    public void delete() {

    }

}
