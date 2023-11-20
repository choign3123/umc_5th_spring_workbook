package umc.spring.base.exception;

import umc.spring.base.Code;

public class ReviewException extends GeneralException{

    public ReviewException(Code errorCode){
        super(errorCode);
    }
}
