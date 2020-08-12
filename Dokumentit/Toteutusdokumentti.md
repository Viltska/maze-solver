# Ohjelman rakenne

Projekti on jaettu kolmeen pakettiin jotka sisältävät jonkin ohjelman osa-alueen.

## Paketit

* `.maze` - Sisältää labyrintin luomiseen ja muokkaamiseen tarvittavat luokat.

* `.gui` - Sisältää ohjelman graafisen käyttöliittymän.

* `.solving` - Sisältää ohjelman ratkaisu algoritmin ja sen toimintaan tarvittavat luokat.

* `.testing` - Sisältää ohjelman testaamiseen tarvittavat luokat.

### Maze paketti
Sisältää seuraavat luokat

* Maze - luo ja hallitsee labyrintin logiikkaa ja opertointia.

* Generate - hallitsee labyrintin generoimista.

* Square - auttaa tallentamaan kaksiuloitteisen listan koordinaatit.

### Gui paketti
Sisältää luokan

* GUI - luo graafisen käyttöliittymän sekä luo, generoi ja ratkaisee Maze luokan joka esitetään käyttäjälle.

### Solving paketti
Sisältää seuraavat luokat

* WallFollower - Wall follower algoritmi joka etsii ratkaisun annetusta labyrintistä. 

## Testitulokset

Poislukien `cs.helsinki.fi.gui`, kaikki paketit ja luokat yksikkötestaan JUnit kirjastolla.
Ohjelman tehokkuutta ei ole vielä testattu.
