package com.jilit.clxacademics.exceptions;
//
public class CLXException extends Exception{

    private static final long serialVersionUID = 1L;
    private final String identifier;
    public CLXException() {
        super();
        identifier="";
    }

    public CLXException(final String arg0, String id) {
        super(arg0);
        identifier=id;
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String toString() {
		return "CLXException [identifier=" + identifier + "]";
	}
    
    

}
