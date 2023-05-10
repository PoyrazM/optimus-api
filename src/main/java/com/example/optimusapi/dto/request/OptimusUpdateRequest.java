package com.example.optimusapi.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptimusUpdateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String title;
}
