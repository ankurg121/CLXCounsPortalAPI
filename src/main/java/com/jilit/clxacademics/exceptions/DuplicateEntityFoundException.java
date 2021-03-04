package com.jilit.clxacademics.exceptions;

public class DuplicateEntityFoundException extends CLXException {

    private static final long serialVersionUID = 1L;

    private final String identifier;

    public DuplicateEntityFoundException( final String args,final String identifier) {
        super(args,identifier);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

}
