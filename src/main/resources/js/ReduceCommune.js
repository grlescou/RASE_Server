/* 
 * Auteur: Gaetan Robert Lescouflair
 * Script Reduce 
 * 
 * script Reduce for Propriete demographique pour Cartographique Niveau Commune
 * 
 */



function Reduce(key, values) {
                var outs={population : 0, hommes:0 , femmes:0 , moins_5an:0 };
                for(var index = 0; index< values.length; index++){
                 
		outs.population += values[index].population;
		outs.hommes += values[index].hommes;
		outs.femmes += values[index].femmes;
		outs.moins_5an += values[index].moins_5an;
                     
                }
                return outs;
            }
