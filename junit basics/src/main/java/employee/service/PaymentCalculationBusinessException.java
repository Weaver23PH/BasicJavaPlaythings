package employee.service;

/** 
 * Exception thrown, when payment can not be calculated.
 * @author rbuchals
 *
 */
public class PaymentCalculationBusinessException extends RuntimeException {
    private static final long serialVersionUID = 7958876020372587434L;
    
    private final String reason;

    public PaymentCalculationBusinessException(String reason) {
        super();
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
