package com.tqi.evolutionfullstack.livrariabackend.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {

    private Long id;
    private String name;
    private String cpf;
}
