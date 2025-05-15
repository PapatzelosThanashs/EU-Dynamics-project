package com.project.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;

    @Pattern(regexp = "^$|^[a-zA-Z0-9-]+$", message = "Name must not be empty, letters, numbers, and dashes are allowed ")
    private String workAddress;

    @Pattern(regexp = "^$|^[a-zA-Z0-9-]+$", message = "Name must not be empty, letters, numbers, and dashes are allowed ")
    private String homeAddress;


}
