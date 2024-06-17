package com.dsproject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CertificateGenerator {

    public static void main(String[] args) {
        // Set the number of names to generate certificates for
        int nameCount = 50;

        System.out.println("Generating for " + nameCount + " names\n");

        // Initialize data structures
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> treeMap = new TreeMap<>();

        // Add names to data structures and measure space complexity
        measureSpaceTaken(() -> addNames(arrayList, nameCount), "ArrayList", nameCount);
        measureSpaceTaken(() -> addNames(linkedList, nameCount), "LinkedList", nameCount);
        measureSpaceTaken(() -> addNamesToMap(hashMap, nameCount), "HashMap", nameCount);
        measureSpaceTaken(() -> addNamesToMap(treeMap, nameCount), "TreeMap", nameCount);

        System.out.println();

        // Create certificates directory if it doesn't exist
        File dir = new File("certificates_" + nameCount);
        if (!dir.exists()) {
            dir.mkdir();
        }

        // Generate certificates and measure time for ArrayList
        long startTime = System.nanoTime();
        for (String name : arrayList) {
            generateCertificate(name, dir.getPath());
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken to generate all certificates for ArrayList: " + (endTime - startTime) + " ns\n");

        // Generate certificates and measure time for LinkedList
        startTime = System.nanoTime();
        for (String name : linkedList) {
            generateCertificate(name, dir.getPath());
        }
        endTime = System.nanoTime();
        System.out
                .println("Time taken to generate all certificates for LinkedList: " + (endTime - startTime) + " ns\n");

        // Generate certificates and measure time for HashMap
        startTime = System.nanoTime();
        for (String name : hashMap.keySet()) {
            generateCertificate(name, dir.getPath());
        }
        endTime = System.nanoTime();
        System.out.println("Time taken to generate all certificates for HashMap: " + (endTime - startTime) + " ns\n");

        // Generate certificates and measure time for TreeMap
        startTime = System.nanoTime();
        for (String name : treeMap.keySet()) {
            generateCertificate(name, dir.getPath());
        }
        endTime = System.nanoTime();
        System.out.println("Time taken to generate all certificates for TreeMap: " + (endTime - startTime) + " ns\n");

        System.out.println();
    }

    private static void addNames(List<String> list, int count) {
        for (int i = 1; i <= count; i++) {
            list.add("Name" + i);
        }
    }

    private static void addNamesToMap(Map<String, String> map, int count) {
        for (int i = 1; i <= count; i++) {
            map.put("Name" + i, "Certificate of Achievement");
        }
    }

    private static void generateCertificate(String name, String directoryPath) {
        int width = 800;
        int height = 600;

        // Create a blank image with background color
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        // Draw background
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Add text
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 48));
        g2d.drawString("Certificate of Achievement", 100, 100);
        g2d.setFont(new Font("Arial", Font.PLAIN, 36));
        g2d.drawString("This certifies that", 100, 200);
        g2d.setFont(new Font("Arial", Font.BOLD, 48));
        g2d.drawString(name, 100, 300);
        g2d.setFont(new Font("Arial", Font.PLAIN, 36));
        g2d.drawString("has successfully completed the course.", 100, 400);

        g2d.dispose();

        // Save as JPEG
        try {
            ImageIO.write(bufferedImage, "jpeg", new File(directoryPath, name + "_certificate.jpeg"));
            System.out.println("Certificate generated for: " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void measureSpaceTaken(Runnable populateDataStructure, String dataStructureName,
            int nameCount) {
        Runtime runtime = Runtime.getRuntime();

        // Perform garbage collection
        runtime.gc();

        // Measure memory before populating the data structure
        long beforeMemory = runtime.totalMemory() - runtime.freeMemory();

        // Populate the data structure
        populateDataStructure.run();

        // Measure memory after populating the data structure
        long afterMemory = runtime.totalMemory() - runtime.freeMemory();

        // Calculate the space complexity
        long usedMemory = afterMemory - beforeMemory;

        System.out.println(dataStructureName + " used memory for " + nameCount + " names: " + usedMemory + " bytes");
    }
}
