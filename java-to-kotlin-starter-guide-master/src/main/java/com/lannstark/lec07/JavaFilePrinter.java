package com.lannstark.lec07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JavaFilePrinter {

  public void readFileA() throws IOException { //checked 예외
    final File currentFile = new File(".");
    final File file = new File(currentFile.getAbsolutePath() + "/a.txt");
    final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    System.out.println(bufferedReader.readLine());
    bufferedReader.close();
  }

  // try with resources
  public void readFile(String path) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      System.out.println(reader.readLine());
    }
  }

}
