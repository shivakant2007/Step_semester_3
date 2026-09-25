public class FileExtensionValidator {

    String validateFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }
        String extension = filename.substring(lastDotIndex + 1);
        if (extension.equalsIgnoreCase("pdf") ||
            extension.equalsIgnoreCase("docx") ||
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        FileExtensionValidator validator = new FileExtensionValidator();

        System.out.println("Test 1: document.pdf");
        System.out.println(validator.validateFileExtension("document.pdf"));

        System.out.println("\nTest 2: report.DOCX");
        System.out.println(validator.validateFileExtension("report.DOCX"));

        System.out.println("\nTest 3: archive.Zip");
        System.out.println(validator.validateFileExtension("archive.Zip"));

        System.out.println("\nTest 4: image.jpg");
        System.out.println(validator.validateFileExtension("image.jpg"));

        System.out.println("\nTest 5: noextension");
        System.out.println(validator.validateFileExtension("noextension"));
    }
}
