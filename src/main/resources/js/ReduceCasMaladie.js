/* 
 * Auteur: Gaetan Robert Lescouflair
 * Script Reduce 
 * 
 * script Reduce for CasMaladie
 * 
 */


function Reduce(key, values) {
                 var outs={_id: null, maladie: null, count: 0, hommes: 0, femmes:0, moins_5an: 0, mixe:0 };
                values.forEach(function(v){
                    if(v._id !== null){
                        outs._id = v._id;
                    }
                    if(v.maladie !== null){
                        outs.maladie = v.maladie;
                    }
                    
                    if(v.sexe === "Homme")
                    {
                        outs.hommes += v.nombreCas;
                    }
                    if(v.sexe === "Femme"){
                        outs.femmes += v.nombreCas;
                    }
                    if(v.sexe ==="Mixe"){
                        outs.mixe += v.nombreCas;
                    }
                    
                    if(v.groupeAge ==="Moins_de_5")
                    {
                        outs.moins_5an += v.nombreCas;
                    }
 
	outs.count += 1;  
                });
                return outs;
            }