# PSEVK (Java-Vorkurs)
Sheets and project for the annual Java-Vorkurs of the Fachgruppe Informatik der Universität Stuttgart.

## Jährliche Konfiguration (`src/config.tex`)
Da es sich um ein jährliches Event handelt, können alle Variablen (Datum, Links, Personen, Rahmenprogramm) an einem einzigen Ort geändert werden: **`src/config.tex`** (bzw. `config.tex` im Hauptverzeichnis).

Dort lassen sich zentral anpassen:
- **Allgemeine Event-Infos:** `\vkTitle`, `\vkYear`, `\vkMonth`, `\vkSemester`, `\vkAuthors`, `\vkInstitute`, `\vkJdkVersion`
- **Tagesdaten:** `\vkDateDayZero` bis `\vkDateDayFive`
- **Web-Links:**
  - Folien- und Aufgaben-Link: `\vkFolienUrl` (wird automatisch mit QR-Code eingebunden)
  - Feedback-Links (Google Forms / EvaSys): `\vkFeedbackUrlDayOne` bis `\vkFeedbackUrlDayFive`
  - Basis-URL für Uploads & Musterlösungen: `\vkUploadsBaseUrl` (aktualisiert automatisch alle Musterlösungs-ZIPs für Tag 1-4 & Highperformer)
- **Rahmenprogramm / Social Events:** Grillerei (`\vkEventDayZero`), Karaoke (`\vkEventDayOne`), Kneipentour (`\vkEventDayFour...`), UNO-Party (`\vkEventDayFive...`)
- **Feedbackbögen (Print):** Titel (`\vkSurveyTitle`) und Seminarräume (`\vkSurveyRooms`)


## Kompilation 

### Vorraussetzungen 
Die Folien verwenden `minted` um Syntax-Highlighting bereitzustellen.
Dafür wird das Python-Paket `pygments` benötigt

```bash
pip3 install pygments
```
### Kompilieren mit latexmk
Anschließend können die Folien wie gewohnt kompiliert werden wobei der LaTeX-Compiler die Flag `-shell-escape` übergeben bekommen muss.
Das wird benötigt, damit `minted` beim Erstellen des PDFs auf Python zugreifen kann.

```bash
latexmk -pdf -pvc -shell-escape slides.tex
```

Da es mit der Verwendung von der beamer-Klasse in Kombination mit dem `\listoftodos` -Kommand zu fehlern kommen kann, muss ggf. dem $\LaTeX$-Compiler die Flag `-interaction=nonstopmode` übergeben werden.

### Kompilieren mit GNU make
Die Folien können mit Hilfe des makefiles compiliert werden. 
Mittels 

```bash
make 
```
können sowohl die Slides als auch die Übungsaufgaben kompiliert werden. 
Hier ist jedoch der `nonstopmode` nicht aktiviert. 


Mittels 
```bash
make build-(exercise|slides)
```
können die Blätter und Slides separat kompiliert werden. 
Auch hier ist der `nonstopmode` nicht aktviert. 

Um alle slides mit `nonstopmode` zu kompilieren kann man 
```bash
make rushb 
```
verwenden.

Die einzelen Tage können mit 
```bash
make DayX 
```
kompiliert werden. 

mit 
```bash
make (exercise|presentation)/DayX 
``` 
wird das Arbeitsblatt/ die Präsentation des spezifischen Tag kompiliert.

Mit 
```bash
make (diff|diff-slides) 
``` 
kann ein Diff zwischen unterschiedlichen Versionen erstellt werden.
Mittels der Kommandozeilenargumente **old** und **new** können Commits spezifiziert werden. 
Standardmäßig sind die Argumente **old=HEAD** und **new=--**, welches das aktuelle Verzeichnis mit dem letzten Commit vergleicht.


### Präsentieren und Anschauen
Falls pdfpc installiert ist, kann man mit dem Makefile direkt die Präsentation aufrufen. 
```bash
make (view/DayX|viewexercise/DayX) 
``` 


### Autoformatter
um ein einheitliches Code lesen zu gewährleisten wird latexindent verwenden in kombination mit latexworkshop -> VSCode Extension
```bash
brew install latexindent
```

