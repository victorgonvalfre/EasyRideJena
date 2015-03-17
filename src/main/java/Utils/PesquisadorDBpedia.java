/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class PesquisadorDBpedia {
    
    public List<String> lstInfoCidade (String cidade){
        List<String> lstInfo =  new ArrayList<String>();
        
        
        
        return lstInfo;
    }
    
    
    public ResultSet pesquisarCidade(String codigoCidadeDbpedia){
        
                    String query1 = " 	PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                    + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                    + " PREFIX : <http://dbpedia.org/resource/>"
                    + " PREFIX d: <http://dbpedia.org/ontology/> "
                    + " SELECT distinct ?descricao ?pages "
                    + " WHERE "
                    + " { "
                    + " :CIDADEX d:abstract ?descricao ."
                    + " :CIDADEX d:wikiPageExternalLink  ?pages ."
                    + " FILTER ( lang(?descricao) = \"en\" )" + " }";
                                

                String codigoPesquisa = ":"+codigoCidadeDbpedia;
                System.out.println(codigoPesquisa);
                query1 =  query1.replaceAll(":CIDADEX", codigoPesquisa);
                System.out.println(query1);
		ResultSet results = SPARQLUtil.INSTANCE.dbpediaQuery(query1);
		//ResultSetFormatter.out(System.out, results);
                
                      while(results.hasNext()){
                    System.out.println("entrou aqui!");
                    QuerySolution qs = results.next();

                     String albumName =  qs.getLiteral("descricao").toString();
                    //Literal artistName = qs.getLiteral("pages");

                     System.out.println(albumName+"--");
                }
        
        return results;
    }
    
}
