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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Victor
 */
public class PesquisadorDBpedia {
    
    public List<String> pesquisarLocaisPorEstado(String codigoEstadoDbpedia){
       List<String> lstCidadesEstado = new ArrayList<String>();
       String cidades = "";
        
   		String query1 = " 	PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ " PREFIX : <http://dbpedia.org/resource/>"
				+ " PREFIX d: <http://dbpedia.org/ontology/> "
				+ " SELECT distinct ?dbPediaCidade"
				+ " WHERE "
				+ " { "
                                + " ?dbPediaCidade d:isPartOf :CIDADEX }";
                
                              String codigoPesquisa = ":"+codigoEstadoDbpedia;
                System.out.println(codigoPesquisa);
                query1 =  query1.replaceAll(":CIDADEX", codigoPesquisa);
//                System.out.println(query1);
		ResultSet results = SPARQLUtil.INSTANCE.dbpediaQuery(query1);
		//ResultSetFormatter.out(System.out, results);
                
            while(results.hasNext()){
                //System.out.println("entrou aqui!");
                QuerySolution qs = results.next();

                 cidades =  qs.getResource("dbPediaCidade").getURI().toString();
                 
                 lstCidadesEstado.add(cidades);
                 //System.out.println("------------->"+descricaoCidade+"--");
            }
        
        return lstCidadesEstado;         
    }
    
    
    public String pesquisarCidade(String codigoCidadeDbpedia){
        String descricaoCidade = "";
        
                    String query1 = " 	PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                    + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                    + " PREFIX : <http://dbpedia.org/resource/>"
                    + " PREFIX d: <http://dbpedia.org/ontology/> "
                    + " SELECT distinct ?descricao "
                    + " WHERE "
                    + " { "
                    + " :CIDADEX d:abstract ?descricao ."
                    + " FILTER ( lang(?descricao) = \"en\" )" + " }";
                                

                String codigoPesquisa = ":"+codigoCidadeDbpedia;
                System.out.println(codigoPesquisa);
                query1 =  query1.replaceAll(":CIDADEX", codigoPesquisa);
//                System.out.println(query1);
		ResultSet results = SPARQLUtil.INSTANCE.dbpediaQuery(query1);
		//ResultSetFormatter.out(System.out, results);
                
            while(results.hasNext()){
                //System.out.println("entrou aqui!");
                QuerySolution qs = results.next();

                 descricaoCidade =  qs.getLiteral("descricao").toString();


                 //System.out.println("------------->"+descricaoCidade+"--");
            }
        
        return descricaoCidade;
    }
    
}
