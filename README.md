# JVK-2025
Sheets and project for the annual Java-Vorkurs of the Fachgruppe Informatik der Universität Stuttgart.

### Lokal (mit Syntax Highlighting)

Die Folien verwenden `minted` um Syntax-Highlighting bereitzustellen.
Dafür wird das Python-Paket `pygments` benötigt

```bash
pip3 install pygments
```

Anschließend können die Folien wie gewohnt kompiliert werden wobei der LaTeX-Compiler die Flag `-shell-escape` übergeben bekommen muss.
Das wird benötigt, damit `minted` beim Erstellen des PDFs auf Python zugreifen kann.

```bash
latexmk -pdf -pvc -shell-escape slides.tex
```

Autoformatter, um ein einheitliches Code lesen zu gewährleisten wird latexindent verwenden in kombination mit latexworkshop -> VSCode Extension
```bash
brew install latexindent
```

