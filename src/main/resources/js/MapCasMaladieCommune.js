/* 
 * Auteur: Gaetan Robert Lescouflair
 * Script Map 
 * 
 * script Map for CasMaladie
 * 
 */


function Map () {
 var output= {maladie: this.maladie ,_id: this.zone.Commune,  nombreCas: this.nombreCas, groupeAge: this.groupeAge, sexe: this.sexe };
                    emit(this.zone.Commune, output);
                }


