package VTI.demo;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class program {

	public static void main(String[] args) {
		
		Department department = new Department();
		
		department.setName("Test");
		department.setTotalMember((short) -1);
		
		ValidatorFactory validatorF = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorF.getValidator();
		
		Set<ConstraintViolation<Department>> vio = validator.validate(department);
		
		if(vio.size() > 0) {
			for(ConstraintViolation<Department> cons : vio) {
				System.out.println(cons.getMessage());
			}
		}

	}

}
