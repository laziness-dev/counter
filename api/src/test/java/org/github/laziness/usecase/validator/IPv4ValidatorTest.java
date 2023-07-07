package org.github.laziness.usecase.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IPv4ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "-1.-1.-1.-1",
            "-1.0.0.0",
            "255.255.255.256",
            "256.256.256.256"
    })
    void 올바르지_않은_IPv4_주소가_들어올_경우_FALSE를_반환한다(String ipAddress) {
        IPv4Validator iPv4Validator = new IPv4Validator();
        Assertions.assertFalse(iPv4Validator.isValidIPv4(ipAddress));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0.0.0.0",
            "1.0.0.0",
            "255.255.255.255",
            "192.168.0.1"
    })
    void 올바른_IPv4_주소가_들어올_경우_TRUE를_반환한다(String ipAddress) {
        IPv4Validator iPv4Validator = new IPv4Validator();
        Assertions.assertTrue(iPv4Validator.isValidIPv4(ipAddress));
    }
}
