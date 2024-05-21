//---------------------------------------------MY Specail Code ----------------------------------

package com.card.card.write;

import java.io.File;

public class Write {
    public static String runOCR(String imagePath) {
//        String inputFilePath = imagePath;
//        String inputFilePath = "/app/com/card/card/write/r (3).jpg";
//        String inputFilePath = "/app/com/card/card/write/l.jpg";
        String inputFilePath = "/app/com/card/card/write/"+imagePath;
        String outputFilePath = "src/main/java/com/card/card/write/txt.txt";
        // Update the Tesseract OCR path to the one inside the Docker container
//        String tesseractInstallPath = "/usr/share/tesseract-ocr/tesseract.exe";
        String tesseractInstallPath = "/usr/bin/tesseract";
//        String tesseractInstallPath = "Tesseract-OCR/tesseract.exe";

        String[] command = {tesseractInstallPath, inputFilePath, outputFilePath, "-l", "ara+eng"};

        String recognizedText = null;
        try {
            Process p = Runtime.getRuntime().exec(command);
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();

            int exitCode = p.waitFor();
            if (exitCode == 0) {
                recognizedText = Read_File.read_a_file(outputFilePath + ".txt");
                System.out.println("OCR Output: " + recognizedText);

                // Delete the output file
                File fileToDelete = new File(outputFilePath + ".txt");
                if (fileToDelete.exists()) {
                    fileToDelete.delete();
                } else {
                    System.err.println("Output file not found.");
                }
            } else {
                System.err.println("OCR process exited with error code: " + exitCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recognizedText;
    }
}



//-----------------------------------------------------------------------------------------
//
//package com.card.card.write;
//
//import java.io.File;
//
//public class Write {
//    public static String runOCR() {
//        String imagePath = System.getenv("IMAGE_PATH");
//        System.out.println("Image Path: " + imagePath);
//
//        if (imagePath == null || imagePath.isEmpty()) {
//            System.err.println("Please provide a valid image path.");
//            return null;
//        }
//
//        // Convert Windows-style path to Unix-style path
//        imagePath = imagePath.replace("\\", "/");
//
//        // Get the file name from the path
//        String fileName = new File(imagePath).getName();
//
//        // Construct the input file path based on the provided image path
//        String inputFilePath = "/usr/src/app/com/card/card/write/" + fileName;
//        System.out.println("Input File Path: " + inputFilePath);
//
//        String outputFilePath = "src/main/java/com/card/card/write/txt.txt";
//        String tesseractInstallPath = "/usr/bin/tesseract";
//
////        String[] command = {tesseractInstallPath, inputFilePath, outputFilePath, "-l", "ara+eng"};
//        String[] command = {tesseractInstallPath, "\"" + inputFilePath + "\"", outputFilePath, "-l", "ara+eng"};
//
//        String recognizedText = null;
//        try {
//            Process p = Runtime.getRuntime().exec(command);
//            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
//            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
//
//            int exitCode = p.waitFor();
//            if (exitCode == 0) {
//                recognizedText = Read_File.read_a_file(outputFilePath);
//                System.out.println("OCR Output: " + recognizedText);
//
//                // Delete the output file
//                File fileToDelete = new File(outputFilePath);
//                if (fileToDelete.exists()) {
//                    fileToDelete.delete();
//                } else {
//                    System.err.println("Output file not found.");
//                }
//            } else {
//                System.err.println("OCR process exited with error code: " + exitCode);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return recognizedText;
//    }
//}


//package com.card.card.write;
//
//import java.io.File;
//
//public class Write {
//    public static String runOCR(String imagePath) {
//        System.out.println("Image Path: " + imagePath);
//
//        if (imagePath == null || imagePath.isEmpty()) {
//            System.err.println("Please provide a valid image path.");
//            return null;
//        }
//
//        // Convert Windows-style path to Unix-style path
//        imagePath = imagePath.replace("\\", "/");
//
//        // Get the file name from the path
//        String fileName = new File(imagePath).getName();
//
//        // Construct the input file path based on the provided image path
//        String inputFilePath = "/usr/src/app/com/card/card/write/" + fileName;
//        System.out.println("Input File Path: " + inputFilePath);
//
//        String outputFilePath = "src/main/java/com/card/card/write/txt.txt";
//        String tesseractInstallPath = "/usr/bin/tesseract";
//
//        String[] command = {tesseractInstallPath, inputFilePath, outputFilePath, "-l", "ara+eng"};
//
//        String recognizedText = null;
//        try {
//            Process p = Runtime.getRuntime().exec(command);
//            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
//            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
//
//            int exitCode = p.waitFor();
//            if (exitCode == 0) {
//                recognizedText = Read_File.read_a_file(outputFilePath);
//                System.out.println("OCR Output: " + recognizedText);
//
//                // Delete the output file
//                File fileToDelete = new File(outputFilePath);
//                if (fileToDelete.exists()) {
//                    fileToDelete.delete();
//                } else {
//                    System.err.println("Output file not found.");
//                }
//            } else {
//                System.err.println("OCR process exited with error code: " + exitCode);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return recognizedText;
//    }
//}
//
















//package com.card.card.write;
//
//import java.io.File;
//
//public class Write {
//    public static String runOCR(String imagePath) {
//        System.out.println("Image Path: " + imagePath);
//
//        if (imagePath == null || imagePath.isEmpty()) {
//            System.err.println("Please provide a valid image path.");
//            return null;
//        }
//
//        // Convert Windows-style path to Unix-style path
//        imagePath = imagePath.replace("\\", "/");
//
//        // Get the file name from the path
//        String fileName = new File(imagePath).getName();
//
//        // Construct the input file path based on the provided image path
//        String inputFilePath = "/usr/src/app/com/card/card/write/" + fileName;
//        System.out.println("Input File Path: " + inputFilePath);
//
//        String outputFilePath = "src/main/java/com/card/card/write/txt.txt";
//        String tesseractInstallPath = "/usr/bin/tesseract";
//
//        String[] command = {tesseractInstallPath, inputFilePath, outputFilePath, "-l", "ara+eng"};
//
//        String recognizedText = null;
//        try {
//            Process p = Runtime.getRuntime().exec(command);
//            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
//            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
//
//            int exitCode = p.waitFor();
//            if (exitCode == 0) {
//                recognizedText = Read_File.read_a_file(outputFilePath);
//                System.out.println("OCR Output: " + recognizedText);
//
//                // Delete the output file
//                File fileToDelete = new File(outputFilePath);
//                if (fileToDelete.exists()) {
//                    fileToDelete.delete();
//                } else {
//                    System.err.println("Output file not found.");
//                }
//            } else {
//                System.err.println("OCR process exited with error code: " + exitCode);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return recognizedText;
//    }
//}










//package com.card.card.write;
//
//import java.io.File;
//
//public class Write {
//    public static String runOCR(String imagePath) {
//        System.out.println("Image Path: " + imagePath);
//
//        if (imagePath == null || imagePath.isEmpty()) {
//            System.err.println("Please provide a valid image path.");
//            return null;
//        }
//
//        // Construct the input file path based on the provided image path
//        String inputFilePath = "/app/com/card/card/write/" + getImageFileName(imagePath);
//        System.out.println("Input File Path: " + inputFilePath);
//
//        String outputFilePath = "src/main/java/com/card/card/write/txt.txt";
//        String tesseractInstallPath = "/usr/bin/tesseract";
//
//        String[] command = {tesseractInstallPath, inputFilePath, outputFilePath, "-l", "ara+eng"};
//
//        String recognizedText = null;
//        try {
//            Process p = Runtime.getRuntime().exec(command);
//            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
//            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
//
//            int exitCode = p.waitFor();
//            if (exitCode == 0) {
//                recognizedText = Read_File.read_a_file(outputFilePath);
//                System.out.println("OCR Output: " + recognizedText);
//
//                // Delete the output file
//                File fileToDelete = new File(outputFilePath);
//                if (fileToDelete.exists()) {
//                    fileToDelete.delete();
//                } else {
//                    System.err.println("Output file not found.");
//                }
//            } else {
//                System.err.println("OCR process exited with error code: " + exitCode);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return recognizedText;
//    }
//
//    // Helper method to extract file name from the given path
//    private static String getImageFileName(String imagePath) {
//        if (imagePath == null) {
//            return null;
//        }
//
//        File imageFile = new File(imagePath);
//        return imageFile.getName();
//    }
//}
//

















//package com.card.card.write;
//
//import java.io.File;
//
//import java.io.File;
//
//public class Write {
//    public static String runOCR(String imagePath) {
//        String inputFilePath = imagePath;
//        String outputFilePath = "/app/com/card/card/write/txt.txt";
//        String tesseractInstallPath = "/usr/bin/tesseract";
//
//        String[] command = {tesseractInstallPath, inputFilePath, outputFilePath, "-l", "ara+eng"};
//
//        String recognizedText = null;
//        try {
//            Process p = Runtime.getRuntime().exec(command);
//            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
//            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
//
//            int exitCode = p.waitFor();
//            if (exitCode == 0) {
//                recognizedText = Read_File.read_a_file(outputFilePath);
//                System.out.println("OCR Output: " + recognizedText);
//
//                // Delete the output file
//                File fileToDelete = new File(outputFilePath);
//                if (fileToDelete.exists()) {
//                    fileToDelete.delete();
//                } else {
//                    System.err.println("Output file not found.");
//                }
//            } else {
//                System.err.println("OCR process exited with error code: " + exitCode);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return recognizedText;
//    }
//}


//------------------------------------ The right code --------------------------------
//
//package com.card.card.write;
//
//import java.io.File;
//import java.io.PrintWriter;
//
//public class Write {
//public static String runOCR(String imagePath) {
//    String inputFilePath = imagePath;
//    String outputFilePath = "src/main/java/com/card/card/write/txt";
//    String tesseractInstallPath = "Tesseract-OCR/tesseract";
////    String tesseractInstallPath = "/usr/share/tesseract-ocr/tesseract";;
//
//
//    String[] command = {tesseractInstallPath, inputFilePath, outputFilePath, "-l", "ara+eng"};
//
//    String recognizedText = null;
//    try {
//        Process p = Runtime.getRuntime().exec(command);
//        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
//        new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
//
//        int exitCode = p.waitFor();
//        if (exitCode == 0) {
//            recognizedText = Read_File.read_a_file(outputFilePath + ".txt");
//            System.out.println("OCR Output: " + recognizedText);
//
//            // Delete the output file
//            File fileToDelete = new File(outputFilePath + ".txt");
//            if (fileToDelete.exists()) {
//                fileToDelete.delete();
//            } else {
//                System.err.println("Output file not found.");
//            }
//        } else {
//            System.err.println("OCR process exited with error code: " + exitCode);
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//    return recognizedText;
//}
//}
//
//





















//package com.card.card.write;
//
//import java.io.File;
//import java.io.PrintWriter;
//
//public class Write {
//
//    public static String runOCR(String imagePath) {
//        String inputFilePath = imagePath;
//        String outputFilePath = "src/main/java/com/card/card/write/txt";
//        String tesseractInstallPath = "Tesseract-OCR/tesseract";
//        String[] command = {"cmd"};
//
//        String recognizedText = null;
//        try {
//            Process p = Runtime.getRuntime().exec(command);
//            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
//            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
//
//            // Use try-with-resources to auto-close resources
//            try (PrintWriter stdin = new PrintWriter(p.getOutputStream())) {
//                stdin.println("\"" + tesseractInstallPath + "\" \"" + inputFilePath + "\" \"" + outputFilePath + "\" -l ara+eng");
//            }
//
//            int exitCode = p.waitFor();
//            if (exitCode == 0) {
//                recognizedText = Read_File.read_a_file(outputFilePath + ".txt");
//                System.out.println("OCR Output: " + recognizedText);
//
//                // Delete the output file
//                File fileToDelete = new File(outputFilePath + ".txt");
//                if (fileToDelete.exists()) {
//                    fileToDelete.delete();
//                } else {
//                    System.err.println("Output file not found.");
//                }
//            } else {
//                System.err.println("OCR process exited with error code: " + exitCode);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return recognizedText;
//    }
//}
