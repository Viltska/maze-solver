# Viikko 5

Aikaa käytetty 18 tuntia.

## Tehty

* Luotu GUI valikko ohjelmalle.

* While-loop toeutus algoritmista.

* Luotu omat toteutukset korvaamaan ArrayList ja ArrayDequeue tietorakenteita.

## Ohjelman edistyminen

* Edellämainitut lisäykset

* Testikattavuuden lisäys

* Luotu paketti .util jossa omat List- sekä Queue-tietorakenteet

## Viikolla opittua

* LinkedList ja itseään suurentava List tietorakenteiden toteutusta ja testailua


## Seuraavaksi

* Ohjelman ydintoiminnan tehokkuuden parantaminen

* Tehokkuustestaus

## Ongelmia ja kysymyksiä

* While-loop toteutus ratkaisee käytännössä rajoittamaton kokoisen labyrintin. Rekursiivinen ratkaisu aiheuttaa ongelmia joita en osaa ratkaista, olen kuitenkin tyytyväinen while-loop ratkaisuun. Kiinnostaisi tietää mistä ongelma johtuu ja mikä sen aiheuttaa. **Alhaalla koodipätkä liittyen tähän**

* Onko tämänhetkinen toeutus ydintoiminta riittävä?

* Onko Random luokan korvaaminen pakollista? Käytössä vain lukujen 1-4 väliltä valintaan eikä liity ohjelman ydintoimintaan, olisiko `ThreadLocalRandom`:ia käyttävä korvaus riittävä?

#### Metodi joka aiheuttaa StackOverflowErroria, jos silmään osuu jotain

<code>
    
    public SquareList move(Square pos, Direction dir, SquareList path) {
        if (maze.reachedFinish(pos)) {
            path.add(pos);
            return path;
        }

        if (canMove(pos, getDirectionToRight(dir))) {
            Direction newDir = getDirectionToRight(dir);
            Square right = getSquareInDirection(pos, newDir);
            path.add(right);
            return move(right, newDir, path);

        } else if (canMove(pos, dir)) {
            Square forward = getSquareInDirection(pos, dir);
            path.add(forward);
            return move(forward, dir, path);

        } else if (canMove(pos, getDirectionToLeft(dir))) {
            Direction newDir = getDirectionToLeft(dir);
            Square left = getSquareInDirection(pos, newDir);
            path.add(left);
            return move(left, newDir, path);

        } else {
            Square back = getSquareInDirection(pos, reverse(dir));
            return move(back, reverse(dir), path);
        }
    }
    
</code>
