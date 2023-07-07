package org.github.laziness.usecase;

import org.github.laziness.usecase.exceptions.ValidateException;
import org.github.laziness.usecase.validator.IPv4Validator;
import org.github.laziness.usecase.validator.UrlValidator;
import org.github.laziness.usecase.validator.ValidatorConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ValidatorConfig.class)
class ValidatorServiceTest {

    @Autowired
    private UrlValidator urlValidator;

    @Autowired
    private IPv4Validator iPv4Validator;

    private ValidatorService validatorService;

    @BeforeEach
    public void setup() {
        validatorService = new ValidatorService(iPv4Validator, urlValidator);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "255.255.255.255",
            "0.0.0.0",
            "https://naver.com",
            "http://naver.com",
            "http://www.naver.com",
            "https://google.co.kr",
            "http://google.co.kr",
            "http://www.google.co.kr"
    })
    void 네임스페이스를_입력받으면_IP주소_혹은_도메인을_검증할_수_있다(String namespace) {
        Assertions.assertDoesNotThrow(() -> validatorService.validate(namespace, ""));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "255.255.255.256",
            "0.0.0.256",
            "-1.0.0.256",
            "httpss://google.co.kr",
            "httpa://google.co.kr",
            "google.co.krabcdef",
            "google.co.kr.abc.def"
    })
    void 네임스페이스가_잘못된_경우_익셉션이_발생한다(String namespace) {
        ValidatorService validatorService = new ValidatorService(iPv4Validator, urlValidator);

        ValidateException exception = assertThrows(ValidateException.class,
                () -> validatorService.validate(namespace, ""));

        Assertions.assertTrue(exception.getMessage().contains("Invalid"));
    }

}
