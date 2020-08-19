# Ohjelman rakenne

Projekti on jaettu seuraaviin paketteihin jotka sisältävät tietyn ohjelman osa-alueen.

## Paketit

* `.maze` - Sisältää labyrintin luomiseen, muokkaamiseen sekä sen toimintaan liittyvät luokat.

* `.gui` - Sisältää ohjelman graafisen käyttöliittymän.

* `.solving` - Sisältää ohjelman ratkaisu algoritmin sekä siihen liittyvät luokat.

* `.util` - Sisältää ohjelman tarvitsemat tietorakenteet

* `.testing` - Sisältää ohjelman testaamiseen tarvittavat luokat.

### Maze paketti

* Maze - luo ja hallitsee labyrintin logiikkaa ja opertointia.

* Generate - hallitsee labyrintin generoimista.

* Square - auttaa tallentamaan kaksiuloitteisen listan koordinaatit.

### Gui paketti

* GUI - luo graafisen käyttöliittymän sekä luo, generoi ja ratkaisee Maze luokan joka esitetään käyttäjälle.

### Solving paketti

* WallFollower - Wall follower algoritmi joka etsii ratkaisun annetusta labyrintistä. 

### Util paketti

* SquareList - Itseään kasvattava lista johon voidaan lisätä Square luokan olioita.

* SquareQue - Linkitetty lista joka muodostaa jonon Square luokan olioista, toimii nopeasti kun haetaan listan ensimmäinen tai viimeinen olio.

## Testitulokset

### Yksikkötestaus

Poislukien `cs.helsinki.fi.gui`, kaikki luokat yksikkötestaan JUnit kirjastolla, testit voidaan suorittaa komennolla `mvn test`.

### Tehokkuustestaus

Ohjelman tehokkuutta ei vielä ole testattu.
