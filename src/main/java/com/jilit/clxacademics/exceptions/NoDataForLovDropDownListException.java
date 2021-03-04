package com.jilit.clxacademics.exceptions;

public class NoDataForLovDropDownListException extends CLXException {
	private static final long serialVersionUID = 1L;

    private final String identifier;

    public NoDataForLovDropDownListException(final String identifier, final String args) {
        super(args,identifier);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }
}
