package com.grad.kata4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Football {

    public static void main(String[] args) {
        String path = "src/main/resources/football.dat";
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            reader.readLine();
            Map<String, Integer> teamsWithScoreDifference = saveDataToMap(reader);
            Integer smallestDifference = findSmallestDifference(teamsWithScoreDifference);
            System.out.println(findTeam(teamsWithScoreDifference, smallestDifference));
        } catch (IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    private static String findTeam(Map<String, Integer> teamsWithScoreDifference, Integer smallestDifference) {
        String team = null;
        for (Map.Entry<String, Integer> e : teamsWithScoreDifference.entrySet()) {
            if (e.getValue().equals(smallestDifference)) {
                team = e.getKey();
                break;
            }
        }
        return team;
    }

    private static Integer findSmallestDifference(Map<String, Integer> teamsWithScoreDifference) {
        Integer smallest = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> e : teamsWithScoreDifference.entrySet()) {
            Integer scoreDifference = e.getValue();
            if (scoreDifference < smallest) {
                smallest = scoreDifference;
            }
        }
        return smallest;
    }

    private static Map<String, Integer> saveDataToMap(BufferedReader reader) throws IOException {
        Map<String, Integer> goalDifference = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String newLine = line.trim();
            if (Character.isDigit(newLine.charAt(0))) {
                String team = line.substring(7, 20).trim();
                Integer goalTo = Integer.parseInt(line.substring(43, 45));
                Integer goalFrom = Integer.parseInt(line.substring(50, 52));
                Integer difference = Math.abs(goalTo - goalFrom);
                goalDifference.put(team, difference);
            }
        }
        return goalDifference;
    }
}
