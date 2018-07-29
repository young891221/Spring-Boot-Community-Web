package com.web.service;

import com.web.domain.Board;
import com.web.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by KimYJ on 2017-07-13.
 */
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }

    public Board findBoardByIdx(Long idx) {
        return boardRepository.getOne(idx);
    }

    public Board saveAndUpdateBoard(Board board) {
        return boardRepository.save(board);
    }
}
