package edu.waa.classified.validator;

import edu.waa.classified.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, String> {


    HibernateTemplate hibernateTemplate;
    @Autowired
    private UserService userService;

    @Override
    public void initialize(Unique arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
        if (userName == null) {
            return false;
        }

        return true;
        /*if (userService.findByUserName(userName).getUserName().equals(userName)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("User " + userName + "already exists!")
					.addConstraintViolation();
			return false;
		}*/

        //return true;
    }

    public SessionFactory getSessionFactory() {
        return hibernateTemplate != null ? hibernateTemplate.getSessionFactory() : null;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

}
