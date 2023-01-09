### Kata10: http://codekata.com/kata/kata10-hashes-vs-classes/

30 tabla - 100 oszlop tablankent es kellenenek aggregalt adatok is.

Class megkozelites:
Minden egy objektum. Ha aggregalt adat kell esetleg akkor vegig kell menni az 
osszes objektum azonosos fieldjen. Csak parszor kell lenyulni az adatbazisba.
Heap esetleg megtelhet , ha sok objektummal dolgozunk/tarolunk.

Heap:
Adatbazis optimalizalva van aggregalt lekerdezesekre. Tobbszor kell 
lenyulni az adatbazisba -> Nem eroforrasbarat.
Azonos objektumokat optimalisabban tarolja. 
Gyorsab a kereses egy HashMap-nem, mint mondjuk egy List-ben.
