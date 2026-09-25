public class BankTransactionReferenceValidator {

    String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() >= 3) {
            trimmed = trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
        }
        return trimmed;
    }

    String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: Reference must be exactly 14 characters (found " + reference.length() + ")";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: Characters 1-3 must be letters (found '" + reference.charAt(i) + "')";
            }
        }
        for (int i = 3; i < 9; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: Characters 4-9 must be digits (found '" + reference.charAt(i) + "')";
            }
        }
        for (int i = 9; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: Characters 10-14 must be digits (found '" + reference.charAt(i) + "')";
            }
        }
        String bankCode = reference.substring(0, 3).toUpperCase();
        String datePart = reference.substring(3, 9);
        String dateFormatted = datePart.substring(0, 2) + "/" + datePart.substring(2, 4) + "/" + datePart.substring(4, 6);
        String sequence = reference.substring(9, 14);
        return "[" + bankCode + "] DATE: " + dateFormatted + " | SEQ: " + sequence;
    }

    public static void main(String[] args) {
        BankTransactionReferenceValidator validator = new BankTransactionReferenceValidator();

        System.out.println("Test 1: Valid reference 'hdf03022600042'");
        System.out.println(validator.validateAndFormat("hdf03022600042"));

        System.out.println("\nTest 2: normalizeReference on 'hdf03022600042'");
        System.out.println(validator.normalizeReference("hdf03022600042"));

        System.out.println("\nTest 3: Too short (12 chars)");
        System.out.println(validator.validateAndFormat("abc123456789"));

        System.out.println("\nTest 4: Non-letter in first 3 positions");
        System.out.println(validator.validateAndFormat("1bc03022600042"));

        System.out.println("\nTest 5: Non-digit in date portion");
        System.out.println(validator.validateAndFormat("hdf0x022600042"));

        System.out.println("\nTest 6: Non-digit in sequence portion");
        System.out.println(validator.validateAndFormat("hdf030226000xx"));
    }
}
