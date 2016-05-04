/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function Reduce(key, values) {
                var outs={_id: null, maladie: null, count: 0, hommes: 0, femmes:0, moins_5an: 0, mixe:0};
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
