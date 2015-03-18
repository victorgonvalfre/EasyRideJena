/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Lugar;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;

/**
 *
 * @author Victor
 */
public class GeradorLugar {
    public Lugar lugar;
    
    public Lugar gerarLugar(EnumLocais localenum){
        PesquisadorDBpedia pesquisador = new PesquisadorDBpedia();
        
        lugar = new Lugar();
        lugar.nome = localenum.toString();
        lugar.descricao = pesquisador.pesquisarCidade(localenum.valueDBpedia);

        return lugar;
    }
    

    
}
