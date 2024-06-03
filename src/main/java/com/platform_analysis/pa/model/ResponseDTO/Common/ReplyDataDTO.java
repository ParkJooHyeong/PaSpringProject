package com.platform_analysis.pa.model.ResponseDTO.Common;

public class ReplyDataDTO<T> {
    private T data;

    public ReplyDataDTO(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
