\ProvidesClass{presentation}[2024/11/27 Lecture Slides for PSE]

% Beamer class requires the following line to be included
\LoadClass[aspectratio=1610]{beamer}
\makeatletter
\newcommand{\lecture@pathprefix}[1]{}
\makeatother

\usepackage{xcolor}
\definecolor{accent}{RGB}{80, 85, 124}
\definecolor{dark}{RGB}{36, 36, 36}
\definecolor{green}{rgb}{0.0, 0.7, 0.0} % use a darker shade of green

% Farben für Tabellenzeilen
\definecolor{tablehead}{RGB}{216,232,237}
\definecolor{tablerow}{RGB}{240,240,240}

\usepackage[scaled]{helvet}
\usepackage[utf8]{inputenc}
\usepackage[T1]{fontenc}
\usepackage[english,main=ngerman]{babel}


\usepackage{xparse}


\usepackage{tabularx}
\usepackage{booktabs}
\usepackage{makecell}
\usepackage{colortbl}
\usepackage{multirow}
\setlength\extrarowheight{6pt}


\usepackage{csquotes}

% Package imports
\usepackage{tikz}
\usetikzlibrary{positioning,
                topaths,
                decorations.pathreplacing,
                decorations.pathmorphing,
                intersections,
                arrows,
                calc,
                backgrounds,
                shapes.misc,
                angles,
                quotes,
                patterns,
                arrows.meta
}
\usepackage[most]{tcolorbox}
\tcbuselibrary{listingsutf8}


\tikzset{cross/.style={cross out, draw=black, minimum size=2*(#1-\pgflinewidth), inner sep=0pt, outer sep=0pt},
%default radius will be 1pt. 
cross/.default={1pt}}

\tikzset{
  -|-/.style={
    to path={
      (\tikztostart) -| ($(\tikztostart)!#1!(\tikztotarget)$) |- (\tikztotarget)
      \tikztonodes
    }
  },
  -|-/.default=0.5,
  |-|/.style={
    to path={
      (\tikztostart) |- ($(\tikztostart)!#1!(\tikztotarget)$) -| (\tikztotarget)
      \tikztonodes
    }
  },
  |-|/.default=0.5,
}

\makeatletter
\newcommand{\achtung}{\tikz\node[inner sep=0pt]{\includegraphics[height=1em]{\lecture@pathprefix{}warning.png}}; Achtung:}
\newcommand{\achtungitem}{\item[{\includegraphics[height=1em]{\lecture@pathprefix{}warning.png}}] Achtung:}
\newcommand{\fehlersymbol}{\includegraphics[height=1em]{\lecture@pathprefix{}error.png}}
\newcommand{\fehler}{\tikz\node[inner sep=0pt]{\fehlersymbol}; Fehler:}
\newcommand{\fehleritem}{\item[{\fehlersymbol}] Fehler:}
\makeatother


\tikzset{
  notepath/.style={orange!20, thick},
  note/.style={fill=orange!20, text=black, inner sep=4pt, rounded corners}
}



\usepackage{tcolorbox}
\definecolor{codebackgroundcolor}{rgb}{1, 1, 1}  % #2d2d2d (dark background)
\definecolor{codelinenocolor}{rgb}{0.18, 0.18, 0.18}           % #ccc (light text)

\usepackage{minted}
\setminted{
  fontsize={\small},
  linenos=true,
  stripall=true,
  breaklines=true,
  autogobble=true,
  xleftmargin=0.5em,
  texcomments,
  escapeinside=~~,
}
\usemintedstyle{paraiso-light
}
% line number style
\renewcommand{\theFancyVerbLine}{\color{codelinenocolor}\tiny\arabic{FancyVerbLine}}

\tcbset{
  codebox/.style={
    enhanced,
    colback=codebackgroundcolor,
    colframe=black,
    width=\linewidth,
    arc=2mm
}}

% Inline code
\tcbset{
    inlinecode/.style={
        on line,
        colback=lightgray,
        colframe=gray,
        boxrule=0pt,
        arc=2pt, % <-- Rounded corners!
        left=2pt, right=2pt, top=1pt, bottom=1pt
    }
}
\newcommand{\inlinecode}[1]{%
    \SaveVerb{#1}§#1§%
    \tcbox[inlinecode]{\UseVerb{#1}}%
}



% Code blocks with highlighting
\newenvironment{code}[1]
{%
\VerbatimEnvironment%
\begin{tcolorbox}[codebox, overlay={
    \node[anchor=south east, text=white] at (frame.south east) {\tiny\MakeUppercase #1};
}]%
\color{white}
\begin{minted}{#1}%
}{%
\end{minted}
\end{tcolorbox}
}

\makeatletter
\NewDocumentCommand{\inputcode}{O{1} O{9999} m m}{%
\begin{tcolorbox}[codebox, overlay={
    \node[anchor=south east, text=white] at (frame.south east) {\tiny\MakeUppercase #3};
    \node[anchor=north east, text=codelinenocolor] at (frame.north east) {\tiny\href{#4}{\detokenize{#4} \includegraphics[height=1em]{\lecture@pathprefix{}external_link}}};
}]%
\color{white}
  \inputminted[
    firstline=#1,
    lastline=#2
  ]{#3}{#4}
\end{tcolorbox}
}

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










% Tikz Anchors inside text or code environments.
\newcommand{\anchor}[1]{\tikz[remember picture]\coordinate (#1);}

% Define custom background for content slides
\newcommand{\custombackground}{
  \begin{tikzpicture}[remember picture, overlay]
    \node[anchor=south west] (uni) at (current page.south west) {\includegraphics[height=1.5em]{\lecture@pathprefix{}logo-uni.pdf}};
    \node[right=0.5em of uni] {\includegraphics[height=1.5em]{\lecture@pathprefix{}fius-logo-neu.png}};
  \end{tikzpicture}
}
\makeatother


\setbeamertemplate{background canvas}{
  \custombackground
}

\setbeamercolor{background canvas}{bg=white} % Default background color
\setbeamercolor{frametitle}{fg=accent}
\setbeamercolor{title}{fg=accent}
\setbeamercolor{section in toc}{fg=accent}  % Accent color for sections in TOC
\setbeamercolor{section in head/foot}{fg=accent}  % Accent color for section in header/footer
\setbeamercolor{itemize item}{fg=accent}
\setbeamercolor{itemize subitem}{fg=accent}
\setbeamercolor{itemize subsubitem}{fg=accent}
\setbeamercolor{enumerate item}{fg=accent}
\setbeamercolor{enumerate subitem}{fg=accent}
\setbeamercolor{enumerate subsubitem}{fg=accent}

\setbeamercolor{hyperlink}{fg=accent}  % Accent color for hyperlinks

\setbeamercolor{block title}{fg=accent}

\setbeamercolor{navigation symbols}{fg=accent}  % Accent color for navigation symbols the title in each frame

\setbeamerfont{title}{size=\huge,series=\bfseries}  % Custom title font
\setbeamerfont{frametitle}{size=\Large,series=\bfseries}  % Custom title font
\setbeamerfont{author}{size=\Large}  % Custom author font

\setbeamertemplate{navigation symbols}{} % Hide navigation symbols at the bottom
%% \setbeamertemplate{blocks}[rounded][shadow=false]
\setbeamertemplate{footline}[frame number] % Show slide numbers in the footer


\BeforeBeginEnvironment{minted}{
  \begin{tcolorbox}[colback=gray!5, colframe=black!80, boxrule=0.5pt, arc=2mm]
}
\AfterEndEnvironment{minted}{
  \end{tcolorbox}
}
