# Käyttöohje

## Maven

Ohjelma käyttää [Maven](https://maven.apache.org/) projektinhallintaa, joka täytyy olla asennettuna ohjelman ja testien suorittamiseksi.

## Komennot

Maven komennot täytyy suorittaa kansiossa jossa sijaitsee POM.xml tiedosto.

Projekti voidaan rakentaa ja riippuvudet ladata komennolla `mvn build`.

### Suorittaminen

Ohjelma voidaan paketoida ja käynnistää käyttäen Mavenia komennolla `mvn package` jonka jälkeen /target kansioon ilmestyy suoritettava .jar tiedosto jolla ohjelma voidaan suorittaa.

Ohjelman voi myös suorittaa ilman paketointia komennolla `mvn compile exec:java -Dexec.mainClass=cs.helsinki.fi.App`.

## Syötteet

Käyttäjä voi valita minkä kokoisen labyrintin ohjelma ratkaisee sekä käytetäänkö rekursiivista vai while-loop ratkaisua.

### Koko taulukko 

Rekursiivinen koko, While-loop koko.

* Small - 20 x 20 ja 40 x 40

* Medium - 40 x 40 ja 80 x 80

* Large - 80 x 80 ja 2000 x 1000

### Rekursiivinen tai While-loop

* Rekursiivinen ratkaisulla on tällä hetkellä huono optimointi suurilla kutsuilla joten se on rajoitettu opertoimaan alle 100x100 kokoisilla taulukoilla.

* While-loop ratkaisu ei aiheuta ongelmia muistin suhteen joten sillä voidaan ratkaista suurempiakin taulukoita. Valittaessa vaihtoehdot `Large` sekä While-loop ohjelma ratkaisee 2000x1000 kokoisen taulukon, tämä voi kestää riippuen tietokoneen tehosta.
