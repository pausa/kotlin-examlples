package k07_checked_exceptions;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionsJava {
    @Value
    static class CodedError extends Exception {
        int code;
        String message;
    }

    @Value
    static class OtherError extends Exception {
        String other;
    }

    String danger() throws CodedError, OtherError {
        // TODO some code that might explode
        return null;
    }

    void example() {
        try {
            log.info(danger());
        } catch (CodedError e) {
            log.error("{} - {}", e.getCode(), e.getMessage());
        } catch (OtherError e) {
            log.error(e.getOther());
        }
    }


}
