package finalTask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    // 메인 페이지
    @GetMapping("")
    public String index(){
        return "/finalTask/index.html";
    }

    // 명단 등록 페이지
    @GetMapping("/waitRegist")
    public String waitRegist(){
        return "/finalTask/waitRegist.html";
    }

    // 명단 출력 페이지
    @GetMapping("/waitPrint")
    public String waitPrint(){
        return "/finalTask/waitPrint.html";
    }
}
