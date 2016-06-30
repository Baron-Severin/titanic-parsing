/**
 * Created by erikrudie on 6/30/16.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;


public class main {


  public static void main(String[] args) throws FileNotFoundException {

    FileReader fileReader = new FileReader("titanic.csv");
    System.out.println("We have made a FileReader");
    BufferedReader reader = new BufferedReader(fileReader);
    System.out.println("BufferedReader attached");

    // to remove the header
    int entryCount = -1;
    int maleCount = 0;
    int femaleCount = 0;
    int underSixteen1st = 0;
    int underSixteenSurvived1st = 0;
    int underSixteen2nd = 0;
    int underSixteenSurvived2nd = 0;
    int underSixteen3rd = 0;
    int underSixteenSurvived3rd = 0;
    int underSixteenTotal = 0;

    int firstClass = 0;
    int firstClassSurvived = 0;
    int secondClass = 0;
    int secondClassSurvived = 0;
    int thirdClass = 0;
    int thirdClassSurvived = 0;


try {
  String tempString = reader.readLine();

      do {

        tempString = tempString.toString();

        System.out.println(tempString);
        entryCount++;

        String[] splitString = tempString.split(",");

        if (splitString[5].equals("male")) {
          maleCount++;
        } else if (splitString[5].equals("female")) {
          femaleCount++;
        }

        try {
          if ((Integer.parseInt(splitString[6]) > -1 && Integer.parseInt(splitString[6]) <= 16)) {
            underSixteenTotal++;
          }
          if ((Integer.parseInt(splitString[6]) > -1 && Integer.parseInt(splitString[6]) <= 16)
            && splitString[1].equals("1") && splitString[2].equals("1")) {
            underSixteenSurvived1st++;
            underSixteen1st++;
          } else if (Integer.parseInt(splitString[6]) > -1 && Integer.parseInt(splitString[6]) <= 16 && splitString[2].equals("1")) {
            underSixteen1st++;
          } else if ((Integer.parseInt(splitString[6]) > -1 && Integer.parseInt(splitString[6]) <= 16)
            && splitString[1].equals("1") && splitString[2].equals("2")) {
            underSixteenSurvived1st++;
            underSixteen1st++;
          } else if (Integer.parseInt(splitString[6]) > -1 && Integer.parseInt(splitString[6]) <= 16 && splitString[2].equals("2")) {
            underSixteen1st++;
          } else if ((Integer.parseInt(splitString[6]) > -1 && Integer.parseInt(splitString[6]) <= 16)
            && splitString[1].equals("1") && splitString[2].equals("3")) {
            underSixteenSurvived1st++;
            underSixteen1st++;
          } else if (Integer.parseInt(splitString[6]) > -1 && Integer.parseInt(splitString[6]) <= 16 && splitString[2].equals("3")) {
            underSixteen1st++;
          }
        } catch (NumberFormatException ex) {
//          System.out.println("NumberFormatException on following line: " + tempString);
        }

        if (splitString[2].equals("1") && splitString[1].equals("1")) {
          firstClass++;
          firstClassSurvived++;
        } else if (splitString[2].equals("1")) {
          firstClass++;
        } else if (splitString[2].equals("2") && splitString[1].equals("1")) {
          secondClass++;
          secondClassSurvived++;
        } else if (splitString[2].equals("2")) {
          secondClass++;
        } else if (splitString[2].equals("3") && splitString[1].equals("1")) {
          thirdClass++;
          thirdClassSurvived++;
        } else if (splitString[2].equals("3")) {
          thirdClass++;
        } else {
          System.out.println("No class???");
        }

      }  while ((tempString = reader.readLine()) != null);

    } catch (IOException ex) {

      System.out.println("Dang.  That didn't work.");

    }

    // There were no recorded passengers under 16 in 2nd or 3rd class, so this was causing divide by zero exceptions.

//    double survivalCalc = (double) underSixteenSurvived / underSixteen;

    System.out.println(underSixteenTotal);
    System.out.println(underSixteen1st + " " + underSixteen2nd + " " + underSixteen3rd + " " + underSixteenSurvived1st + " " + underSixteenSurvived2nd + " " + underSixteenSurvived3rd);;
    
//    double firstClass16SurvivalRate = underSixteenSurvived1st / underSixteen1st;
//    double secondClass16SurvivalRate = underSixteenSurvived2nd / underSixteen2nd;
//    double thirdClass16SurvivalRate = underSixteenSurvived3rd / underSixteen3rd;

    double firstClassSurvivalRate = (double) firstClassSurvived / firstClass;
    double secondClassSurvivalRate = (double) secondClassSurvived / secondClass;
    double thirdClassSurvivalRate = (double) thirdClassSurvived / thirdClass;

//    String under16Survival = MessageFormat.format("{0,number,#.##%}", survivalCalc);

    String firstClassSurvival = MessageFormat.format("{0,number,#.##%}", firstClassSurvivalRate);
    String secondClassSurvival = MessageFormat.format("{0,number,#.##%}", secondClassSurvivalRate);
    String thirdClassSurvival = MessageFormat.format("{0,number,#.##%}", thirdClassSurvivalRate);

//    String firstClass16Survival = MessageFormat.format("{0,number,#.##%}", firstClass16SurvivalRate);
//    String secondClass16Survival = MessageFormat.format("{0,number,#.##%}", secondClass16SurvivalRate);
//    String thirdClass16Survival = MessageFormat.format("{0,number,#.##%}", thirdClass16SurvivalRate);

    System.out.println("\n\nTotal passengers: " + entryCount);
    System.out.println("Total males: " + maleCount + "\nTotal Females: " + femaleCount );
    System.out.println("First class survival rate: " + firstClassSurvived + " out of " + firstClass + ", or " + firstClassSurvival);
    System.out.println("Second class survival rate: " + secondClassSurvived + " out of " + secondClass + ", or " + secondClassSurvival);
    System.out.println("Third class survival rate: " + thirdClassSurvived + " out of " + thirdClass + ", or " + thirdClassSurvival);
    
//    System.out.println("Under 16 first class survival rate: " + underSixteenSurvived1st + " out of " + underSixteen1st + ", or " + firstClass16Survival);
//    System.out.println("Under 16 second class survival rate: " + underSixteenSurvived1st + " out of " + underSixteen1st + ", or " + secondClass16Survival);
//    System.out.println("Under 16 third class survival rate: " + underSixteenSurvived1st + " out of " + underSixteen1st + ", or " + thirdClass16Survival);

    
    
  }


}
