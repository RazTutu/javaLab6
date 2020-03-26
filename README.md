# javaLab6
Tutuianu Razvan Constantin B5
Link youtube demo: https://www.youtube.com/watch?v=U61WovTfEN4&feature=youtu.be

Pentru acest laborator am folosit Swing. Am ales sa desenez figurile cu o opacitate
de 0.5, pentru a se vedea putin transparent. Am vrut sa pot desena peste o imagine pe care o iau din load si sa se vada si imaginea in spate.

Probleme avute:
butonul load - nu reuseam sa incarc o poza din PC in interfata grafica, pentru ca
nu reuseam sa pun un BufferedImage pe grafic.
Dar am rezolvat, folosind comanda frame.canvas.graphics.
De asemenea, trebuia sa apas un click pe canvas ca sa apara poza din load. Aceasta problema a fost rezolvata adaugand in plus frame.repaint() in metoda load.
