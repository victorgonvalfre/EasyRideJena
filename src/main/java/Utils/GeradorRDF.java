/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import Model.Carona;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.VCARD;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author Jair
 */
public class GeradorRDF extends AbstractQuery {
    
    
     public void gerarRdf(List<Carona> lstCarona) throws IOException{
        String personIRI = "Http://www.EasyRide.br/";
        
        Resource newPerson;
        
        Model model = ModelFactory.createDefaultModel();
        
//        for(Usuarios users: lstUsuarios){
//            newPerson = model.createResource(personIRI + users.getNome().split(" ")[0]);
//            newPerson.addProperty(VCARD.FN, users.getNome());
//            newPerson.addProperty(VCARD.EMAIL, users.getEmail());
//            newPerson.addProperty(VCARD.TEL, users.getTelefone());
//          
//            
//            Resource n = model.createResource();
//            n.addProperty(VCARD.Given, users.getNome().split(" ")[0]);
//            n.addProperty(VCARD.Family, users.getNome().split(" ")[1]);
//            newPerson.addProperty(VCARD.N, n);  
//            
//            Resource n2 = model.createResource();
//            n.addProperty(VCARD.Street, users.getEndereco());
//            newPerson.addProperty(VCARD.ADR, n);  
//            
//        }
        
//                String queryString = "SELECT ?x ?fname WHERE {?x  <http://www.w3.org/2001/vcard-rdf/3.0#FN>  ?fname}";
//                        
//        Query query = QueryFactory.create(queryString);
//        QueryExecution queryExecution = QueryExecutionFactory.create(query,model);
//        ResultSet results = queryExecution.execSelect();        
//        ResultSetFormatter.out(System.out, results, query) ;
//        queryExecution.close();
//        
        
        
                 
        FileWriter out;
        out = new FileWriter(inputFileName);
        model.write( out,"RDF/XML" );
        out.close();
        System.out.println("Arquivo gerado com sucesso: " + inputFileName);
    }
    
}
