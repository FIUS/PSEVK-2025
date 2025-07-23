\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{sheets}[2025/07/14 Custom exercise sheet class for PSE]

\LoadClass[11pt,a4paper]{article}

% Pakete
\RequirePackage[utf8]{inputenc}
\RequirePackage[T1]{fontenc}
\RequirePackage[ngerman]{babel}
\RequirePackage{xcolor}
\RequirePackage{geometry}
\RequirePackage{graphicx}
\RequirePackage{fancyhdr}
\RequirePackage{minted}
\RequirePackage[most]{tcolorbox}
\RequirePackage{titlesec}
\RequirePackage{hyperref}

% Farben
\definecolor{accent}{RGB}{80, 85, 124}
\definecolor{dark}{RGB}{36, 36, 36}
\definecolor{green}{rgb}{0.0, 0.7, 0.0}
\definecolor{codebackgroundcolor}{rgb}{1, 1, 1}
\definecolor{codelinenocolor}{rgb}{0.18, 0.18, 0.18}

% Seitenränder
\geometry{margin=2.5cm}

% Schrift
\usepackage{helvet}
\renewcommand{\familydefault}{\sfdefault}


% Titelblatt
\renewcommand{\maketitle}{
  \vspace*{0.5em}
  \begin{center}
    {\Huge\bfseries\color{accent}\@title \par}
    \vspace{0.5em}
    {\large\@author \par}
    \vspace{0.5em}
    % Hier: "{\normalsize \@date \par}" einfügen um Datum auf Seite 1 zu akitveren. By default today 
  \end{center}
  \vspace{1em}
}

% klein Titel
\newcommand{\aufgabe}[1]{%
  \par\bigskip
  {\Large\bfseries\color{accent} #1\par}%
  \medskip
}


% Ausgabe-Box
\newtcolorbox{ausgabe}{
  enhanced,
  breakable,
  colback=gray!3,
  colframe=black!20,
  boxrule=0.5pt,
  arc=2mm,
  left=1em,
  right=1em,
  top=0.6em,
  bottom=0.6em,
  boxsep=0pt,
  fontupper=\ttfamily\small\color{black},
}

% Minted style 
\definecolor{codelinenocolor}{rgb}{0.18, 0.18, 0.18}

\usepackage{minted}
\usemintedstyle{paraiso-light}

\setminted{
  fontsize=\scriptsize,
  linenos=true,
  stripall=true,
  breaklines=true,
  autogobble=true,
  xleftmargin=10pt,     
  numbersep=5pt,        
  texcomments,
  escapeinside=~~,
}

\renewcommand{\theFancyVerbLine}{\color{codelinenocolor}\tiny\arabic{FancyVerbLine}}

\BeforeBeginEnvironment{minted}{
  \begin{tcolorbox}[
    colback=gray!5,
    colframe=black!80,
    boxrule=0.5pt,
    arc=2mm,
    enhanced,
    boxsep=1pt,
    left=4pt, right=4pt, top=4pt, bottom=4pt,
  ]
}
\AfterEndEnvironment{minted}{
  \end{tcolorbox}
}


% Logos
\RequirePackage{atbegshi}

\newcommand{\logopath}{logos/}

\RequirePackage{tikz}
\RequirePackage{background}
\RequirePackage{fancyhdr}
\RequirePackage{etoolbox}

% Logos groß Titelblatt
\newcommand{\SetBigLogos}{
  \backgroundsetup{
    scale=1,
    placement=top,
    position={current page.north west},
    angle=0,
    opacity=1,
    contents={
      \begin{tikzpicture}[remember picture, overlay]
        \node[anchor=north west, inner sep=30pt, shift={(0.5cm,-0.3cm)}]
          at (current page.north west)
          {\includegraphics[height=3em]{\logopath logo-uni.pdf}};
        \node[anchor=north east, inner sep=30pt, shift={(-0.5cm,0.2cm)}]
          at (current page.north east)
          {\includegraphics[height=6em]{\logopath fius-logo-neu.png}};
      \end{tikzpicture}
    }
  }
}

% Kopfzeile + Fußzeile
\fancypagestyle{normal}{
  \fancyhf{}
  \fancyhead[L]{\includegraphics[height=1.5em]{\logopath logo-uni.pdf}}
  \fancyhead[R]{\includegraphics[height=1.8em]{\logopath fius-logo-neu.png}}
  \fancyhead[C]{\@title}  % ← Ändere "2" je nach Tag!
  \fancyfoot[C]{\thepage}
  \renewcommand{\headrulewidth}{0.4pt}
  \renewcommand{\footrulewidth}{0pt}
}

% Logos groß hinzufügen Kopfzeile hinzufügen
\AtBeginDocument{%
  \SetBigLogos
  \BgThispage              % Logos als Hintergrund auf erster Seite
  \thispagestyle{empty}    % keine fancyhdr auf Seite 1
  \pagestyle{normal}       % ab Seite 2 kleiner Header
}

% Logos groß ab Seite 2 deaktivieren
\AtBeginShipout{%
  \ifnum\value{page}>1
    \backgroundsetup{contents={}}%
  \fi
}


% Abstände
\setlength{\parindent}{0pt}
\setlength{\parskip}{0.5em}
