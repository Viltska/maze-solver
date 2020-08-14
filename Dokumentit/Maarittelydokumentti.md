# Määrittelydokumentti

## Tavoite

Ohjelman tarkoituksena on labyrintin generoiminen ja sen ratkaiseminen ilman täydellistä tietoa labyrintistä, sekä ratkaisun esittäminen käyttäjälle graafisen käyttöliittymän avulla. Tavoitteena on löytää tehokkaasti jokin ratkaisu labyrintille.

## Käytety tietorakenteet

Ohjelman tavoitteena on luoda kaikki tietorakenteet ilman ulkoisia kirjastoja kuten Javan kirjastoa.
Labyrinti mallinnetaan kaksiuloitteisella listalla jossa kokonaisluvut kuvaavat seinää, polkua, lähtöruutua, ulospääsyä sekä kuljettua reittiä. Lisäksi käytetyille algoritmeille luodaan pino- sekä lista-tietorakenteet jotka korvaavat Java kirjaston vastaavat tietorakenteet.

## Labyrintin generoiminen

Labyrinti generoidaan rekursiivisesti DFS-algoritmilla joka luo reittiä kunnes törmää kohtaan jossa ei ole mahdollista edetä, kuten kulmaan tai jo luotuun reittiin. Algoritmin reitti lisätään pinoon josta valitaan viimeisin kohta josta reittiä voidaan jatkaa. Koska generointia jatketaan aina aikaisemmasta polusta on luotu labyrintti *simply connected*, eli sen jokaisesta kohdasta on mahdollista liikkua jokaiseen jälellä olevaan kohtaan.

## Ratkaisu

Koska labyrinti on yksinkertaisesti yhdistetty pystyy sen ratkaisemaan kääntymällä aina tiettyyn suuntaan risteyksessä. Esimerkkinä ihminen joka pitää kättään aina labyrintin oikeassa seinässä kiinni kulkiessaan labyrintin läpi löytää lopulta ulospääsyn. Ratkaisu on niin sanottu Wall follower-algoritmi, joka käyttää mainittua logiikkaa ratkaisun löytämiseksi. 

## Aika ja tilavaatimukset

Aika vaatimus ratkaisun löytämiselle **O(n)**, **n** = (korkeus x leveys). Algoritmi joutuu pahimmassa tapauksessa tarkistamaan jokaisen kohdan labyrintin sisällä.
Muistivaatimus algoritmille on **O(1)** sillä algoritmi tarvitsee toimiakseen tiedon vain ympäröivistä kohdista.
