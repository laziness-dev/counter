package org.github.laziness.usecase.validator;

import java.util.regex.Pattern;

public class IPv4Validator {
    private static final String IPV4_PATTERN =
            "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";
    private static final Pattern pattern = Pattern.compile(IPV4_PATTERN);

    public boolean isValidIPv4(String ipAddress) {
        return pattern.matcher(ipAddress).matches();
    }
}
