package finalTask.controller;

import finalTask.Service.WaitService;
import finalTask.model.Dto.WaitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class WaitController {
    @Autowired private WaitService waitService;

    // 명단 등록
    @PostMapping("/waitRegist.do")
    public boolean waitRegist(@RequestBody WaitDto waitDto){
        boolean result = waitService.waitRegist(waitDto);
        return result;
    }

    // 명단 출력
    @GetMapping("/waitPrint.do")
    public ArrayList<WaitDto> waitPrint(){
        ArrayList<WaitDto> result = waitService.waitPrint();
        return  result;
    }
}
