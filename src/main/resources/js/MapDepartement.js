/* 
 * Auteur: Gaetan Robert Lescouflair
 * Script Map 
 * 
 * script Map for Propriete demographique pour Cartographique Niveau Departemet
 * 
 */



function Map () {
 var output1= {population :this.properties.POPULATION ,hommes: this.properties.HOMMES, femmes:this.properties.FEMMES, moins_5an: this.properties.MOINS_5_AN };
                    emit(this.properties.DEPARTEMEN, output1);
                }



