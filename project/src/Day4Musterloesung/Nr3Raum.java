public class Raum {
    int raumNr;
    Student[] tutoren;
    Student[] ersties;

    int tutorenAnzahl = 0;
    int erstieAnzahl = 0;
    int maxTutorenAnzahl = 4;
    int maxErstieAnzahl = 25;

    // 3.2
    public Raum(int raumNr){
        this.raumNr = raumNr;
        tutoren = new Student[4];
        ersties = new Student[30];
    }

    // 3.3
    void studentHinzufuegen(Student student){
        if (student.aktuellesSemester >= 2){
            tutoren[tutorenAnzahl] = student;
            System.out.println(student.name + " wurde als Tutor zum Raum " + raumNr + " hinzugefügt.");
            tutorenAnzahl ++;
        } else {
            ersties[erstieAnzahl] = student;
            if (this.tutorenAnzahl == 0){
                System.out.println("Such dir einen anderen Raum! Hier ist gar kein Tutor.");
            } else {
                System.out.println(student.name + " wurde als Erstie zum Raum " + raumNr + " hinzugefügt.");
                erstieAnzahl++;
            }
        }

    }

    // 3.4
    void leuteAusgeben(){
        System.out.println("In Raum " + raumNr + " sind folgende Tutoren:");
        for (int i = 0; i < tutorenAnzahl; i++){
            System.out.println(tutoren[i].name);
        }
        System.out.println("In Raum " + raumNr + " sind folgende Ersties:");
        for (int i = 0; i < erstieAnzahl; i++){
            System.out.println(ersties[i].name);
        }

    }

}
