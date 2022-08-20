package com.tqi.evolutionfullstack.livrariabackend.DTO;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class BookListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long bookId;
}
