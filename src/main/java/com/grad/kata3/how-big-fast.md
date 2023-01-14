# Kata03: 
## How Big?

## **1.**

| Megnevezés | Jelölés   | Értéke átváltva                                      |
|------------|-----------|------------------------------------------------------|
| bit        | b         | a legkisebb érték, amely nullát vagy egyet vehet fel |
| byte       | B         | 8 bit                                                |
| kilobit    | KBit / Kb | 1024 bit                                             |
| kilobyte   | KB        | 1024 byte                                            |


1.000 = 2 ** 10: 1024 = **10**

1.000.000: (2 ** 10) * (2  ** 10) = **20**

1.000.000.000: (2 ** 10) * (2  ** 10) * (2 ** 10) = **30**

## **2.**

- Average name length: 30
- Address: 100
- Phone: 20

150 character * 2 byte = 300 byte

20000 * 300 = 6.000.000 byte = around 6000 kilobit = 6 MB

## **3.**

Level szamitas:
https://www.baeldung.com/cs/binary-tree-number-of-nodes-level

## How Fast?

## **1.**

1 byte = 8 bit

A4 page-re kb 2500 karaktert lehet irni stadard 11-es betumerettel.

2500 * 2 byte = 5000 byte
1200 oldal * 5000 = 6.000.000 byte = 6MB

56k baud modem can download 56kb de feltoltes csak 33.6kb/s:
33600 bits/sec / 8bits/byte = 4200 byte/sec

6.000.000 byte / 4200 byte/sec = 1428.57 sec = 23 perc es 80 masodperc

[Calculator](https://www.meridianoutpost.com/resources/etools/calculators/calculator-file-download-time.php)

## **2.**

//TODO

## **3.**

16 hosszu password. 96 lehetseges karakter. 1 ms to check the generated password.

16 ^ 96 = 3.9402E115 cobinations number. //6,634,204,312,890,625 combination -> 210 ev

This is not good approach to crack a password.

