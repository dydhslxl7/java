package monthsago.travel16.controller;

import monthsago.travel16.Model.Qna;
import monthsago.travel16.Service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class QnaController {
    @Autowired
    private QnaService qnaService;


    @GetMapping("/getPagingQna")
    public ResponseEntity<Map> getAllQnas(@RequestParam(value = "p_num") Integer p_num, @RequestParam(value = "keyword", required = false) String keyword) {
        if (p_num == null || p_num <= 0) p_num = 1;
        System.out.println("keyword is"+keyword);
        return qnaService.getPagingQna(p_num,keyword);

    }

    //create qna
    @PostMapping("/qna")
    public Qna createQna(@RequestBody Qna qna) {
        return qnaService.createQna(qna);
    }

    //get qna detail//성환 일해라
    @GetMapping("/qna/{num}")
    public Optional<Qna> getQnaByNum(@PathVariable Integer num) {
        return qnaService.getQna(num);
    }

    // update qna
    @PutMapping("/qna/{no}")
    public void updateQnaByNo(
            @PathVariable Integer no, @RequestBody Qna qna) {
        qnaService.updateQna(no, qna);
    }

    // delete qna
    @DeleteMapping("/qna/{no}")
    public void deleteQnaByNo(
            @PathVariable Integer no) {
        qnaService.deleteQna(no);
    }






}
