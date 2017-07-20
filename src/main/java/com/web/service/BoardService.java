package com.web.service;

import com.web.domain.Board;
import com.web.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by KimYJ on 2017-07-13.
 */
@Service //서비스로 사용될 컴포넌트 정의
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Page<Board> findBoardList(Pageable pageable) {
        pageable = new PageRequest(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize()); //페이지 파라미터가 0 이하로 들어왔을때 처리 로직 / 디폴트 페이지 사이즈 사용
        return boardRepository.findAll(pageable); //정의한 pageable을 사용하여 페이징 처리된 게시글 리스트 반환
    }

    public Board findBoardByIdx(Long idx) {
        return boardRepository.findOne(idx); //idx값을 사용하여 board 객체 반환
    }

    public Board saveAndUpdateBoard(Board board) {
        return boardRepository.save(board);
    }
}
