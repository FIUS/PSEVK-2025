TEX_DEPS_COMMON = $(wildcard *.tex)
TEX_INPUTS = $(wildcard src/Day*/exercise/sheet.tex)
EXERCISE_OUTPUTS = $(TEX_INPUTS:.tex=.pdf)
PRESENTATION_OUTPUTS = $(subst exercise/sheet,presentation/slides,$(EXERCISE_OUTPUTS))

#DAYS = $(wildcard */)
DAYS = $(subst /,,$(subst src/,,$(sort $(dir $(wildcard src/Day*/)))))

TYPES= exercise presentation
#$(foreach var,$(DAYS),cd scr/$(var)/exercise; latexmk -c sheet.tex;)

all: build-exercise rushb
	make clean



build-exercise: $(EXERCISE_OUTPUTS)

build-slides: $(PRESENTATION_OUTPUTS)
	
.SECONDEXPANSION:

clean: $(DAYS)	
cleanall: clean
	$(foreach var,$(DAYS),rm -f src/$(var)/exercise/$(var).pdf; rm -rf src/$(var)/exercise/_minted*;)
	$(foreach var,$(DAYS),rm -f src/$(var)/presentation/$(var).pdf; rm -rf src/$(var)/exercise/_minted*;)

	


%exercise/sheet.pdf: $$(@D)/*.tex $(TEX_DEPS_COMMON)
	cd $(@D) && latexmk -pdf -shell-escape -jobname=$(subst /exercise/sheet.pdf,,$(subst src/,,$(@)))-sheet sheet.tex



%presentation/slides.pdf: $$(@D)/*.tex $(TEX_DEPS_COMMON)
	echo cd $(@D)  latexmk -pdf -shell-escape -jobname=$(subst /presentation/slides.pdf,,$(subst src/,,$(@)))-slides slides.tex
	cd $(@D) && latexmk -pdf -shell-escape -jobname=$(subst /presentation/slides.pdf,,$(subst src/,,$(@)))-slides slides.tex

Day%:
	rm -f $(filter-out src/$(@)/exercise/$(@).pdf ,$(wildcard src/$(@)/exercise/$(@)-sheet.*));
	rm -f $(filter-out src/$(@)/presentation/$(@).pdf ,$(wildcard src/$(@)/presentation/$(@)-slides.*))


rushb:
	$(foreach day, $(DAYS), cd src/$(day)/presentation && latexmk -pdf -shell-escape -interaction=nonstopmode -jobname=$(day)-slides slides.tex; cd ../../..;)





test:
	echo Smth $(TEX_DEPS_COMMON)
	echo Inputs $(TEX_INPUTS)
	echo $(EXERCISE_OUTPUTS)
	echo $(TEX_files)
	echo slides $(PRESENTATION_OUTPUTS)