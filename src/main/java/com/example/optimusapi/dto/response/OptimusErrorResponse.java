package com.example.optimusapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OptimusErrorResponse {

    private int status;
    private String message;
    private String timeStamp;


}
