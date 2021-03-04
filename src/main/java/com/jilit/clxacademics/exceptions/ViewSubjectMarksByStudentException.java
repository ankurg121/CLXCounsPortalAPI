package com.jilit.clxacademics.exceptions;

public class ViewSubjectMarksByStudentException extends CLXException{
	 private final String identifier;

	    public ViewSubjectMarksByStudentException(final String identifier, final String message) {
	        super(message,identifier);
	        this.identifier = identifier;
	    }

	    public final String getIdentifier() {
	        return this.identifier;
	    }
}
