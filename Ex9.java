import java.io.File;

public class Ex9 {
    public static void main(String[] args) {
        File f = new File("/home/felisberto/Documentos/FCUL");
        // File f = new File("/home/felisberto/Documentos/FCUL/FCUL - Algoritimo e
        // Estrutura de Dados");
        // File f = new File("/home/felisberto/Documentos/FCUL/FCUL - Algoritimo e
        // Estrutura de Dados/Series02Recursivo");
        System.out.println("\n \n ");
        findFiles(f, "Ex9.java");
    }

    public static void findFiles(File file, String filename) {
        if (file.isDirectory()) {
            for (int i = 0; i < file.listFiles().length; i++) {
                findFiles(file.listFiles()[i], filename);
            }
        } else {
            if (file.getName().equals(filename)) {
                System.out.println(file);
            }
        }
    }

    public static void FindFile(File[] files, int i) {

    }
}
