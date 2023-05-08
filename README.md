# library-management-system
###### Saityno paslaugų pirmas darbas
## Instrukcija
### 1.1 XML dokumentai su DTD ir XSD
#### 1. XML dokumentas _"library.xml"_ yra aplanke "1.1 Part" 
#### 2. XML dokumentas su DTD _"library_with_DTD.xml"_ yra aplanke _"1.1 Part"_
#### 3. XML dokumentas su XSD _"library_XSD.xml"_ ir XSD dokumentas _"library_XSD.xsd"_ yra aplanke "1.1 Part" 
### 1.2 Serveris-klientas ir POJO klasės
###### Klasės yra _"src/main/java/lt/viko/eif/gmauza/librarymanagement"_ aplanke
###### Norint išbandyti serverio kliento funkcionalumą reikalingas ActiveMQ įrankis https://activemq.apache.org/components/classic/download/
#### 1. Serverio klasė _"ActiveMQServer.java"_. Paleidžiame šią klasę, kad patalpintume žinutę ActiveMQ serveryje žinučių eilėje
#### 2. Kliento klasė _"ActiveMQClient.java"_. Paleidžiame šią klasę, kad nuskaitytume žinutę iš ActiveMQ serverio eilės
#### 3. POJO klasės _"src/main/java/lt/viko/eif/gmauza/librarymanagement/model"_
#### 4. POJO į XML ir XML į POJO klasė _"JaxbMain.java"_
#### 5. _"ActiveMQClient.java"_ gauna iš ActiveMQ eilės žinutę, ją validuoja pagal xsd schema ir atspaudina objektą
#### 6. _"Main.java"_ klasėje yra sukuriamas objektas ir transformuojamas į XML. XML atspausdinamas


