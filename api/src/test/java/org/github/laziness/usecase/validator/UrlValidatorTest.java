package org.github.laziness.usecase.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UrlValidatorTest {
    private UrlValidator urlValidator = new UrlValidator();

    @ParameterizedTest
    @ValueSource(strings = {
            "https://-1.naver.com",
            "https://-google.co.kr",
            "google.co.krabcdef",
            "google.co.kr.abc.def",
            "-1.naver.com"
    })
    void 올바르지_않은_IPv4_주소가_들어올_경우_FALSE를_반환한다(String url) {
        Assertions.assertFalse(urlValidator.isValidURL(url));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "https://naver.com",
            "http://naver.com",
            "http://www.naver.com",
            "https://google.co.kr",
            "http://google.co.kr",
            "http://www.google.co.kr"
    })
    void 올바른_URL_주소가_들어올_경우_TRUE를_반환한다(String url) {
        Assertions.assertTrue(urlValidator.isValidURL(url));
    }
}
