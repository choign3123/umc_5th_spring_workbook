package umc.spring.service.TempService;

import org.springframework.stereotype.Service;
import umc.spring.base.Code;
import umc.spring.base.exception.TempException;

@Service
public class TempQueryServiceImpl implements ITempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if(flag == 1){
            throw new TempException(Code.TEMP_EXCEPTION);
        }
    }
}
