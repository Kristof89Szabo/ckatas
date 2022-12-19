package com.grad.kata13;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CountingLines {

    public static void main(String[] args) {
        boolean multilineCommentBeginning = false;
        int rowCounter = 0;
        //String path = "src/main/resources/kata13_1.txt";
        String path = "src/main/resources/kata13_2.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isMultiLineCommentStart(multilineCommentBeginning, line)) {
                    multilineCommentBeginning = true;
                } else if (multilineCommentBeginning && isMultiLineCommentEnd(multilineCommentBeginning, line)) {
                    multilineCommentBeginning = false;
                } else if (!multilineCommentBeginning && !isBlank(line) && !isSingleComment(line)) {
                    rowCounter++;
                }
            }
            System.out.println(rowCounter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isMultiLineCommentEnd(boolean multilineCommentBeginning, String line) {
        return multilineCommentBeginning && line.contains("*/");
    }

    private static boolean isMultiLineCommentStart(boolean multilineCommentBeginning, String line) {
        return !multilineCommentBeginning && line.startsWith("/*");
    }

    private static boolean isSingleComment(String line) {
        return line.startsWith("//");
    }

    private static boolean isBlank(String line) {
        return line.isBlank();
    }

}
