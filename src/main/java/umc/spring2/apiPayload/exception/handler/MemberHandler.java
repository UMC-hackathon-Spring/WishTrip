package umc.spring2.apiPayload.exception.handler;

import umc.spring2.apiPayload.code.BaseErrorCode;
import umc.spring2.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
