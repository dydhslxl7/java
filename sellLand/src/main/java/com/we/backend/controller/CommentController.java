package monthsago.travel16.controller;

import monthsago.travel16.Model.Comment;
import monthsago.travel16.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;

    //create comment
    @PostMapping("/board/comment")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    //get comment by board_no
   // @GetMapping("/board/comment/{num}")
   // public Optional<Comment> getCommentByNum(
   //         @PathVariable Integer num) {
   //     return commentService.getComment(num);
   // }

    // delete comment
    @DeleteMapping("/board/comment/{no}")
    public void deleteCommentByNo(
            @PathVariable Integer no) {
        commentService.deleteComment(no);
    }

    @GetMapping("/getCommentById/{no}")
    public List<Comment> getCommentByBoardNo(@PathVariable Integer no) {
        return commentService.findCommentByBoardNo(no);
    }


}