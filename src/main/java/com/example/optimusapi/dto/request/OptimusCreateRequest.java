package com.example.optimusapi.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptimusCreateRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String title;

}
