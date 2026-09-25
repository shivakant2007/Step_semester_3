// SubclassTicketAccess.java
public class SubclassTicketAccess extends MovieTicket {
    public SubclassTicketAccess(String m, String g, double tp, int s) {
        super(m, g, tp, s);
    }

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("protected")) {
            if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) return "ALLOWED";
            if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) return "DENIED";
        }
        if (fieldModifier.equals("private") || fieldModifier.equals("default")) return "DENIED";
        if (fieldModifier.equals("protected") && accessorContext.equals("SAME_CLASS")) return "ALLOWED";
        if (fieldModifier.equals("protected") && accessorContext.equals("SAME_PACKAGE")) return "ALLOWED";
        if (fieldModifier.equals("protected") && accessorContext.equals("DIFFERENT_PACKAGE")) return "ALLOWED";
        return "ALLOWED";
    }

    public static void main(String[] args) {
        System.out.println("Protected own type: " + classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println("Protected parent type: " + classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}
