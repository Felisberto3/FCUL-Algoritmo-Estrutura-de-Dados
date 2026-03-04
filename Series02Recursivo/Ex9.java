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

        if (file == null || !file.exists()) {
            return;
        }

        if (file.isDirectory()) {
            findFiles(file.listFiles(), filename, 0);
        } else if (file.getName().equals(filename)) {
            System.out.println(file);
        }
    }

    public static void findFiles(File[] files, String filename, int index) {

        if (files == null || index >= files.length) {
            return;
        }

        findFiles(files[index], filename);
        findFiles(files, filename, index + 1);
    }
}
