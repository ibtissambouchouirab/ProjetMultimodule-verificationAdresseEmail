package ma.ibi.parent.user.code;

import ma.ibi.parent.domain.user.code.CodeAggregate;
import ma.ibi.parent.domain.user.code.CodeProvider;
import ma.ibi.parent.domain.user.code.CodeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class CodeServiceTest {

    @Mock
    private CodeProvider codeProvider;

    @InjectMocks
    private CodeService codeService ;

    @Test
    public void Should_return_GenerateCode(){

        //CodeAggregate codeAggregate =new CodeAggregate();
        //given(codeService.generateCode(codeAggregate.getUser().getEmail())).willReturn(true);
       // Mockito.verify(codeProvider,Mockito.times(1)).saveCode(Mockito.any(CodeAggregate.class));


    }
}
