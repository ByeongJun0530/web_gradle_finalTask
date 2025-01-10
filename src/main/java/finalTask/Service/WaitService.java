package finalTask.Service;

import finalTask.model.Dao.WaitDao;
import finalTask.model.Dto.WaitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WaitService {
    @Autowired private WaitDao waitDao;

    // 명단 등록
    public boolean waitRegist(WaitDto waitDto){
        boolean result = waitDao.waitRegist(waitDto);
        return result;
    }

    // 명단 출력
    public ArrayList<WaitDto> waitPrint(){
        ArrayList<WaitDto> result = waitDao.waitPrint();
        return result;
    }

}
