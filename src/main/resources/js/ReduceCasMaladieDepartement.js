/* 
 * Auteur: Gaetan Robert Lescouflair
 * Script Reduce 
 * 
 * script map for CasMaladie
 * 
 */


function Reduce(key, values) {
                 var outs={_id: null, maladie: null, count: 0}
                values.forEach(function(v){
                    if(v._id !== null){
                        outs._id = v._id;
                    }
                    if(v.maladie !== null){
                        outs.maladie = v.maladie;
                    }
 
	outs.count += 1;  
                });
                return outs;
            }