### Kata10: http://codekata.com/kata/kata10-hashes-vs-classes/

30 tabla - 100 oszlop tablankent es kellenenek aggregalt adatok is.

Class megkozelites:
Minden egy objektum. Ha aggregalt adat kell esetleg akkor vegig kell menni az
osszes objektum azonosos fieldjen. Csak parszor kell lenyulni az adatbazisba.
Heap esetleg megtelhet , ha sok objektummal dolgozunk/tarolunk.
Merevebb struktura, uj class-t kell letrehozni, ha valtozik a kivant adat.
Konnyebb tesztelhetoseg.

Hash:
Adatbazis optimalizalva van aggregalt lekerdezesekre. Tobbszor kell
lenyulni az adatbazisba -> Nem eroforrasbarat.
Nem kell minden fieldet felhuzni az adatbazisbol -> java oldalon kevesebb eroforras.
