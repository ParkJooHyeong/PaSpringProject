package com.platform_analysis.pa.model.ResponseDTO.Common;

public class ResultDataDTO {
    private int status; // 0: 성공, 1: 실패
    private String message;

    public ResultDataDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
