package com.example.demo.api.v1.board.controller;

import com.example.demo.api.v1.board.dto.BoardDto;
import com.example.demo.api.v1.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/boards")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/{boardId}")
    public BoardDto.Response getBoardDetail(@Valid BoardDto.Request params) {
        return boardService.getBoard(params);
    }

    @GetMapping()
    public List<BoardDto.Response> getBoardList(@Valid @RequestBody BoardDto.ListRequest params) {
        return boardService.getBoardList(params);
    }

    @PostMapping()
    public void registerBoard(@Valid @RequestBody BoardDto.RegisterRequest params) {
        boardService.registerBoard(params);
    }

    @PutMapping("/{boardId}")
    public void modifyBoard(@PathVariable Long boardId, @Valid @RequestBody BoardDto.ModifyRequest body) {
        BoardDto.ModifyRequest params = BoardDto.ModifyRequest.builder()
                .boardId(boardId)
                .title(body.getTitle())
                .content(body.getContent())
                .platformCd(body.getPlatformCd())
                .build();

        boardService.modifyBoard(params);
    }
}
