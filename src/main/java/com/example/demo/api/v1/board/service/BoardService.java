package com.example.demo.api.v1.board.service;

import com.example.demo.api.v1.board.dto.BoardDto;
import com.example.demo.api.v1.board.entity.Board;
import com.example.demo.api.v1.board.mapper.BoardMapper;
import com.example.demo.common.exception.BizException;
import com.example.demo.constant.error.ErrorCodeImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public BoardDto.Response getBoard(BoardDto.Request params) {
        Board board = boardMapper.selectBoardById(params.toEntity());

        if (board == null) {
            throw new BizException(ErrorCodeImpl.NOT_FOUND);
        }

        return new BoardDto.Response(board);
    }

    public List<BoardDto.Response> getBoardList(BoardDto.ListRequest params) {
        List<Board> boardList = boardMapper.selectBoardList(params.toEntity());

        return boardList.stream()
                .map(BoardDto.Response::new)
                .collect(Collectors.toList());
    }

    public void registerBoard(BoardDto.RegisterRequest params) {
        Integer result = boardMapper.insertBoard(params.toEntity());

        if (result < 1) {
            throw new BizException(ErrorCodeImpl.FAILED_REGISTER);
        }

        return;
    }

    public void modifyBoard(BoardDto.ModifyRequest params) {
        Integer result = boardMapper.updateBoard(params.toEntity());

        if (result < 1) {
            throw new BizException(ErrorCodeImpl.FAILED_MODIFY);
        }

        return;
    }
}
