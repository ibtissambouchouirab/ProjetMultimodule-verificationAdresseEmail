package ma.ibi.parent.prez.traitementValidator;


import ma.ibi.parent.domain.user.UserAggregate;
import com.bibliotheque.validator.Validator;

public class TraitementValidator {

    public boolean isUserCorrect(UserAggregate userAggregate){
        return Validator.isEmailValid(userAggregate.getEmail()) &&
                Validator.isNameValid(userAggregate.getName()) &&
                Validator.isPasswordValid(userAggregate.getPassword());

    }


}
