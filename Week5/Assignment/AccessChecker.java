// AccessChecker.java
public class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("private")) return "DENIED";
        if (fieldModifier.equals("default")) {
            if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) return "ALLOWED";
            return "DENIED";
        }
        if (fieldModifier.equals("protected")) {
            if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE") || accessorContext.equals("DIFFERENT_PACKAGE")) return "ALLOWED";
            return "DENIED";
        }
        if (fieldModifier.equals("public")) return "ALLOWED";
        return "UNKNOWN";
    }

    public static void summarizeByModifier(String[][] attempts) {
        int[] allowed = new int[4], denied = new int[4];
        String[] modifiers = {"private", "default", "protected", "public"};
        for (String[] attempt : attempts) {
            String mod = attempt[0];
            String ctx = attempt[1];
            int idx = -1;
            for (int i = 0; i < modifiers.length; i++) if (mod.equals(modifiers[i])) { idx = i; break; }
            if (idx >= 0) {
                if (classifyAccess(mod, ctx).equals("ALLOWED")) allowed[idx]++; else denied[idx]++;
            }
        }
        for (int i = 0; i < modifiers.length; i++) {
            System.out.println(modifiers[i] + ": Allowed=" + allowed[i] + " Denied=" + denied[i]);
        }
    }

    public static void main(String[] args) {
        String[][] batch = {
            {"private", "DIFFERENT_PACKAGE"},
            {"public", "SAME_CLASS"},
            {"default", "SAME_PACKAGE"},
            {"protected", "DIFFERENT_PACKAGE"}
        };
        summarizeByModifier(batch);
    }
}
