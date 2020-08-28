# Käyttöohje

## Maven

Ohjelma käyttää [Maven](https://maven.apache.org/) projektinhallintaa, joka täytyy olla asennettuna ohjelman ja testien suorittamiseksi paikallisesti.

## Komennot

Maven komennot täytyy suorittaa kansiossa jossa sijaitsee POM.xml tiedosto.

Projekti voidaan rakentaa ja riippuvudet ladata komennolla `mvn build`.

## Suorittaminen

Ohjelma voidaan paketoida ja käynnistää käyttäen Mavenia komennolla `mvn package`, jonka jälkeen projektikansiossa olevaan target-kansioon ilmestyy suoritettava .jar tiedosto joka suorittaa ohjelman.

Ohjelman voi myös suorittaa ilman paketointia komennolla `mvn compile exec:java -D exec.mainClass=cs.helsinki.fi.App`.

## Syötteet

Käyttäjä voi valita minkä kokoisen labyrintin ohjelma ratkaisee, sekä käytetäänkö rekursiivista- vai while-loop-algoritmia.

## Tehokkuustestien suorittaminen

Ohjelma suorittaa tehokkuustestit kun ohjelmalle annetaan mikä tahansa argumentti.
