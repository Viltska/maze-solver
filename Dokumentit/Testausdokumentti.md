# Ohjelman Testaus

Testit on jaettu tehokkuus- ja yksikkötesteihin, tehokkuustestit mittaavat ohjelman algoritmin ja tietorakenteiden tehokkuutta. Yksikkötestit testaavat ohjelman luokkie ja metodien toimintaa.

## Tehokkuustestit

Tehokkustestaus kattaa luokat `Generate`, `WallFollower` ja `SquareQueue`. Testit voidaan suorittaa paikallisesti suorittamalla ohjelma argumentilla test, tällöin testit suoritetaan peräkkäin joten tulokset voivat vaihdella.

### Algoritmit

Testit suoritetaan  kymmenen kertaa per koko, jonka jälkeen kirjataan testien käyttämän ajan keskiarvo.

### Labyrintin generoiminen

Labyrintin generoiminen tapahtuu DFS-algoritmin avulla joka käyttää SquareQueue tietrakennetta.

| Labyrintin koko | Aika       |
| :---            | ---:       |
| 100 x 100       | 35 ms.     |
| 200 x 200       | 40 ms.     |
| 300 x 300       | 43 ms.     |
| 500 x 500       | 95 ms.     |
| 800 x 800       | 215 ms.    |
| 1 000 x 1 000   | 240 ms.    |
| 2 000 x 2 000   | 260 ms.    |

Generointialgoritmin aikavaatimus on lineaarinen O(n).

### Labyrintin ratkaisu

Wall Follower ratkaisualgoritmi. Mittaustulokset vaihtelevat riippuen tietokoneen tehokkuudesta sekä Javalle sallitun muistin määrästä.

| Labyrintin koko | Aika      |
| :---            | ---:      |
| 100 x 100       | 1 ms.     |
| 200 x 200       | 1 ms.     |
| 300 x 300       | 3 ms.     |
| 500 x 500       | 5 ms.     |
| 800 x 800       | 10 ms.    |
| 1 000 x 1 000   | 15 ms.    |
| 2 000 x 2 000   | 20 ms.    |

Aikavaatimuksen määritelmä kun n = tarkastettavien ruutujen määrä. N voidaan määritellä kaavalla leveys x korkeus / 2, määrä puolitetaan sillä otetaan huomioon labyrintin seinämät joita algoritmin ei tarvitse tarkastella.

Määritelmää käyttäen algoritmin aikavaatimus on lineaarinen O(n). 

### Tietorakenteet

  `SquareQueue on` lukka on jono tietorakenne josta voidaan tehokkaasti ottaa jonon ensimmäinen, sekä lisätä olio jono perälle.
  
  * 10 miljoonaa lisäystä sekunnissa.
  
  * 100 miljoonaa poistoa sekunnissa.

## Koodin testaaminen

Testiraportit ilmestyvät /target kansioon, josta tuloksia voidaan tarkastella /site kansion html tiedostojen avulla.

### JUnit - Yksikkötestaus

JUnit testit voidaan suorittaa komennolla `mvn test`.

Testitulokset ja raportit voidaan poistaa komennolla `mvn clean`.

### Jacoco - Testikattavuus

Testikattavuus voidaan tarkistaa Jacoco liitännäisen luoman raportin avulla, raportti luodaan komennolla `mvn jacoco:report`.

Tämän jälkeen /target kansioon ilmestyy kansio /site josta  nähdään ohjelman  yksikköstestauksen kattavuutta (index.html).

### Checkstyle - Tyyliraportti

Checkstyle raportti voidaan luoda komennolla `mvn checkstyle:checkstyle`. Koodin tyyliraportti ja mahdolliset virheet ilmestyvät tiedostoon (checkstyle.html), 
