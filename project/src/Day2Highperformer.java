import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long evalCycles = 50000;
        double versuchSum = 0;
        for (int j = 0; j < evalCycles; j++) {
            boolean allGreen = false;
            long ergebnis = new Random().nextLong(100000, 1000000);
            long guess = 123456;
            long anzahlStellen = 6;
            long correctness = 0;
            long versuche = 0;


            while (correctness < 222222) {

                correctness = 0;

                for (int stelle = 1; stelle <= anzahlStellen; stelle++) {
                    int match = 0;
                    long kleinererZehner = (long) Math.pow(10, anzahlStellen - stelle);
                    long jetztStelle = (guess / kleinererZehner) % 10;

                    int prevDuplicates = 0;

                    for (int selbstStelle = 0; selbstStelle < stelle; selbstStelle++) {
                        long prevKleinererZehner = (long) Math.pow(10, anzahlStellen - selbstStelle);
                        long prevStelle = (guess / prevKleinererZehner) % 10;
                        if (prevStelle == jetztStelle) {
                            prevDuplicates++;
                        }
                    }


                    for (int ergebnisStelle = 1; ergebnisStelle <= anzahlStellen; ergebnisStelle++) {
                        long kleinerZehnerErgebnis = (long) Math.pow(10, anzahlStellen - ergebnisStelle);
                        long jetztStelleErgebnis = (ergebnis / kleinerZehnerErgebnis) % 10;
                        long jetztStelleGuess = (guess / kleinerZehnerErgebnis) % 10;


                        if (jetztStelle == jetztStelleErgebnis && stelle == ergebnisStelle) {
                            match = 2;
                        } else if (jetztStelle == jetztStelleErgebnis && jetztStelleErgebnis != jetztStelleGuess && prevDuplicates == 0) {
                            match = Math.max(match, 1);
                        } else if (jetztStelle == jetztStelleErgebnis && jetztStelleErgebnis != jetztStelleGuess) {
                            prevDuplicates--;
                        }
                    }

                    if (match == 0) {

                    } else if (match == 1) {
                        correctness = correctness + 1 * kleinererZehner;
                    } else {
                        correctness = correctness + 2 * kleinererZehner;
                    }
                }

                //System.out.println(correctness);
                long newguess = 0;

                boolean didYellow = false;
                long allYellows = 0;
                long yellowGuess = 0;

                for (int stelle = 1; stelle <= anzahlStellen; stelle++) {
                    long kleinererZehner = (long) Math.pow(10, anzahlStellen - stelle);
                    long hierCorrectness = (correctness / kleinererZehner % 10);
                    long hierGuess = (guess / kleinererZehner % 10);

                    if (hierCorrectness == 1 && !didYellow) {
                        yellowGuess = hierGuess;
                        didYellow = true;

                        //System.out.println(yellowGuess);
                        //System.out.println(newguess);
                        //System.out.println();

                        for (int i = 1; i < stelle; i++) {
                            long bisherZehner = (long) Math.pow(10, anzahlStellen - i);
                            long bisherCorrectness = (correctness / kleinererZehner % 10);

                            //System.out.println(i);
                            //System.out.println(bisherZehner);
                            if (bisherCorrectness != 2) {
                                long temp = newguess / bisherZehner / 10;
                                //System.out.println(temp);
                                temp = temp * bisherZehner * 10;
                                //System.out.println(temp);
                                newguess = (newguess % bisherZehner) + temp;
                                //System.out.println(newguess);
                                newguess = newguess + yellowGuess * bisherZehner;
                                //System.out.println(newguess);
                            }


                            //System.out.println(newguess);
                        }
                        newguess = newguess + new Random().nextInt(10) * kleinererZehner;
                    } else if (hierCorrectness < 2 && didYellow) {
                        newguess = newguess + yellowGuess * kleinererZehner;
                    } else if (hierCorrectness == 0 && !didYellow) {
                        newguess = newguess + new Random().nextInt(10) * kleinererZehner;
                    } else {
                        newguess = newguess + hierGuess * kleinererZehner;
                    }
                }
                //System.out.println(newguess);
                //System.out.println();
                guess = newguess;
                versuche++;
            }
            versuchSum += versuche;
            //System.out.println(versuche);
        }
        System.out.println(versuchSum / evalCycles);
    }
}//33z35