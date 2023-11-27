package monthsago.travel16.controller;

import monthsago.travel16.Model.Comments;
import monthsago.travel16.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    //create comments
    @PostMapping("/qna/comments")
    public Comments createComments(@RequestBody Comments comments) {
        return commentsService.createComments(comments);
    }

    // delete comment
    @DeleteMapping("/qna/comments/{no}")
    public void deleteCommentsByNo(
            @PathVariable Integer no) {
        commentsService.deleteComments(no);
    }

    @GetMapping("/getCommentsById/{no}")
    public List<Comments> getCommentsByQnaNo(@PathVariable Integer no) {
        return commentsService.findCommentsByQnaNo(no);
    }


}