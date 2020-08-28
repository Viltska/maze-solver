# Ohjelman rakenne

Projekti on jaettu seuraaviin paketteihin jotka sisältävät tietyn ohjelman osa-alueen.

## Paketit

* `.maze` - Sisältää labyrintin luomiseen, muokkaamiseen sekä sen toimintaan liittyvät luokat.

* `.gui` - Sisältää ohjelman graafisen käyttöliittymän.

* `.solving` - Sisältää ohjelman ratkaisu algoritmin sekä siihen liittyvät luokat.

* `.util` - Sisältää ohjelman tarvitsemat tietorakenteet

* `.testing` - Sisältää ohjelman testaamiseen tarvittavat luokat.

### Maze

* Maze - luo ja hallitsee labyrintin logiikkaa ja opertointia.

* Generate - hallitsee labyrintin generoimista.

* Square - auttaa tallentamaan kaksiuloitteisen listan koordinaatit.

### Gui
* GUI - luo graafisen käyttöliittymän sekä luo, generoi ja ratkaisee Maze luokan joka esitetään käyttäjälle.

### Solving

* WallFollower - Wall follower algoritmi joka etsii ratkaisun annetusta labyrintistä. 

* Direction - Enum joka tallentaa WallFollower-luokan tarvitsemat suunnat (UP, DOWN , LEFT, RIGHT).

### Util

* SquareList - Itseään kasvattava lista johon voidaan lisätä Square luokan olioita.

* SquareQue - Linkitetty lista joka muodostaa jonon Square luokan olioista, toimii nopeasti kun haetaan listan ensimmäinen tai viimeinen olio.

* RandomGenerator - Generoi satunnaisia lukuja.

* Timer - Luokka joka tallentaa käytettyä aikaa tietyn ohjelman kohdan suorittamiseen.

* PerformanceTester - Testaa algoritmien ja tietorakenteiden tehokkuutta.

## Testaus

### Yksikkötestaus

Poislukien `cs.helsinki.fi.gui` ja `PerformanceTester`, kaikki luokat yksikkötestaan JUnit kirjastolla, testit voidaan suorittaa komennolla `mvn test`.

### Tehokkuustestaus

Ohjelman tehokkuutta testataan `PerformanceTester` luokan avulla, tarkempaa tietoa testaus dokumentissa.
