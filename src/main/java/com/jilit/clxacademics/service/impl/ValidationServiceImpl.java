package com.jilit.clxacademics.service.impl;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.exceptions.ValidationException;
import com.jilit.clxacademics.util.Identifier;
import com.jilit.clxacademics.validations.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {

    private static final Logger LOG = LoggerFactory.getLogger(ValidationServiceImpl.class);

    
    
    @Override
    public void numericValidation(final Object object, final String validationKeyInString) throws CLXException {
        if (object instanceof Integer) {
            final Integer integerValue = (Integer) object;
            if (integerValue <= 0) {
                throwNumericValidationError(validationKeyInString);
            }
        } else if (object instanceof Long) {
            final Long longValue = (Long) object;
            if (longValue <= 0) {
                throwNumericValidationError(validationKeyInString);
            }
        }

    }
 
    
    private void throwNumericValidationError(final String validationKeyInString) throws ValidationException {
        final String errorMsg = String.format(validationKeyInString).concat(" is invalid as it should be a positive non zero integer.");
        LOG.error(errorMsg);
        throw new ValidationException(Identifier.EMPLOYEEOBJECTSTORAGESERVICE, errorMsg);
    }

}
