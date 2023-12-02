package umc.spring.base.exception;

import umc.spring.base.Code;

public class MissionException extends GeneralException{

    public MissionException(Code errorCode){
        super(errorCode);
    }
}
