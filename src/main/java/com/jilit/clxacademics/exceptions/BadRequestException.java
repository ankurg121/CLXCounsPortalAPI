package com.jilit.clxacademics.exceptions;

public class BadRequestException extends CLXException {

    private static final long serialVersionUID = 4092405031916078821L;

    private final String identifier;

    public BadRequestException(final String identifier, final String messages) {
        super(messages,identifier);
        this.identifier = identifier;
    }
 
    public final String getIdentifier() {
        return this.identifier;
    }

}
