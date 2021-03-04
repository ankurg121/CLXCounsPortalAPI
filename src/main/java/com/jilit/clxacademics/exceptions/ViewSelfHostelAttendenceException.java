package com.jilit.clxacademics.exceptions;

public class ViewSelfHostelAttendenceException extends CLXException{
	 private final String identifier;

	    public ViewSelfHostelAttendenceException(final String identifier, final String message) {
	        super(message,identifier);
	        this.identifier = identifier;
	    }

	    public final String getIdentifier() {
	        return this.identifier;
	    }
}
