package com.platform_analysis.pa.model.ResponseDTO.Common;

public class ResponseWrapper<T> {
    private ReplyDataDTO<T> replyData;
    private ResultDataDTO resultData;

    public ResponseWrapper(ReplyDataDTO<T> replyData, ResultDataDTO resultData) {
        this.replyData = replyData;
        this.resultData = resultData;
    }

    public ReplyDataDTO<T> getReplyData() {
        return replyData;
    }

    public void setReplyData(ReplyDataDTO<T> replyData) {
        this.replyData = replyData;
    }

    public ResultDataDTO getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataDTO resultData) {
        this.resultData = resultData;
    }
}
