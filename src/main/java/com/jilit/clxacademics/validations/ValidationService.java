package com.jilit.clxacademics.validations;

import com.jilit.clxacademics.exceptions.CLXException;

public interface ValidationService {

    void numericValidation(Object object, String validationKeyInString) throws CLXException;

}
