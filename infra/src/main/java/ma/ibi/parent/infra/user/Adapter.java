package ma.ibi.parent.infra.user;

import ma.ibi.parent.domain.user.UserAggregate;
import ma.ibi.parent.domain.user.code.CodeAggregate;
import ma.ibi.parent.infra.user.code.CodeEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class Adapter {

    public UserEntity adaptUserAggregateToUserEntity(UserAggregate userAggregate){
        return new UserEntity(userAggregate.getId() , userAggregate.getName(), userAggregate.getLastName(),
                userAggregate.getPseudoName() , userAggregate.getEmail(),userAggregate.getPassword(),
                userAggregate.isEmailVerified());
    }

    public UserAggregate adaptUserEntityToUserAggregate(UserEntity user){
        return new UserAggregate(user.getId() , user.getName(), user.getLastName(),
                user.getPseudoName() , user.getEmail(),user.getPassword(),
                user.getIsEmailVerified());
    }

    public List<UserAggregate> adaptUserEntitiesToUserAggregates(List<UserEntity> userEntities){
        return userEntities.stream().map(this::adaptUserEntityToUserAggregate).collect(Collectors.toList());
    }

    public CodeEntity adaptCodeAggregateToCodeEntity(CodeAggregate codeAggregate){
        return new CodeEntity(codeAggregate.getId() ,
                adaptUserAggregateToUserEntity(codeAggregate.getUser()),
                codeAggregate.getValue(),
                codeAggregate.getCreationDate() ,
                codeAggregate.getExpirationDate(),
                codeAggregate.getCodeStatus());
    }

    public List<CodeEntity> adaptCodeAggregatesToCodeEntity(List<CodeAggregate> codeAggregates){
        return codeAggregates.stream().map(this::adaptCodeAggregateToCodeEntity).collect(Collectors.toList());
    }

    public CodeAggregate adaptCodeEntityToCodeAggregate(CodeEntity codeEntity){
        return new CodeAggregate(codeEntity.getId() ,
                adaptUserEntityToUserAggregate(codeEntity.getUser()),
                codeEntity.getValue(),
                codeEntity.getCreationDate() ,
                codeEntity.getExpirationDate(),
                codeEntity.getStatus());
    }

}
