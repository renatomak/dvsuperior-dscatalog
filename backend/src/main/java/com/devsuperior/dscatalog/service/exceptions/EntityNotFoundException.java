package com.devsuperior.dscatalog.service.exceptions;

public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 2062434147875331065L;

    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
