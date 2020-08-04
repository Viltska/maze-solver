## Testaus

Ohjelma käyttää yksikötestaukseen JUnit kirjastoa. Testien tulokset ja raportit ilmestyvät projektikansioon /target, jossa niitä voidaan tarkastella

## JUnit

JUnit testis voidaan suorittaa komennolla `mvn test`. **HUOM** raporttien luomiseksi täytyy tämä komento suorittaa ensiksi.

/target kansio voidaan poistaa komennolla `mvn clean`.


### Testikattavuus -Jacoco

Testikattavuus voidaan tarkistaa Jacoco-raportilla joka voidaan luoda komennolla `mvn jacoco:report`.

/target kansioon ilmestyy /site kansio josta voidaan tarkastella testikattavuutta, tiedosto index.html kertoo koko ohjelman kattavuudesta.

### Checkstyle

Checkstyle raportti voidaan luoda komennolla `mvn checkstyle:checkstyle`, jonka jälkeen /target/site kansioon ilmestyy tiedosto checkstyle.html, tästä nähdään onko koodissa puutteita tai rikkeitä konventiossa.
