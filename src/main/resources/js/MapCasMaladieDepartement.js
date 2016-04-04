/* 
 * Auteur: Gaetan Robert Lescouflair
 * Script Map 
 * 
 * script map for CasMaladie
 * 
 */


function Map () {
         var output= {maladie: this.maladie ,_id: this.zone.Departement };
                    emit(this.zone.Departement, output);
        }
        