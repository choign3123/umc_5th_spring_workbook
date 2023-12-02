package umc.spring.base.exception;

import umc.spring.base.Code;

public class StoreException extends GeneralException{

    public StoreException(Code errorCode){
        super(errorCode);
    }
}
