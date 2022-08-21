package com.tqi.evolutionfullstack.livrariabackend.DTO;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class BookListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List bookId;
}
