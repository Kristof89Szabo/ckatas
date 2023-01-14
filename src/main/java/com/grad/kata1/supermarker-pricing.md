# Kata01: Supermarket Pricing


### Bab konzerv eladasi ara: 1 dollar(100 cents)

Felmerulo kerdesek:
- Mennyi a beszerzesi ar?
- Mennyit szeretnenk rajta keresni?
- Egyeb koltsegek vannak-e (tarolasi hely berlese, aru Abol Bbe valo eljuttatasa[Kina-Usa])
- Minimum haszonkulcs?
- Haszonkulcs eltero termektipusonkent(alkohol, udito, konzerv, pekaru)
  vagy aru cikkenkent (ketchup, mustar vagy majonez mind kapjon -e kulonbozo haszonkulcsot?
- Kulonbozo strategiak? Pl.: 
  - 2-t fizet 3-at vihet 
  - 4 eseten a legolcsobb ingyen.

---


### Basic rule: **_house never loses_**

Netto haszonkulcs szamitas:
Arbevetel - ertekesitett aru koltsege( es egyeb koltsegek, ado stbstb).

Pl.:
8000 forintért szerezed be a termékeket, de 10000 forintért adod tovább, a további költségek pedig összesen 1000 forintot tesznek ki. 
A nettó nyereséged 1000 forint, ezt osztod el a teljes bevétellel, majd szorzod meg százzal. Ebből kijön a nettó haszonkulcs, ami most 10%.

A feladat megoladasa kozben szeretnem tartani ezt a 10%-t es, ha esetleg tortenik valami a vilagban akkor ebbol meg mindig lehet engedni.

Bab konzerv magaban: 
- Bab konzerv beszerzesi ara: 0.78
- Haszonkulcs fuggvenye.
- Egyeb koltsegkent tegyuk fel, hogy a szallitas 12 cent. (Why not?!)
- Minimum Haszonkulcs Netto 10%
- A gyorsabb ataraz erdekeben termektipusonkent valasztanam szet. Pl.:
  - Alkohol 15%, Alapveto elelmiszerek 10%, Edessegek: 12% stbstb.

### **Szamitas:** (Az ado nem kerult szamitasra az alabbi egyenletben)
| Beszerzes | 0.60 |
|-----------|------|
| Koltseg   | 0.12 |
| Eladas    | 90   |
| Nyereseg  | 0.18 |

0.18(nyereseg) : 90(eladas) = 0.002

0.002 * 100 = 0.2 :  **20% haszonkulcs.**

---
2L Kola:

| Beszerzes | 350 |
| ----------- | ----------- |
| Koltseg | 46 |
| Eladas | 430 |
| Nyereseg | 34 |

34 / 430 = 0.079

0.079 * 100 = 7.9 ->
Nem felel meg a minimum kituzott 10%-os haszonkulcsnak. Az eladasi arat kell novelni / koltsegeket faragni / beszerzesi
arat faragni.

### Kulonbozo strategiak

Meg kell vizsgalnunk, hogy a kulonbozo akciok reven a kituzott 10%-os haszonkulcs elvesztese megterul-e esetleg, ha a
vasarlo mas termekeket is megvesz
ami nem akcios.

[Remek cikk](https://gremmedia.hu/legjobb-arkepzesi-modszerek-es-strategiak)

### Kerekites

Nem hiszem, hogy letezik, ha penzrol beszelunk. Akar 1 cent is hosszu evek alatt sok sok millio minuszt jelenthetnek.
Hasznaljuk BigDecimal, BigInteger osztalyokat.

A költség és ár nem ugyan az.
Koltsegnek nevezzuk minden olyan penzmozgast ami negativan hat a ceg penz balancara. -> Aru beszerzesi ara, szalitas,
fizetesek stbstb.
Ar: Egy termek ara a koltseges es a netto profit egyuttese.
