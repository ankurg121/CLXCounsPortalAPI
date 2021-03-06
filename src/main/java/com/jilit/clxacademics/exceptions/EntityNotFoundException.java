package com.jilit.clxacademics.exceptions;

public class EntityNotFoundException extends CLXException {

    private static final long serialVersionUID = 1L;

    private final String identifier;

    public EntityNotFoundException(final String identifier, final String args) {
        super(args,identifier);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

}
