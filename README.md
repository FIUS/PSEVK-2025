# PSEVK-2025
Sheets and project for the annual Java-Vorkurs of the Fachgruppe Informatik der Universität Stuttgart.

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

### Autoformatter
um ein einheitliches Code lesen zu gewährleisten wird latexindent verwenden in kombination mit latexworkshop -> VSCode Extension
```bash
brew install latexindent
```

