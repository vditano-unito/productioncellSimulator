package elevatingrotarytable;

public class ElevatingRotaryTableException extends Throwable {
    public ElevatingRotaryTableException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "[ElevatingRotaryTableException] - " + getMessage();
    }
}
