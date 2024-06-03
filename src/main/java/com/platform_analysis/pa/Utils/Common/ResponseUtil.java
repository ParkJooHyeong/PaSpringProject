package com.platform_analysis.pa.Utils.Common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform_analysis.pa.model.ResponseDTO.Common.ReplyDataDTO;
import com.platform_analysis.pa.model.ResponseDTO.Common.ResponseWrapper;
import com.platform_analysis.pa.model.ResponseDTO.Common.ResultDataDTO;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ResponseUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> ResponseWrapper<T> createResponseWrapper(T data, int status, String message) {
        ReplyDataDTO<T> replyData = new ReplyDataDTO<>(data);
        ResultDataDTO resultData = new ResultDataDTO(status, message);
        return new ResponseWrapper<>(replyData, resultData);
    }

    public static <T> void setReplyMessage(HttpServletResponse response, T data, int status, String message) throws IOException {
        ResponseWrapper<T> responseWrapper = createResponseWrapper(data, status, message);
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        objectMapper.writeValue(response.getWriter(), responseWrapper);
    }

    public static <T> void success(HttpServletResponse response, T data) throws IOException {
        setReplyMessage(response, data, 0, "Success");
    }

    public static <T> void error(HttpServletResponse response, String errorMessage) throws IOException {
        setReplyMessage(response, null, 1, errorMessage);
    }
}
