TEX_DEPS_COMMON = $(wildcard *.tex)
TEX_INPUTS = $(wildcard src/Day*/exercise/sheet.tex)
EXERCISE_OUTPUTS = $(TEX_INPUTS:.tex=.pdf)
PRESENTATION_OUTPUTS = $(subst exercise/sheet,presentation/slides,$(EXERCISE_OUTPUTS))

#DAYS = $(wildcard */)
DAYS = $(subst /,,$(subst src/,,$(sort $(dir $(wildcard src/Day*/)))))
CLEAN_DAYS = $(addprefix clean/,$(subst /,,$(subst src/,,$(sort $(dir $(wildcard src/Day*/))))))



TYPES= exercise presentation
#$(foreach var,$(DAYS),cd scr/$(var)/exercise; latexmk -c sheet.tex;)

all: build-exercise rushb
	make clean



build-exercise: $(EXERCISE_OUTPUTS)

build-slides: $(PRESENTATION_OUTPUTS)
	
.SECONDEXPANSION:

clean: $(CLEAN_DAYS)	


cleanall: clean
	$(foreach var,$(DAYS),rm -f src/$(var)/exercise/$(var).pdf; rm -rf src/$(var)/exercise/_minted*;)
	$(foreach var,$(DAYS),rm -f src/$(var)/presentation/$(var).pdf; rm -rf src/$(var)/presentation/_minted*;)

	


%exercise/sheet.pdf: $$(@D)/*.tex $(TEX_DEPS_COMMON)
	cd $(@D) && latexmk -pdf -shell-escape -jobname=$(subst /exercise/sheet.pdf,,$(subst src/,,$(@)))-sheet sheet.tex



%presentation/slides.pdf: $$(@D)/*.tex $(TEX_DEPS_COMMON)
	cd $(@D) && latexmk -pdf -shell-escape -jobname=$(subst /presentation/slides.pdf,,$(subst src/,,$(@)))-slides slides.tex

clean/Day%:
	rm -f $(filter-out src/$(@F)/exercise/$(@F).pdf ,$(wildcard src/$(@F)/exercise/$(@F)-sheet.*));
	rm -f $(filter-out src/$(@F)/presentation/$(@F).pdf ,$(wildcard src/$(@F)/presentation/$(@F)-slides.*))


Day%: 
	make exercise/$(@) presentation/$(@)
	 


exercise/Day%:
	cd src/$(@F)/exercise/; latexmk -pdf -shell-escape -jobname=$(@F)-sheet sheet.tex;


presentation/Day%:
	cd src/$(@F)/presentation/; latexmk -pdf -shell-escape -jobname=$(@F)-slides -interaction=nonstopmode slides.tex;

rushb:
	$(foreach day, $(DAYS), cd src/$(day)/presentation && latexmk -pdf -shell-escape -interaction=nonstopmode -jobname=$(day)-slides slides.tex; cd ../../..;)




