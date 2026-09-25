public class LibraryIsbnNormalizer {
    String normalizeCode(String raw) {
        String trimmed = raw.trim();
        String firstThree = trimmed.substring(0, Math.min(3, trimmed.length())).toUpperCase();
        String rest = trimmed.substring(Math.min(3, trimmed.length()));
        return firstThree + rest;
    }

    String validateAndFormat(String code) {
        String trimmed = code.trim();
        String normalized = normalizeCode(trimmed);
        if (normalized.length() != 13) {
            return "Invalid";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid";
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[PEN] YEAR: 2026 | CATALOG: ");
        sb.append(normalized.substring(7));
        return sb.toString();
    }

    public static void main(String[] args) {
        LibraryIsbnNormalizer normalizer = new LibraryIsbnNormalizer();
        System.out.println(normalizer.validateAndFormat("abc1234004251"));
        System.out.println(normalizer.validateAndFormat("ab1234567890"));
    }
}
