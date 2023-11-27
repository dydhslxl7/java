package monthsago.travel16.controller;

import monthsago.travel16.Model.Board;
import monthsago.travel16.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BoardController {
    @Autowired
    private BoardService boardService;


    @GetMapping("/getPagingBoard")
    public ResponseEntity<Map> getAllBoards(@RequestParam(value = "p_num") Integer p_num,@RequestParam(value = "keyword", required = false) String keyword) {
        if (p_num == null || p_num <= 0) p_num = 1;
        System.out.println("keyword is"+keyword);
        return boardService.getPagingBoard(p_num,keyword);
    }

    //create board
    @PostMapping("/board")
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    //get board detail
    @GetMapping("/board/{num}")
    public Optional<Board> getBoardByNum(@PathVariable Integer num) {
        return boardService.getBoard(num);
    }

    // update board
    @PutMapping("/board/{no}")
    public void updateBoardByNo(
            @PathVariable Integer no, @RequestBody Board board) {
        boardService.updateBoard(no, board);
    }

    // delete board
    @DeleteMapping("/board/{no}")
    public void deleteBoardByNo(
            @PathVariable Integer no) {
        boardService.deleteBoard(no);
    }






}
