package org.skypro.skyshop.exception;

public class BestResultNotFound extends Exception {
    public BestResultNotFound() {
        super("По данному поисковому запросу результатов не найдено");
    }

    public BestResultNotFound(String message) {
        super(message);
    }

    public BestResultNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public BestResultNotFound(Throwable cause) {
        super(cause);
    }

    protected BestResultNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
