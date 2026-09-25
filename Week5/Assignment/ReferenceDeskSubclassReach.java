// ReferenceDeskSubclassReach.java
public class ReferenceDeskSubclassReach {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("private") || fieldModifier.equals("default")) return "DENIED";
        if (fieldModifier.equals("protected")) {
            if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) return "ALLOWED";
            if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) return "DENIED";
        }
        return "ALLOWED";
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        for (String[] attempt : attempts) {
            if (classifyAccess(attempt[0], attempt[1]).equals("DENIED")) {
                return attempt[0] + " access from " + attempt[1] + " is DENIED";
            }
        }
        return "None Denied";
    }

    public static void main(String[] args) {
        String[][] attempts = {
            {"public", "SAME_CLASS"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"private", "DIFFERENT_PACKAGE"}
        };
        System.out.println(firstDeniedAttempt(attempts));
    }
}
