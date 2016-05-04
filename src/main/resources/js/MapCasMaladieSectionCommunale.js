/* 
 * Auteur: Gaetan Robert Lescouflair
 * Script Map 
 * 
 * script Map for CasMaladie
 * 
 */



function Map () {
 var output= {maladie: this.maladie ,_id: this.zone.SectionCommunale, nombreCas: this.nombreCas, groupeAge: this.groupeAge, sexe: this.sexe };
                    emit(this.zone.SectionCommunale, output);
                }


