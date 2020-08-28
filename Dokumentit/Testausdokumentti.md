# Ohjelman testit

## Yksikkötestaus

Ohjelma käyttää yksikkötestaukseen JUnit-kirjastoa. Testien tulokset ja raportit ilmestyvät projektikansioon `/target`, jossa niitä voidaan tarkastella

## JUnit - Yksikkötestaus

JUnit testis voidaan suorittaa komennolla `mvn test`. **HUOM** raporttien luomiseksi täytyy tämä komento suorittaa ensiksi.

`/target` kansio voidaan poistaa komennolla `mvn clean`.


### Jacoco - Testikattavuus

Testikattavuus voidaan tarkistaa Jacoco-raportilla joka voidaan luoda komennolla `mvn jacoco:report`.

`/target` kansioon ilmestyy `/site` kansio josta voidaan tarkastella testikattavuutta, tiedosto `index.html` kertoo koko ohjelman kattavuudesta.

### Checkstyle - Koodin tyyli

Checkstyle raportti voidaan luoda komennolla `mvn checkstyle:checkstyle`, jonka jälkeen `/target/site` kansioon ilmestyy tiedosto `checkstyle.html`, tästä nähdään koodissa olevia puutteita tai rikkeitä konventiossa.

## Tehokkuustestaus

Ohjelman tehokkuustestit kattavat ohjelman käyttämät Algoritmit ja algoritmien käyttämät tietorakenteet. Näihin kuuluvat siis `WallFollower` luokan metodit `solve()` ja `solveRecursive` sekä tietorakenne luokka `SquareQue`.