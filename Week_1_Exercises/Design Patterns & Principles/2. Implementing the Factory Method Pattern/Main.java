// DocumentFactoryTest.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter document type (word/pdf/excel): ");
        String documentType = scanner.nextLine().trim().toLowerCase();

        DocumentFactory factory = null;

        switch (documentType) {
            case "word":
                factory = new WordDocumentFactory();
                break;
            case "pdf":
                factory = new PdfDocumentFactory();
                break;
            case "excel":
                factory = new ExcelDocumentFactory();
                break;
            default:
                System.out.println("Invalid document type.");
                System.exit(1);
        }

        Document document = factory.createDocument();
        document.open();
        document.save();
        document.close();
    }
}
