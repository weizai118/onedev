package io.onedev.server.util.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import io.onedev.server.search.commit.CommitQueryUtils;
import io.onedev.server.web.editable.annotation.CommitQuery;
import io.onedev.utils.StringUtils;

public class CommitQueryValidator implements ConstraintValidator<CommitQuery, String> {

	@Override
	public void initialize(CommitQuery constaintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintContext) {
		if (value == null) {
			return true;
		} else {
			try {
				CommitQueryUtils.parse(value);
				return true;
			} catch (Exception e) {
				constraintContext.disableDefaultConstraintViolation();
				String message;
				if (StringUtils.isNotBlank(e.getMessage()))
					message = e.getMessage();
				else
					message = "Malformed commit query";
				
				constraintContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
				return false;
			}
		}
	}

}
