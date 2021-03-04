package com.jilit.clxacademics.exceptions;

public class ConflictException extends CLXException {

    private static final long serialVersionUID = 5941252778534446770L;

    private final String identifier;

    public ConflictException(final String identifier, final String arg0) {
        super(arg0,identifier);
        this.identifier = identifier;
    }

    public final String getIdentifier() {
        return this.identifier;
    }
}
