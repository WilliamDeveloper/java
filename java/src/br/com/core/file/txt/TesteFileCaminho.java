package br.com.core.file.txt;

import java.io.File;
import java.io.IOException;

public class TesteFileCaminho {

    public static void main(String[] args) throws IOException {
        System.out.println("**" + System.getProperty("user.dir"));

        System.out.println(new File(".").getAbsolutePath());

        System.out.println(new File(".").getCanonicalPath());

        System.out.println(new File(".").getName());

        System.out.println(new File(".").getParent());

        System.out.println(new File(".").getPath());

        System.out.println(new File(".").getAbsoluteFile());

        System.out.println(new File(".").getCanonicalFile());

        System.out.println(new File(".").getParentFile());
    }
}
