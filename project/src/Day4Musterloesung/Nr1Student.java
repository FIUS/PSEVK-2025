public class Student {
    // 1.2
    int matrNr;
    String name;
    int aktuellesSemester;
    int wissen;
    int motivationsLevel;

    // 1.3
    public Student(String name, int aktuellesSemester){
        this.name = name;
        this.aktuellesSemester = aktuellesSemester;
        this.wissen = 0;
        this.motivationsLevel = 20;
        System.out.println("Student " + name + " wurde erstellt");
    }

    // 1.4
    void lernen(){
        // 1.6
        if (motivationsLevel <= 4){
            System.out.println("Ich kann jetzt echt nichts mehr lernen! Gehen wir mensieren?");
            return;
        }
        // 1.6 Ende

        wissen += 10;
        motivationsLevel -= 5;
        System.out.println(name + " lernt gerade!");
    }

    // 1.5
    void inDieMensaGehen(){
        motivationsLevel = 20;
        System.out.println("Mhmm Gyros war so schmackofatz!!!");
    }

}

