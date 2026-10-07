public class Student {
    int matrNr;
    String name;
    int aktuellesSemester;
    int wissen;
    int motivationsLevel;

    public Student(String name, int aktuellesSemester){
        this.name = name;
        this.aktuellesSemester = aktuellesSemester;
        // 2.1
        this.wissen = (aktuellesSemester - 1) * 20;
        this.motivationsLevel = 20;
        System.out.println("Student " + name + " wurde erstellt");
    }

    // 2.2
    void problemErklaeren(Student student){
        if (student.wissen < this.wissen) {
            System.out.println(this.name + " erklärt " + student.name + " wie Klassen funktionieren.");

            // 2.3
            student.wissen += 10;
            this.motivationsLevel -= 4;

            // 2.4
            if (this.aktuellesSemester >= 3) {
                System.out.println("Tutor " + this.name + " hilft " + student.name);
            } else {
                System.out.println(this.name + " hilft " + student.name);
            }

        } else {
            System.out.println("Hey du kannst mir gar nicht helfen.");
        }
    }
}

