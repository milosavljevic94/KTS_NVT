insert into authority(id, authority_naziv) values (1, 'ucenik');
insert into authority(id, authority_naziv) values (2, 'penzioner');
insert into authority(id, authority_naziv) values (3, 'gradjanin');
insert into authority(id, authority_naziv) values (4, 'administrator');
insert into authority(id, authority_naziv) values (5, 'zaposleni');


insert into administratori(id, ime, prezime, email, lozinka) values(1,'admin','admin','admin@kts.com','admin');

insert into korisnik(id, ime, prezime, email, lozinka) values(1,'Petar','Petrovic','pera@kts.com','petar');
insert into korisnik(id, ime, prezime, email, lozinka) values(2,'Nikola','Nikolic','nikola@kts.com','nikola');

insert into stajaliste(id, adresa, lokacijax, lokacijay, naziv) values(1,'Bulevar Cara Lazara 10', 11.04,12.08,'Merkator');
insert into stajaliste(id, adresa, lokacijax, lokacijay, naziv) values(2,'Bulevar Oslobodjenja 13', 14.04,18.08,'Futoska Pijaca');
insert into stajaliste(id, adresa, lokacijax, lokacijay, naziv) values(3,'Bulevar Evrope 11', 1.04,2.08,'BulevarEvrope');

insert into linija(id, broj, naziv, tip) values(1,1,'Centar-Telep','autobus');
insert into linija(id, broj, naziv, tip) values(2,4,'Centar-Bulevar','autobus');
insert into linija(id, broj, naziv, tip) values(3,13,'BulevarEvrope-Centar','tramvaj');

insert into polazak(id, dan, vreme) values(1, "Ponedeljak", "11:45");
insert into polazak(id, dan, vreme) values(2, "Cetvrtak", "13:50");
insert into polazak(id, dan, vreme) values(3, "Subota", "16:45");

insert into linija_polasci(linija_id, polasci_id) values(1,1);
insert into linija_polasci(linija_id, polasci_id) values(2,2);
insert into linija_polasci(linija_id, polasci_id) values(3,3);

insert into linija_stajalista(linija_id, stajalista_id) values(1,1);
insert into linija_stajalista(linija_id, stajalista_id) values(2,2);
insert into linija_stajalista(linija_id, stajalista_id) values(3,3);

insert into vozilo(id, id_linija, id_trenutno_stajaliste, tip) values(1,1,1,'autobus');
insert into vozilo(id, id_linija, id_trenutno_stajaliste, tip) values(2,2,2,'autobus');
insert into vozilo(id, id_linija, id_trenutno_stajaliste, tip) values(3,3,3,'tramvaj');

insert into cenovnik(id, datum_do, datum_od) values(1,'2019-05-13', '2019-01-13');