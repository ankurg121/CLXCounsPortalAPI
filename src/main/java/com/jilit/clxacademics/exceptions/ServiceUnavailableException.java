package com.jilit.clxacademics.exceptions;

public class ServiceUnavailableException extends CLXException {

    private static final long serialVersionUID = 1L;

    private final String identifier;

    public ServiceUnavailableException(final String identifier, final String message) {
        super(message,identifier);
        this.identifier = identifier;
    }

    public final String getIdentifier() {
        return this.identifier;
    }
}
