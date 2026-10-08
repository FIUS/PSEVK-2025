public class Raum {
    int raumNr;
    Student[] tutoren;
    Student[] erstis;


    // 3.2
    public Raum(int raumNr){
        int tutorenAnzahl = 0;
        int erstiAnzahl = 0;
        int maxTutorenAnzahl = 4;
        int maxErstiAnzahl = 25;

        this.raumNr = raumNr;
        tutoren = new Student[maxTutorenAnzahl];
        erstis = new Student[maxErstiAnzahl];
    }

    // 3.3
    void tutorHinzufuegen(Student student){
        if (student.aktuellesSemester >= 2){
            tutoren[tutorenAnzahl] = student;
            System.out.println(student.name + " wurde als Tutor zum Raum " + raumNr + " hinzugefügt.");
            tutorenAnzahl++;
        } else {
            erstis[erstiAnzahl] = student;
            if (this.tutorenAnzahl == 0){
                System.out.println("Such dir einen anderen Raum! Hier ist gar kein Tutor.");
            } else {
                System.out.println(student.name + " wurde als ersti zum Raum " + raumNr + " hinzugefügt.");
                erstiAnzahl++;
            }
        }

    }

    // 3.4
    void leuteAusgeben(){
        System.out.println("In Raum " + raumNr + " sind folgende Tutoren:");
        for (int i = 0; i < tutorenAnzahl; i++){
            System.out.println(tutoren[i].name);
        }
        System.out.println("In Raum " + raumNr + " sind folgende erstis:");
        for (int i = 0; i < erstiAnzahl; i++){
            System.out.println(erstis[i].name);
        }
    }
}
