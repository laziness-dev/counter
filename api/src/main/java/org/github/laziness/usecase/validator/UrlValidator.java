package org.github.laziness.usecase.validator;

import java.util.regex.Pattern;

public class UrlValidator {
    private static final String URL_PATTERN = "(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})";
    private static final Pattern pattern = Pattern.compile(URL_PATTERN, Pattern.CASE_INSENSITIVE);
    public boolean isValidURL(String url) {
        return pattern.matcher(url).matches();
    }
}

