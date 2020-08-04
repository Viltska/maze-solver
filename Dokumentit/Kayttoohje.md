# Käyttöohje

## Maven

Ohjelma käyttää [Maven](https://maven.apache.org/) projektinhallintaa, joka täytyy olla asennettuna ohjelman ja testien suorittamiseksi.

## Komennot

Ohjelma voidaan paketoida ja käynnistää käyttäen Mavenia komennolla `mvn package` jonka jälkeen /target kansioon ilmestyy suoritettava .jar tiedosto jolla ohjelma voidaan suorittaa.

Ohjelman voi myös suorittaa ilman paketointia komennolla `mvn compile exec:java -Dexec.mainClass=cs.helsinki.fi.App`.

## Syötteet

Ohjelma ei tällä hetkellä tue ulkoisia syötteitä vaan parametrien muuttaminen tapahtuu koodin sisällä.
