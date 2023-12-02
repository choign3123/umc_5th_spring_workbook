package umc.spring.base.exception;

import umc.spring.base.Code;

public class FoodCategoryException extends GeneralException{

    public FoodCategoryException(Code errorCode) {
        super(errorCode);
    }
}
