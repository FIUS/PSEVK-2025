# Programmierung und Software-Entwicklung (PSE)

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
