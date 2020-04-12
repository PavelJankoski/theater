Pavel Jankoski 171141
Ovaa seminarska e po predmetot Veb Programiranje na fakultetot FINKI

Mojata tema e veb stranica za teatar vo koja se prikazuvaat pretstavite koi sme gi kreirale
no postoi i moznost za izmenuvanje na vekje kreirana pretstava kako i brisenje na istata. Pri kreiranje na pretstava
ima moznost za kreiranje na nov akter koi ne glumel vo dosegashnite pretstavi kako i moznost za brisenje na istiot dokolku
ne glumi vo niedna prestava. Moze da se dodade i nova scena, a pri nejzino dodavanje se kreira i rasporedot na sedista vo istata.

Vo Pocetniot tab(home) se prikazuvaat pretstavite koi se emituvaat vo teatarot vo vid na vrteleska(carousel) a so pritiskanje 
na kopceto Open Show se prikazuvaat detalite za pretstavata. Vo Shows tabot se prikazuvaat po 6 pretstavi so pagination
vo vid na kartici pri sto mozeme da klikne na View Details i da se prikazat site detali za pretstavata. Isto taka mozeme da ja 
izbriseme ili da ja izmenime pretstavata.  Vo ovoj tab moze da se prebara odredena pretstava po ime ili opis.
Vo naredniot tab Schedule se prikazuva raspored na izveduvanje na pretstavite podredeni po datum na izveduvanje, a pri pominuvanje 
na datumot na izveduvanje pretstavata ne se prikazuva. Tuka moze da klikneme na kopceto Buy tickets pri sto se prikazuva 
rasporedot na sedista vo salata, a kupuvanjeto na sedista ke go implementiram ponatamu. Vo Contact tabot se prikazani nekoi osnovni
podatoci za kontakt a tabot Buy Tickets ne nosi na Schedule.

Bazata na podatoci e implementirana so postgre na porta 9666(ime na baza theater2) pri sto backend delot se startuva klasicno.
Frontend delot se startuva so vleguvanje vo direktoriumot na proektot a potoa vo frontend pa theater(cd frontend/theater)
pa potoa npm start
