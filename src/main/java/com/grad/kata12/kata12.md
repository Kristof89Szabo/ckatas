### Kata12: http://codekata.com/kata/kata12-best-sellers/

Best selling - Legtobb eladott darabszam

List being updated each hour implementacio:
Ha minden oraban ujraszamolnank mi a top10 product akkor egy amazon meretu cegnel hatalmas terhet rakna a
serverre/adatbazisra ugyan ez a helyzet a real time list updatnel is(X millioan raszabadulnak a fooldalra).

Egy sceduled task-al letarolnam egy FIFO queue-ba minden oraba eladott mondjuk top1000 termeket es annak darabszamat.
Igy uj lekerdezesnel 2 szamolas kell. A first ora es last ora alapjan modositani ezt a top10-et.

Only update the list once per day:

Egy kapcsolo tablaba raknam a product ID-t es egy quantity oszlopot. Ahanyszor vesznek ebbol a termekbol novelnem
a quantity-t egyel. Igy naponta egyszer kellene leszurni a top 10et, ha ez megvan akkor utana lehet a quantity oszlopot
0-ra allitani 
