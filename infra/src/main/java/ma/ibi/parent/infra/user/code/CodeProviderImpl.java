package ma.ibi.parent.infra.user.code;

import ma.ibi.parent.domain.user.UserAggregate;
import ma.ibi.parent.domain.user.code.CodeAggregate;
import ma.ibi.parent.domain.user.code.CodeProvider;
import ma.ibi.parent.domain.user.code.CodeStatus;
import ma.ibi.parent.infra.user.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CodeProviderImpl implements CodeProvider {

    @Autowired
    CodeRepository codeRepository;

    @Autowired
    Adapter adapter;


    @Override
    public List<CodeAggregate> getAll() {
        return codeRepository.findAll()
                .stream()
                .map(codeEntity -> new CodeAggregate(codeEntity.getId() ,
                        adapter.adaptUserEntityToUserAggregate(codeEntity.getUser()) ,codeEntity.getValue(),
                        codeEntity.getCreationDate(),codeEntity.getExpirationDate(),codeEntity.getStatus()))
                .collect(Collectors.toList());

    }

    @Override
    public void saveCode(CodeAggregate aggregateCode) {
        codeRepository.save(adapter.adaptCodeAggregateToCodeEntity(aggregateCode));
    }

    @Override
    public List<CodeAggregate> findByUserAndStatus(UserAggregate userAggregate, CodeStatus notVerified) {
        return codeRepository.findByUserAndStatus(adapter.adaptUserAggregateToUserEntity(userAggregate),notVerified)
                .stream()
                .map(codeEntity -> new CodeAggregate(codeEntity.getId() ,
                        adapter.adaptUserEntityToUserAggregate(codeEntity.getUser()) ,codeEntity.getValue(),
                        codeEntity.getCreationDate(),codeEntity.getExpirationDate(),codeEntity.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public void saveAll(List<CodeAggregate> expiredCodes)
    {

        codeRepository.saveAll(expiredCodes
                .stream()
                .map(codeAggregate -> new CodeEntity(
                        codeAggregate.getId() ,
                        adapter.adaptUserAggregateToUserEntity(codeAggregate.getUser()),
                        codeAggregate.getValue(),
                        codeAggregate.getCreationDate(),
                        codeAggregate.getExpirationDate(),
                        codeAggregate.getCodeStatus())).collect(Collectors.toList()));

    }

    @Override
    public Optional<CodeAggregate> findByUserAndValueAndStatus(UserAggregate userAggregate, Integer codeValue, CodeStatus notVerified) {
         Optional<CodeEntity> codeEntity=  codeRepository.findByUserAndValueAndStatus(adapter.adaptUserAggregateToUserEntity(userAggregate), codeValue, notVerified);

        if (codeEntity.isPresent())
            return Optional.ofNullable(adapter.adaptCodeEntityToCodeAggregate(codeEntity.get()));
        return Optional.empty();
    }


}
