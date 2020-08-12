# Määrittelydokumentti

## Tavoite

Ohjelman tarkoituksena on labyrintin generoiminen ja sen ratkaiseminen, sekä ratkaisun esittäminen käyttäjälle graafisen käyttöliittymän avulla. Tavoitteena on löytää tehokkaasti jokin ratkaisu labyrintille.

## Käytety tietorakenteet

Labyrinti mallinnetaan kaksiuloitteisella listalla jossa kokonaisluvut kuvaavat seinää, polkua, lähtöruutua, ulospääsyä sekä kuljettua reittiä. Lisäksi käytety algoritmeille luodaan pino sekä lista tietorakenteet joilla korvataan Java-kirjaston omat iteraatiot.

## Labyrintin generoiminen

Labyrinti generoidaan rekursiivisesti DFS-algoritmilla joka luo reittiä kunnes törmää kohtaan jossa ei ole mahdollista edetä, kuten kulmaan tai jo luotuun reittiin. Algoritmin reitti lisätään pinoon josta valitaan seuraava kohta josta reittiä voidaan jatkaa. Generoitu labyrintti on *simply connected* eli sen jokaisesta kohdasta on mahdollista liikkua kaikkiin jäljellä oleviin kohtiin.

## Ratkaisu

Koska labyrinti on yksinkertaisesti yhdistetty pystyy sen ratkaisemaan kääntymällä aina tiettyyn suuntaan risteyksessä. Esimerkkinä ihminen joka pitää kättään aina labyrintin oikeassa seinässä kiinni kulkiessaan labyrintin läpi löytää lopulta ulospääsyn. Ratkaisu on niin sanottu Wall follower-algoritmi, joka käyttää mainittua logiikkaa ratkaisun löytämiseksi. 

## Aika ja tilavaatimukset

Aika vaatimus ratkaisun löytämiselle **O(n)**, **n** = (korkeus x leveys). Algoritmi joutuu pahimmassa tapauksessa tarkistamaan jokaisen kohdan labyrintin sisällä.
Algoritmin tilavaatimus on sama kuin aikavaatimus, eli **O(n)** koska pahimmassa tapauksessa muistiin joudutaan tallentamaan jokainen labyrintin kohdan.

