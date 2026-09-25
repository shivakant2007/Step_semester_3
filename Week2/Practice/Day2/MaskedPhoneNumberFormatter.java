public class MaskedPhoneNumberFormatter {

    String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            return "Invalid input: phone number must contain exactly 10 digits";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append('X');
        }
        sb.append('-');
        for (int i = 6; i < 10; i++) {
            sb.append(phone.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MaskedPhoneNumberFormatter formatter = new MaskedPhoneNumberFormatter();

        System.out.println("Test 1: Valid 10-digit number");
        System.out.println(formatter.maskPhoneNumber("9876543210"));

        System.out.println("\nTest 2: Too short (7 digits)");
        System.out.println(formatter.maskPhoneNumber("1234567"));

        System.out.println("\nTest 3: Too long (11 digits)");
        System.out.println(formatter.maskPhoneNumber("12345678901"));

        System.out.println("\nTest 4: Non-digits");
        System.out.println(formatter.maskPhoneNumber("abcdefghij"));
    }
}
