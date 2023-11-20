package umc.spring.base.exception;

import umc.spring.base.Code;

public class MemberException extends GeneralException{

    public MemberException(Code errorCode){
        super(errorCode);
    }
}
