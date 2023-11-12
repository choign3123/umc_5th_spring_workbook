package umc.spring.base.exception;

import umc.spring.base.Code;
import umc.spring.base.exception.GeneralException;

public class TempException extends GeneralException {

    public TempException(Code errorCode){
        super(errorCode);
    }
}
