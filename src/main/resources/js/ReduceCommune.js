/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
