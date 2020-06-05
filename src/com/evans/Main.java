package com.evans;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        playGame();
    }

    private static String bear = "bear";
    private static String human = "human";
    private static String gun = "gun";

    public static int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(3);
    }

    public static String getUserChoice(String userInput){
        String newInput = userInput.toLowerCase();
        if(newInput.equals(bear) || newInput.equals(human) || newInput.equals(gun)){
            return newInput; }
        else{ return "invalid input"; }
    }

    public static String getComputerChoice(){
        int getNumber = generateRandomNumber();
        if(getNumber == 0){ return bear; }
        else if(getNumber == 1){ return human; }
        else { return gun; }
    }

    public static String determineWinner(String userChoice, String computerChoice){
        if(userChoice.equals(bear) && computerChoice.equals(human)){ return "You Win! You mauled the human!";    }
        if(userChoice.equals(bear) && computerChoice.equals(gun)){ return  "You Lose, you have been shot!";}
        if(userChoice.equals(human) && computerChoice.equals(gun)){ return "You Win! You have disarmed the gun!";    }
        if(userChoice.equals(human) && computerChoice.equals(bear)){ return  "You Lose, you have been mauled by a bear!";}
        if(userChoice.equals(gun) && computerChoice.equals(bear)){ return "You Win! You shot the bear!";    }
        if(userChoice.equals(gun) && computerChoice.equals(human)){ return  "You Lose, you have been disarmed!";}
        else return "DRAW -- Match was a tie.";
    }





    public static void playGame(){
        Scanner scanner = new Scanner(System.in);
        String userData = scanner.nextLine(); //error here (with 'human' as an example) {byte[5]@942} instead of {byte[5]@945}
        getUserChoice(userData);
        String cpuData = getComputerChoice();
        String winner = determineWinner(userData,cpuData);
        System.out.println(winner);
    }

//    public static void viewTable(Connection con, String dbName)
//            throws SQLException {
//
//        Statement stmt = null;
//        String query = "select COF_NAME, SUP_ID, PRICE, " +
//                "SALES, TOTAL " +
//                "from " + dbName + ".COFFEES";
//        try {
//            stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                String coffeeName = rs.getString("COF_NAME");
//                int supplierID = rs.getInt("SUP_ID");
//                float price = rs.getFloat("PRICE");
//                int sales = rs.getInt("SALES");
//                int total = rs.getInt("TOTAL");
//                System.out.println(coffeeName + "\t" + supplierID +
//                        "\t" + price + "\t" + sales +
//                        "\t" + total);
//            }
//        } catch (SQLException e ) {
//            JDBCTutorialUtilities.printSQLException(e);
//        } finally {
//            if (stmt != null) { stmt.close(); }
//        }
//    }
}
