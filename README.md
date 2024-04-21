# Detyra e dytë nga lënda "Siguri e të Dhënave"

Në këtë repository gjeni implementimin e algoritmeve:
- Playfair Cipher (Substitution)
- 'Myszkowski Cipher (Transposition)

## Parakushtet

- Java Development Kit (JDK) të instaluar në sistemin tuaj
- Një IDE të përshtatshme të instaluar në kompjuterin tuaj

## Për fillim

1. **Clone the repository**:

   ```bash
   git clone https://github.com/lumii06/GR10_DataSecurity_Det2.git
2. **Navigoni për në direktoriumin e projektit**:

```bash
   cd GR10_DataSecurity_Det2
```
3. **Duke përdorur IDE tuaj egzekutoni algoritmin e dëshiruar duke bërë run**:

# Playfair Cipher:

Playfair cipher është algoritëm substituimi, i cili përor matricë të rendit 5x5. Ka logjikën e enkriptimit simetrik polialfabetik!
## Hapat që duhet ndërmarrë janë:
1. Krijoni keyword
2. Vendosni keyword në matricën 5x5
3. Plotësoni hapësirat e mbetura të matricës në rend alfabetik A-Z, duke mos i përsëritur shkronjat nga keyword (alfabeti duhet të jetë i formatit 26 shlronjësh pra të gjuhës Angleze)
4. Merrni Plaintext-in dhe ndajeni në diagrame me nga dy karaktere (relacionet e këtyre karaktereve në matricë tregojnë rregullat e enkriptimit)
5. Në qoftë se një diagram i caktuar përbëhet nga karaktere të njejta atëher duhet shtuar një karakter X si placeholder që të mos egzistojnë diagramet me karaktere të njejta.
   ### Rregullat e enkriptimit
   (Marrim XY si diagram shembull)
   Në qoftë se X dhe Y
      - Janë në të njejën kolonë => zëvendësojmë X me karakterin &darr; (poshtë) tij dhe Y ngjashëm.
      - Janë në të njejtin rresht => zëvendësojmë X me karakterin &rarr; (djathtas) tij dhe Y ngjashëm.
      - Krijojnë drejtëkëndësh => zëvendësojmë X me karakterin &rarr; (djathtas) tij në kufij të drejtëkëndëshit dhe Y me karakterin &larr; (majtas) tij në kufij të drejtëkëndëshit.
  * *Vëmendje: matrica është ciklike (në qoftë se karakteri X gjendet në kufij të matricës, ai zëvendësohet me karakterin në kufirin e kundërt në varësi të rastit).*
## Shembull i egzekutimit 
<img src="Images/playfair.png" alt="Playfair Cipher excecution" width="500">

# Myszkowski  Cipher:

Myszkowski Transposition Cipher është një transposition cipher që përdoret për të enkriptuar tekstin e thjeshtë duke riorganizuar renditjen e shkronjave të tij.
Ai është emërtuar sipas krijuesit të tij, Émile Victor Théodore Myszkowski.

**Procesi i Enkriptimit të Myszkowski Transposition Cipher:**

- Zgjedhim keyword-in  : "CRACKING".
- Shkruajmë keyword-in në krye të një tabele.
- Vendosim numrat në tabelë ndër secilin karakter në bazë të rendit të shkronjave në keyword.

| C | R | A | C | K | I | N | G |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 2 | 7 | 1 | 2 | 5 | 4 | 6 | 3 |
- Shkruajmë mesazhin plaintext në rreshta nën kolonat e numëruara. Celulat që ,besin të zbrazta i mbushim me X në ketë rast.

| C | R | A | C | K | I | N | G |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 2 | 7 | 1 | 2 | 5 | 4 | 6 | 3 |
| C | R | A | C | K | I | N | G |
| C | O | D | E | I | S | S | U |
| P | E | R | F | U | N | X | X |
- Riorganizojmë kolonat e tabelës sipas rendit të numrave në keyword.

| 1 | 2 | 2 | 3 | 4 | 5 | 6 | 7 |
| --- | --- | --- | --- | --- | --- | --- | --- |
| A | C | C | G | I | K | N | R |
| D | C | E | U | S | I | S | O |
| R | P | F | X | N | U | X | E |
- Lexojmë kolonat e tabelës nga majtas-djathtas për të marrë ciphertext-in, i cili në këtë rast do të jetë:    ADRCCCEPFGUXISNKIUNSXROE .

**Procesi i Dekriptimit të Myszkowski Transposition Cipher:**

- Zgjedhim të njëjtin keyword të përdorur në procesin e enkriptimit:  "CRACKING".
- Shkruajmë keyword-in në krye të tabelës.
- Vendosim numrat në tabelë ndër secilin karakter në bazë të rendit të shkronjave në keyword.

| C | R | A | C | K | I | N | G |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 2 | 7 | 1 | 2 | 5 | 4 | 6 | 3 |
- Shkruani ciphertext-in në rreshta sipas kolonave të numëruara.

Ciphertext-i ynë është: ADRCCCEPFGUXISNKIUNSXROE.   

Meqenëse kemi 24 shkronja në ciphertext dhe keyword-i ka 8 shkronja, pjestojmë 24 me 8, që na jep 3 rreshta: ADR, CCC, EPF, GUX, ISN, KIU, NSX, ROE.

- Shkruajmë ciphertext-in në kolona duke sipas renditjes së keyword-it:

| 2 | 7 | 1 | 2 | 5 | 4 | 6 | 3 |
| --- | --- | --- | --- | --- | --- | --- | --- |
| C | R | A | C | K | I | N | G |
| C | O | D | E | I | S | S | U |
| P | E | R | F | U | N | X | X |

- Lexonjmë rreshtat tablës nga majtas-djathtas dhe fitojmë plaintext-in: CRACKING CODE IS SUPER FUN.

# Anëtarët e grupit
- Lum Hoxha
- Lura Gashi
- Lyra Bullaku
- Lorik Agaj






